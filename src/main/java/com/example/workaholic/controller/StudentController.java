package com.example.workaholic.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.workaholic.entity.StudentSignUp;
import com.example.workaholic.service.StudentServiceImpl;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/student_signup")
	public StudentSignUp createEmployee(@RequestBody StudentSignUp student) {
		studentServiceImpl.save(student);
		return student;
	}
	
	@GetMapping("/authenticate_user")
	public StudentSignUp authenticateUser(@RequestParam("emailPhone") String emailPhone,
			@RequestParam("password") String password) {
		StudentSignUp studentSignUp = studentServiceImpl.authenticateUser(emailPhone,password);
		return studentSignUp;
	}
	
	@GetMapping("/getStudentDetails/{rollno}")
	public StudentDetails getStudentDetails(@PathVariable("rollno") String rollno) {
//		String jsonString = "{\"fullname\":\"asd\",\"contactno\":\"password\",\"rollno\":\"city\",\"semester\":\"emailPhone\",\"branch\":\"mobile\",\"previousSemResult\":\"PASS/ATKT\"}";
//		String listStr = "[{\"name\":\"asd\",\"password\":\"password\",\"city\":\"city\",\"emailPhone\":\"emailPhone\",\"mobile\":\"mobile\"},{\"name\":\"asd\",\"password\":\"password\",\"city\":\"city\",\"emailPhone\":\"emailPhone\",\"mobile\":\"mobile\"},{\"name\":\"asd\",\"password\":\"password\",\"city\":\"city\",\"emailPhone\":\"emailPhone\",\"mobile\":\"mobile\"}]";
		
		StudentDetails studentDetails = new StudentDetails();
		studentDetails = studentServiceImpl.getStudentDetailsByRollNo(rollno);
		
		return studentDetails;
	}
	
	
	@PostMapping("/student_details")
	public StudentDetails saveStudentDetails(@RequestBody StudentDetails studentDetails) {
		return studentServiceImpl.saveStudentDetails(studentDetails);
	}
	
	@PostMapping("/updateAssignment")
	public Integer updateAssignment(@RequestBody StudentDetailsRequest studentDetailsRequest) {
		return studentServiceImpl.updateAssignment(studentDetailsRequest);
	}
	
	@PostMapping("/updateMarksJson")
	public Integer updateMarksJson(@RequestBody StudentDetailsRequest studentDetailsRequest) {
		return studentServiceImpl.updateMarksJson(studentDetailsRequest);
	}
	
	@GetMapping("/getAssignments")
	public List<StudentDetails> getAssignments() {
		List<StudentDetails> studentDetails = studentServiceImpl.getAssignments();
		return studentDetails;
	}
	
	@PostMapping("/uploadNotes")
	public Integer uploadNotes(@RequestPart("file") MultipartFile file, @RequestPart("fileext") String fileext, @RequestPart("semTxt") String semTxt) throws IOException {
		return studentServiceImpl.uploadNotes(file, fileext, semTxt);
	}
	
	@GetMapping("/getFile")
	public byte[] getFile1() {
		byte[] studentDetails = studentServiceImpl.getFile1();
		return studentDetails;
	}
	
	@GetMapping("/getStudentSubmittedAssignmentsByAssignmentName/{assignmentName}")
	public List<StudentDetails> getStudentSubmittedAssignmentsByAssignmentName(@PathVariable("assignmentName") String assignmentName) {
		List<StudentDetails> studentDetails = studentServiceImpl.getStudentSubmittedAssignmentsByAssignmentName(assignmentName);
		return studentDetails;
	}
	
	@GetMapping("/getStudSbmtdAssignmentFile/{fileId}")
	public StudentDetails getStudSbmtdAssignmentFile(@PathVariable("fileId") Integer fileId) {
		StudentDetails studSbmtdAssgnmtFile = studentServiceImpl.getStudSbmtdAssignmentFile(fileId);
		return studSbmtdAssgnmtFile;
	}
}
