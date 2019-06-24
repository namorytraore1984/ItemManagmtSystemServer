package app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dataobjects.Student;
import app.services.impl.StudentService;

@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getStudents()
	{
		List<Student> students = studentService.getStudents();
		return students;
	}

}
