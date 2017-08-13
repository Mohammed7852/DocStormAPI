package com.DocStorm.Repositories;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.DocStorm.Models.User;

@Repository
public interface User_Repository extends JpaRepository<User, Integer> {

	//
	// @Query("SELECT u FROM `user` u WHERE u.useremail =?1")
	// User findbyEmail(String email);

	// @Modifying
	// @Transactional
	// @Query("SELECT u FROM `user` u WHERE u.useremail=:qemail")
	// User findbyEmail(@Param("qemail") String email);

}
