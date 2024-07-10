package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserUpdateRepository extends JpaRepository<UserEntity, String> {

}
