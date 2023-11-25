package com.cab.cabbooking.repository;

import com.cab.cabbooking.dtos.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSessionRepo,Integer> {


    Optional<CurrentUserSession> findByUUid(String uuid);

    @Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'admin'")
    Optional<CurrentUserSession> findByUuidAndRole(@Param("uuid") String uuid);
}
