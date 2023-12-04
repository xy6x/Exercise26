package com.example.amdb.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "please enter id")
    private Integer id ;
    @NotNull
    private Integer productID;
    @NotNull
    @NotEmpty(message = "please enter merchantID")
    private Integer merchantID;
    @NotNull
    @Column(columnDefinition = " int  not null")
    private Integer stock;

}
