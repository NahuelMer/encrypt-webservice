package com.example.encrypt.controller;

import com.example.encrypt.model.Encrypt;
import com.example.encrypt.service.EncryptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptController {

    private EncryptService encryptService;

    @Autowired
    public EncryptController(EncryptService encryptService){
        this.encryptService = encryptService;
    }

    @PutMapping("/")
    public String updateEncrypt(@Valid  @RequestBody Encrypt entity) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(encryptService.updateEncrypt(entity)).getBody();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(encryptService.updateEncrypt(entity)).getBody();
        }
    }
}
