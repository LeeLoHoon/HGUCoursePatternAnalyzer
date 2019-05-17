package edu.handong.analysis;

import java.util.ArrayList;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {

	private String[] lines = { "1999-1, JC Nam, Java Programming", "1999-2, JC Nam, Programming Language Theory",
			"1999-1, JC Nam, Data Structures", "2001-1, JC Nam, Database Systems", "2018-1, SB Lim, Java Programming",
			"2018-2, SB Lim, Programming Language Theory", "2019-1, SB Lim, Data Structures",
			"2019-1, SB Lim, Algorithm Analysis", "2018-1, SJ Kim, Java Programming",
			"2018-2, SJ Kim, Programming Language Theory", "2019-1, SJ Kim, Logic Design",
			"2019-1, SJ Kim, Algorithm Analysis", };

	private int numOfStudents;
	private int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;

	public void run(String[] args) {

		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		students=new ArrayList<Student>();
		students = initiateStudentArrayFromLines(lines);

		System.out.println("Number of All Students: " + numOfStudents);
		for (Student student : students) {
			if (student != null)
				System.out.println(student.getName());
		}
		courses = new ArrayList<Course>();
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for (Course course : courses) {
			if (course != null)
				System.out.println(course.getCourseName());
		}

	}

	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		int j = 0, k;
		String s;
		k = lines.length;
		for (int i = 0; i < k; i++) {
			s = lines[i].trim().split(", ")[1];
			Student elementStudent = new Student(s);
			if (studentExist(students, elementStudent)) {
				students.add(elementStudent);
				j++;
			}
		}
		return students;
	}

	private boolean studentExist(ArrayList<Student> students2, Student student) {
		int a=students.size();
		for(int i=0;i<a;) {
			if (students.get(i).getName().equals(student.getName())) {
				return false;
			}
			i++;
		}
		return true;
		}

	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		int j = 0, k;
		String s;
		k = lines.length;
		for (int i = 0; i < k; i++) {
			s = lines[i].trim().split(", ")[2];
			Course elementCourse = new Course(s);
			if (courseExist(courses, elementCourse)) {
				courses.add(elementCourse);
				j++;
			}
		}
		return courses;
	}

	private boolean courseExist(ArrayList<Course> courses2, Course course) {
		int a=courses.size();
		for(int i=0;i<a;) {
			if(courses.get(i).getCourseName().contentEquals(course.getCourseName())) {
				return false;
			}
			i++;
		}
		return true;
		}

}

