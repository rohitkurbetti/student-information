package com.example.workaholic.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.workaholic.entity.StudentSignUp;


@Repository
public interface StudentSignupRepo extends JpaRepository<StudentSignUp, Long>{

	
	@Query("select new com.example.workaholic.entity.StudentSignUp(s.name,"
			+ "s.password,s.city,s.emailPhone,s.mobile) from StudentSignUp s where s.emailPhone = :emailPhone")
	public StudentSignUp getEntryStudent(@Param("emailPhone") String emailPhone);
	
	
	
}
