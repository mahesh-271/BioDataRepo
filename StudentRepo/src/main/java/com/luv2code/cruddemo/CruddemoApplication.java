package com.luv2code.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
//		return runner -> {
//			//createStudent(studentDao);
//			//getStudentDetailsBasedOnId(studentDao);
//		//	getListOfStudents(studentDao);
//			//getName(studentDao);
//
//			//queryTheDataByLastName(studentDao);
//			updateStudentDetails(studentDao);
//
//		};
//	}
//
//	private void updateStudentDetails(StudentDao studentDao)
//	{
//		//first initialize the id of the student class
//		int id = 1;
//
//		System.out.println("Updated table key"+ id);
//
//		Student student = studentDao.findById(id);
//
//		//update set the updated name
//
//		student.setFirstName("Mahesh Killu");
//
//		// merge into database table
//
//		studentDao.updateStudentDetails(student);
//
//		//print the updated table
//
//		System.out.println(student);
//
//	}
//
//	private void queryTheDataByLastName(StudentDao studentDao)
//	{
//		List<Student> theStudents = studentDao.queryStudnetsByLastName("Killu");
//
//		for(Student student : theStudents)
//		{
//			System.out.println(student);
//		}
//	}
//
//	private void getName(StudentDao studentDao)
//	{
//		String firstname  = studentDao.getFirstName();
//
//		System.out.println(firstname);
//
//	}
//
//	private void getListOfStudents(StudentDao studentDao)
//	{
//		//get list of students
//		List<Student> studentDao1 = studentDao.findByAll();
//
//		//display the list of students
//
//		for(Student student : studentDao1)
//		{
//			System.out.println(student);
//		}
//	}
//		private void createStudent(StudentDao studentDao)
//		{
//
//			System.out.println("Creating a multiple  students ");
//
//			Student theStudent = new Student("Mahesh","Janagundla","mahesh@gmail.com");
//			Student theStudent1 = new Student("Ramesh","k","ramesh@gmail.com");
//			Student theStudent2= new Student("ganesh","kak","ganesh@gmail.com");
//
//			//save the student into dao
//			studentDao.save(theStudent);
//			studentDao.save(theStudent1);
//			studentDao.save(theStudent2);
//
//			System.out.println("get the Id "+ theStudent.getId());
//		}
//
//		private void getStudentDetailsBasedOnId(StudentDao studentDao) {
//
//		//create a student
//
//			Student student = new Student("John", "smith", "killu@gmail.com");
//
//			//save the student
//
//			studentDao.save(student);
//
//			//get the student id based on student creation
//
//			int id = student.getId();
//
//			System.out.println("Id of the student "+ id);
//
//			//print the student details based on the id
//
//			Student resultStudent = studentDao.findById(id);
//
//			System.out.println("readind the student details based on primary key "+ resultStudent);
//		}
}
