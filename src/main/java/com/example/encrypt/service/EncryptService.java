package com.example.encrypt.service;

import com.example.encrypt.model.Encrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptService<E> {

    public EncryptService() {

    }

    public String updateEncrypt(Encrypt entity) throws Exception {

        String message = "";

        // Se obtienen los valores dentro del body de la request
        int n = entity.getN();
        String code = entity.getKey();
        String text = entity.getText();

        // Verifica que la clave tenga la misma cantidad de cifras que el valor de N
        if (n != code.length())
            throw new Exception("La cantidad de cifras de la clave y N no coinciden.");

        // Se eliminan los espacios en blanco del mensaje a encriptar
        text = text.replaceAll("\\s", "");

        // Divide el texto en subcadenas con la cantidad de cifras de la clave de cifrado
        String[] subtexts = text.split("(?<=\\G.{" + n + "})");
        // Se obtienen las cifras de la clave
        String[] digits = code.split("(?<=\\G.{" + 1 + "})");

        // Recorre las subcadenas a encriptar
        for (String subtext : subtexts) {

            // Se obtienen los caracteres de la subcadena
            String[] chars = subtext.split("(?<=\\G.{" + 1 + "})");

            // Se obtienen los caracteres con los digitos de la clave para encriptar
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < digits.length; j++) {

                    // Compara los caracteres y digitos que se encuentren en posiciones pares e impares
                    if (i != j) continue;

                    char c1 = chars[i].charAt(0);
                    char c2 = digits[j].charAt(0);

                    // Obtiene el numero entero del digito de la clave
                    int digit = c2 - '0';

                    // Realiza el desplazamiento del caracter con el digito
                    int encryptedChar = c1 + digit;

                    // Verifica la condicion ciclica del alfabeto y se añade el digito al mensaje
                    if (encryptedChar > 'Z')
                        message += (char) (encryptedChar - (28 - digit));
                    else
                        message += (char) encryptedChar;

                }

            }

        }

        // Retorna el mensaje ya encriptado
        return message;

    }
}
