package com.bouali.banking.services;

import com.bouali.banking.dto.ContactDto;

import java.util.List;

public interface ContactService extends AbstractService<ContactDto> {
    List<ContactDto> findAllByUserId(Integer userId);
}
