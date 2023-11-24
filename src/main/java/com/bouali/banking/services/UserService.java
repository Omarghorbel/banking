package com.bouali.banking.services;

import com.bouali.banking.dto.AuthenticationRequest;
import com.bouali.banking.dto.AuthenticationResponse;
import com.bouali.banking.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService extends AbstractService<UserDto> {

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);

    AuthenticationResponse register(UserDto userDto);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
