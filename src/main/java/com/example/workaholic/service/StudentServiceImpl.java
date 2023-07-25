package com.example.workaholic.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.workaholic.controller.StudentDetails;
import com.example.workaholic.controller.StudentDetailsRequest;
import com.example.workaholic.entity.StudentSignUp;
import com.example.workaholic.repo.StudentDetailsRepository;
import com.example.workaholic.repo.StudentSignupRepo;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentSignupRepo studentSignupRepo;
	
	@Autowired
	private StudentDetailsRepository studentDetailsRepository;
	
	
	
	public StudentSignUp save(StudentSignUp student) {
		return studentSignupRepo.save(student);
	}

	public StudentSignUp authenticateUser(String emailPhone, String password) {
		StudentSignUp studentSignUp = studentSignupRepo.getEntryStudent(emailPhone);
		
		if(studentSignUp != null) {
			if(studentSignUp.getPassword().equals(password)) {
				return studentSignUp;
			}
		}
		return new StudentSignUp();
	}

	public StudentDetails saveStudentDetails(StudentDetails studentDetails) {
		return studentDetailsRepository.save(studentDetails);
	}

	public StudentDetails getStudentDetailsByRollNo(String rollno) {
		return studentDetailsRepository.findByRollNo(Integer.valueOf(rollno));
	}

	public Integer updateAssignment(StudentDetailsRequest studentDetailsRequest) {
		return studentDetailsRepository.updateAssignmentByBranchSemester(studentDetailsRequest.getAssignmentName(),studentDetailsRequest.getQueList().toString(),studentDetailsRequest.getBranch(),studentDetailsRequest.getSemester());
	}

	public List<StudentDetails> getAssignments() {
		return studentDetailsRepository.getAssignments();
	}

	public Integer updateMarksJson(StudentDetailsRequest studentDetailsRequest) {
		return studentDetailsRepository.updateMarksJsonByRollno(studentDetailsRequest.getRollno(),studentDetailsRequest.getMarksJson());
	}

	public Integer uploadNotes(MultipartFile file, String fileext, String semTxt) throws IOException {
		String fileExt = fileext.split("/")[1];
		byte[] fileData = file.getBytes();
		return studentDetailsRepository.uploadNotes(fileData, fileExt, semTxt);
	}

	public byte[] getFile1() {
		return studentDetailsRepository.getFile1();
	}

	public List<StudentDetails> getStudentSubmittedAssignmentsByAssignmentName(String assignmentName) {
		return studentDetailsRepository.getByAsssignmentName(assignmentName);
	}

	public StudentDetails getStudSbmtdAssignmentFile(Integer fileId) {
		return studentDetailsRepository.getStudSbmtdAssignmentFile(fileId);
	}

	
	
	
}
