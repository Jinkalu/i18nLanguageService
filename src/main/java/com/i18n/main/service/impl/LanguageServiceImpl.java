package com.i18n.main.service.impl;

import com.i18n.main.service.LanguageService;
import com.i18n.main.utils.ApiExceptionHandler;
import com.i18n.main.vo.RequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final MessageSource messageSource;

    @Override
    public String sayHello(RequestVO flag) {
        if (Boolean.FALSE.equals(flag.getIsMassage())){
        throw new  ApiExceptionHandler(messageSource.getMessage("exception.code",
                null,LocaleContextHolder.getLocale()),
                messageSource.getMessage("exception.message",
                        null, LocaleContextHolder.getLocale()));
        }
        return "HELLO";
    }
}
