package com.example.workaholic.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.workaholic.controller.StudentDetails;

@Transactional
@Repository
public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer>{

	@Transactional
	@Modifying
	@Query("update StudentDetails set assignmentName = :assignmentName, assignment = :assignment where branch=:branch and semester=:semester")
	int updateAssignmentByBranchSemester(@Param("assignmentName") String assignmentName, @Param("assignment") String assignment,@Param("branch") String branch, @Param("semester") String semester);

	@Query("select sd from StudentDetails sd where sd.rollno=:rollno")
	StudentDetails findByRollNo(@Param("rollno") Integer rollno);

	@Transactional
	@Modifying
	@Query("update StudentDetails set marksJson = :marksJson where rollno=:rollno ")
	int updateMarksJsonByRollno(@Param("rollno") Integer integer,@Param("marksJson") String marksJson);

	@Transactional
	@Modifying
	@Query("update StudentDetails set fileNotes = :fileNotes, file_ext=:fileExt where semester=:semTxt")
	Integer uploadNotes(@Param("fileNotes") byte[] fileNotes,@Param("fileExt") String fileExt,@Param("semTxt") String semTxt);

	@Query("select sd.fileNotes from StudentDetails sd where sd.rollno=12")
	byte[] getFile1();

	@Query("select distinct new com.example.workaholic.controller.StudentDetails(sd.assignmentName) from StudentDetails sd")
	List<StudentDetails> getAssignments();

	@Query("select sd from StudentDetails sd where sd.assignmentName=:assignmentName")
	List<StudentDetails> getByAsssignmentName(String assignmentName);

	@Query("select sd from StudentDetails sd where sd.rollno=:rollno")
	StudentDetails getStudSbmtdAssignmentFile(@Param("rollno") Integer fileId);

}
