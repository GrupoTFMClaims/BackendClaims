package com.debuggeandoideas.app_security.repositories;
import com.debuggeandoideas.app_security.entites.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<CustomerEntity, String> {
    @Query("SELECT c FROM CustomerEntity c WHERE c.email =:email")
    public CustomerEntity getUserByEmail(String email);

    @Query("SELECT c FROM CustomerEntity c WHERE c.id_user =:id_user")
    public CustomerEntity getUserById(Integer id_user);

    @Query("SELECT c FROM CustomerEntity c WHERE c.full_name like :name")
    public List<CustomerEntity> getAllUsersByName(String  name);

    @Query("select c from CustomerEntity c")
    public List<CustomerEntity> getAllUsers();
}