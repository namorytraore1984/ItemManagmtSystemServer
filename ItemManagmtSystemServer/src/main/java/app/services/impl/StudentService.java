package app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dataobjects.Student;
import app.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();		
		//studentRepository.findAll().forEach(i -> students.add(i));		
		studentRepository.findAll().forEach(students::add);		
		return students;
	}

}
