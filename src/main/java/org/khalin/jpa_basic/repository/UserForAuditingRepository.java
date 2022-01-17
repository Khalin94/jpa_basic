package org.khalin.jpa_basic.repository;

import org.khalin.jpa_basic.entity.UserForAuditing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserForAuditingRepository extends JpaRepository<UserForAuditing, Long> {
}
