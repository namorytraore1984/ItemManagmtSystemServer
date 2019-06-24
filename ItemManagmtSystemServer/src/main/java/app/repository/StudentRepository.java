package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.dataobjects.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
