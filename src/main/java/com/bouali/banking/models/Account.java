package com.bouali.banking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Account extends AbstractEntity {

    //FR23 3333 1111 4444 5555
    private String iban;


    @OneToOne
    @JoinColumn(name ="id_user")
    private User user;

}
