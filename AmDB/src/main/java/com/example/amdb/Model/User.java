package com.example.amdb.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "please enter id")
    private Integer id;
    @NotEmpty(message = "please enter user Name")
    @Column(columnDefinition = "varchar(20) not null")
    private String userName;
    @NotEmpty(message = "please enter password")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;
    @NotEmpty(message = "please enter emil")
    @Column(columnDefinition = "varchar(20) not null")
    private String email;
    @NotEmpty(message = "please enter role")
    @Column(columnDefinition = "varchar(8) not null check(role ='admin' or role ='customer")
    private String role;
    @Positive
    @Column(columnDefinition = " int  not null")
    @NotNull(message = "balance should not NULL")
    private Integer balance;
}
