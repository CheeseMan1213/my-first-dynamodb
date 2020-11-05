package com.james2ch9developer.my_first_dynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.james2ch9developer.my_first_dynamodb.entity.Student;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableScan
public interface StudentRepository extends CrudRepository<Student, String> {

//	@Autowired
//	private DynamoDBMapper mapper;
//
//	public List<Student> findAll() {
//		mapper.
//	}
//
//	public Student addStudent(Student student) {
//		mapper.save(student);
//		return student;
//	}
//
//	public Student findStudentByStudentId(String studentId) {
//		return mapper.load(Student.class, studentId);
//	}
//
//	public String deleteStudent(Student student) {
//		mapper.delete(student);
//		return "student removed !!";
//	}
//
//	public String editStudent(Student student) {
//		mapper.save(student, buildExpression(student));
//		return "record updated ...";
//	}
//
//	private DynamoDBSaveExpression buildExpression(Student student) {
//		DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
//		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
//		expectedMap.put("studentId", new ExpectedAttributeValue(new AttributeValue().withS(student.getStudentId())));
//		dynamoDBSaveExpression.setExpected(expectedMap);
//		return dynamoDBSaveExpression;
//	}
}
