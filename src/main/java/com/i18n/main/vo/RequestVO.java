package com.i18n.main.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestVO {

    @NotNull(message = "{com.i18n.main.vo.username.NotNull.message}")
    private String username;
    private Boolean isMassage;
}
