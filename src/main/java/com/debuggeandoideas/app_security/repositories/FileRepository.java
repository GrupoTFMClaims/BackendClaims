package com.debuggeandoideas.app_security.repositories;

import com.debuggeandoideas.app_security.entites.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, String> {
}
