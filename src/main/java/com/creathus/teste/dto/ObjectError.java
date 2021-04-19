package com.creathus.teste.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ObjectError {

    private final String message;
    private final String field;
    private final Object parameter;
}