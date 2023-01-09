package com.i18n.main.controller;


import com.i18n.main.vo.RequestVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class languageConṭroller {

    public ResponseEntity<String> sayHello(@RequestBody @Valid RequestVO requestVO){

        return ResponseEntity.ok().body("HELLO");
    }
}
