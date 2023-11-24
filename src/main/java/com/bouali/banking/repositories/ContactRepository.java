package com.bouali.banking.repositories;

import com.bouali.banking.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    List<Contact> findAllByUserId(Integer userId);
}
