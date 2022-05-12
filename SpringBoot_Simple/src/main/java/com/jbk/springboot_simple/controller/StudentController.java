package com.jbk.springboot_simple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.springboot_simple.entity.Student;

@RestController
@RequestMapping()
public class StudentController {

	List<Student> list = new ArrayList<>();
	Student student = null;

	// @RequestMapping(method = RequestMethod.POST)
	@PostMapping(value = "/saveStudent")
	public boolean saveStudent(@RequestBody Student student) {
		list.add(student);

		return true;

	}

	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudent() {

		return list;

	}

	// get all student (sort by marks)
	@GetMapping("/getAllStudentSortByMarks")
	public List<Student> getAllStudentByMarks() {

		return list;

	}

	@GetMapping(value = "/getStudent/{id}")
	public Student getStudentById(@PathVariable int id) { // 103
		for (Student std : list) {
			if (std.getStudentId() == id) {
				student = std;
				break;
			}
		}

		return student;

	}

	@PutMapping(value = "/updateStudent")
	public String updateStudent(@RequestBody Student student) {
		String msg = "Student Not Exists";
		for (Student std : list) {
			if (std.getStudentId() == student.getStudentId()) {
				list.remove(std);
				list.add(student);
				msg = "Updated";
				break;
			}
		}
		return msg;

	}

	@DeleteMapping(value = "/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		String msg = "Student Not Exists";
		for (Student std : list) {
			if (std.getStudentId() == id) {
				list.remove(std);
				msg = "Deleted";
				break;
			}
		}
		return msg;
	}
}
