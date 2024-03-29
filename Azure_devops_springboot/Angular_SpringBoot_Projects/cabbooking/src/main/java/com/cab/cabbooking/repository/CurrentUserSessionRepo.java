package com.cab.cabbooking.repository;

import com.cab.cabbooking.entity.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession,Integer> {


    List<CurrentUserSession> findByuuid(String uuid);

    @Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'admin'")
    List<CurrentUserSession> findByUuidAndRole(@Param("uuid") String uuid);
}
