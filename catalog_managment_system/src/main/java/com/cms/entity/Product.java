package com.cms.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotBlank
    private String description;
    @NotNull
    private double price;
    @NotNull
    private int quantity;
    @NotBlank
    private String category;
    private Date dateAdded;
}

