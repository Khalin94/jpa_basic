package org.khalin.jpa_basic.repository;

import org.khalin.jpa_basic.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
