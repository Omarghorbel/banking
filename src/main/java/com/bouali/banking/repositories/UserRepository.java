package com.bouali.banking.repositories;

import com.bouali.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {



    Optional<User> findByEmail(String email);

    //select * from User where firstname = 'ali'
    public List<User> findAllByFirstname(String firstname);

    //select * from User where firstname like 'Ali'
    public List<User> findAllByFirstnameContaining(String firstname);


    //select * from User where firstname like '%Ali%'
    public List<User> findAllByFirstnameContainingIgnoreCase(String firstname);


    //select * from User u inner join account a on u.id =a.id_user and a.iban = 'iban';
    public List<User> findAllByAccountIban(String iban);


    //select * from user where firstname = '%ali%' and email = 'ghromar@gmail.com';
    User findByFirstnameContainingIgnoreCaseAndEmail(String firstname, String email);

    // les annotation Query *******************************************
    //    @Query(" select * from User where firstname = :firstname")
    // lorsque j ecris directement from il comprend que j ecris select* par defaut aussi
    // au lieu d utiluser les nom des table on utilise les nom des classe
    @Query("from User where firstname = :firstname")
    public List<User> searchByFirstname(String firstname);

    @Query("from User where firstname = '%:firstname%'")
    public List<User> searchByFirstnameContaining(String firstname);

//    @Query("from User where firstname = :fn")
//    public List<User> searchByFirstname(@Param("fn") String firstname);

    @Query("from User u inner join Account a on u.id=a.user.id where a.iban= :iban")
    public List<User> searchByAccountIban(String iban);

    // ******************************************************************

    // les annotation Query Native **************************************
    @Query(value = "select * from _user u inner join account a on u.id =a.id_user and a.iban = :iban", nativeQuery = true)
    public List<User> searchByAccountIbanNative(String iban);

    // ******************************************************************


}
