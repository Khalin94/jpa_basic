package org.khalin.jpa_basic.repository;

import org.khalin.jpa_basic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
