package com.javamaster.springsecurityjwt.repository;

import com.javamaster.springsecurityjwt.entity.Detective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectiveRepository extends JpaRepository<Detective, Long> {

	boolean existsByBadgeNumber(String badgeNumber);

	Detective findByBadgeNumber(String badgeNumber);
}
