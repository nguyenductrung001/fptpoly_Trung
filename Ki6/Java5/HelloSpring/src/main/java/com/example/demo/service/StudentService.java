package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.utils.CommonConst;

public class StudentService {
	private static final List<Student> _students = new ArrayList<Student>();
	static {
		_students.add(new Student(1, "Trung"));
		_students.add(new Student(2, "Manh"));
	}

	public static List<Student> getAll() {
		return _students;
	}

	public static Student getByMasv(Integer masv) {
		for (Student student : _students) {
			if (student.getMa() == masv) {
				return student;
			}
		}
		return null;
	}

	public static int add(Student student) {
		try {
			_students.add(student);
			return CommonConst.SUCCESS;

		} catch (Exception E) {
			return CommonConst.ERROR;
		}

	}
	public static int updateByMasv(Student student) {
		try {
			for(int i=0;i<_students.size();i++) {
				if(((Student) student.get(i)). getMa() == student.getMa()) {
					_students.set(i, student);
				}
				return CommonConst.SUCCESS;
			}
			return CommonConst.SUCCESS;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}
	public static int deleteByMa(Integer deleteMa) {
		try {
			for(Student student:_students) {
				if(student.getMa()==deleteMa) {
					_students.remove(student);
					return CommonConst.SUCCESS;
				}
			}
			return CommonConst.FAIL;
		} catch (Exception e) {
			return CommonConst.ERROR;
		}
	}

}
