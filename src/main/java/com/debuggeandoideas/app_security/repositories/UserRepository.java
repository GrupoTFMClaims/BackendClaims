package com.debuggeandoideas.app_security.repositories;
import com.debuggeandoideas.app_security.entites.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<CustomerEntity, String> {
    @Query("SELECT c FROM CustomerEntity c WHERE c.email =:email")
    public CustomerEntity getUserByEmail(String email);

}