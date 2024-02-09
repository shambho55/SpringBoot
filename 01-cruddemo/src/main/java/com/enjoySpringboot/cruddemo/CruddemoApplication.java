package com.enjoySpringboot.cruddemo;

import com.enjoySpringboot.cruddemo.dao.StudentDAO;
import com.enjoySpringboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting All Students");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count : " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id : " + studentId);

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id : primary key
		int studentId = 1;
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to " scooby"
		System.out.println("Updating student ... ");
		myStudent.setFirstName("One");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated Student : " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Direction");

		// display list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display a list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating a new student object ... ");
		Student tempStudent = new Student("Mickey","Mouse","mouse@mickey.com");

		// save the student
		System.out.println("Saving the element ... ");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated id : " + theId);


		// retrieve student based on the id : primary key
		System.out.println("Retrieving Student with id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student : " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple objects
		System.out.println("Creating new Student Object ... ");
		Student tempStudent1 = new Student("One","Direction","direction@one.com");
		Student tempStudent2 = new Student("Two","Paths","paths@two.com");
		Student tempStudent3 = new Student("Little","movies","movies@little.com");

		// save student objects
		System.out.println("Saving students ... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new Student Object ... ");
		Student tempStudent = new Student("Paul","Doe","paul@one.com");


        // save student object
		System.out.println("Saving the address ... ");
		studentDAO.save(tempStudent);


		// display id of the saved student
		System.out.println("Saved student. Generated id : " + tempStudent.getId());

	}

}
