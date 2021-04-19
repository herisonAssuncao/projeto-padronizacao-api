package com.creathus.teste.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo nome é obrigatório")
    private String name;
    @NotEmpty(message = "Campo descrição é obrigatório")
    private String description;
}
