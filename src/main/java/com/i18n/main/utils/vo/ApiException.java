package com.i18n.main.utils.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ApiException {
    private final String code;
    private final String message;
}
