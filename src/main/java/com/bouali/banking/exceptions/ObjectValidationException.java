package com.bouali.banking.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

//a comprendre cheaked and uncheaked Exception
@AllArgsConstructor
public class ObjectValidationException extends RuntimeException{

    @Getter
    private final Set<String> violations;

    @Getter
    private final String violationSource;

}
