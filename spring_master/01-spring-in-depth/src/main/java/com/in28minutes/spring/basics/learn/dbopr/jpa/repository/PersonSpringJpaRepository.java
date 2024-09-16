package com.in28minutes.spring.basics.learn.dbopr.jpa.repository;

import com.in28minutes.spring.basics.learn.dbopr.jdbc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringJpaRepository extends JpaRepository<Person,Integer> {
}
