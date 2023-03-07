package com.example.encrypt.model;

import jakarta.validation.constraints.*;

public class Encrypt {

    @NotNull
    @Min(value = 1, message = "El valor de N debe ser 1 como minimo")
    @Max(value = 9, message = "El valor de N debe ser 9 como maximo")
    private int n;


    @NotEmpty
    private String key;

    @NotEmpty
    @Size(min = 1, max = 100000, message = "Solo se permite texto entre 1 y 10000 caracteres")
    private String text;

    public Encrypt(int n, String key, String text) {
        this.n = n;
        this.key = key;
        this.text = text;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
