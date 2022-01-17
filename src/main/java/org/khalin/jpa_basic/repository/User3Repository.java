package org.khalin.jpa_basic.repository;

import org.khalin.jpa_basic.entity.User3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface User3Repository extends JpaRepository<User3, Long> {

    Optional<User3> findByUserNameAndAddress(String userName, String address);

//    @Query("select u from User3 u where u.address=:ads")
//    Page<User3> findAllByAddress(@Param("ads") String address, Pageable pageable);

    Page<User3> findAllByAddress(String address, Pageable pageable);
}
