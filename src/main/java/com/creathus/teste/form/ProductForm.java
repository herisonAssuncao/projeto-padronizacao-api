package com.creathus.teste.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductForm {
    @NotEmpty(message = "Campo nome é obrigatório")
    private String name;
    @NotEmpty(message = "Campo descrição é obrigatório")
    private String description;
}