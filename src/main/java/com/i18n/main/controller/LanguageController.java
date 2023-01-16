package com.i18n.main.controller;


import com.i18n.main.service.LanguageService;
import com.i18n.main.vo.RequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping("/page")
    public ResponseEntity<String> sayHello(@RequestBody @Valid RequestVO requestVO){
        return ResponseEntity.ok().body(languageService.sayHello(requestVO));
    }
}
