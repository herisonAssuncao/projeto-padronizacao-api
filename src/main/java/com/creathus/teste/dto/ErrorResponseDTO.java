package com.creathus.teste.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponseDTO {
    private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ObjectError> errors;
}
