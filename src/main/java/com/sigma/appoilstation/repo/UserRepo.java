package com.sigma.appoilstation.repo;

import com.sigma.appoilstation.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {
    @Override
    Page<User> findAll(Pageable pageable);

//    List<User> findAllByStartDate_MinutesBetween(int startDate_minutes, int startDate_minutes2);

//    @Query(value = "select * from users where startDate between('2011-12-01', date_add('2011-12-01', INTERVAL 7 DAY)");
    List<User> getAllByStartDateBetween(Timestamp startDate, Timestamp startDate2, Sort date);

//    @Query(value = "select users from users where users.active=false")
    List<User> findAllByActiveFalse();
}
