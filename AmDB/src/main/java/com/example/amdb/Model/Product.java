package com.example.amdb.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "please enter name")
    @Column(columnDefinition = "varchar(28) not null")
    private String name;
    @NotNull(message = "please enter price")
    @Positive(message = "please enter number positive")
    @Column(columnDefinition = " int  not null")
    private Integer price;
 @NotNull(message = "please enter categoryID")
    private Integer categoryID;
}
