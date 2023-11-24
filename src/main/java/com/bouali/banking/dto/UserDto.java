package com.bouali.banking.dto;

import com.bouali.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {

    private Integer id ;

    //nul, ''
    @NotNull
    @NotEmpty
    @NotBlank // ' '
    private String firstname;

    @NotNull
    @NotEmpty(message = "LASTNAME_IS_EMPTY")
    @NotBlank(message = "LASTNAME_IS_BLANK")
    private String lastname;

    @NotNull(message = "L'email ne doit pas etre vide")
    @NotEmpty(message = "L'email ne doit pas etre vide")
    @NotBlank(message = "L'email ne doit pas etre vide")
    @Email(message = "L'email n'est conforme")
    private String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min =8, max = 16)
    private String password;

    @Past
    private LocalDateTime birthdate;

    public static UserDto fromEntity(User user){
        //null check
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    };

    public static User toEntity(UserDto user){
        //null check
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    };


}
