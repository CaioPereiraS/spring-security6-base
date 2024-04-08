package com.seguranca.securitysix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seguranca.securitysix.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
