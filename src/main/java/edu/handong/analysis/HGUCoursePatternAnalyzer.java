package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students; //instance
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines); //lines 에서 중복안되게 학생만 뽑아내서 넣기
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines); //lines 에서 중복안되게 코스만 뽑아내서 넣기
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		int i=0,j=0;
		while(lines[i]!=null) {
			Student elementStudent = new Student(lines[i].trim().split(",")[1]);
			if (studentExist(students,elementStudent)) {
				students[j]=elementStudent;
				System.out.println(elementStudent);
				j++;
				i++;}
			else i++;}
		//trim(), split() 써서 lines 쪼개고 거기서 두번쨰 index들을  studentExist를 써서 비교해가며 중복안되게 넣기
		// TODO: implement this method
		
		
		return students;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		int i=0;
		while(students[i]!=null)
			if(student==students[i])
				return false;
		return true;
		// TODO: implement this method
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		int i=0,j=0;
		while(lines[i]!=null) {
			Course elementCourse = new Course(lines[i].trim().split(",")[2]);
			if (courseExist(courses,elementCourse)) {
				courses[j]=elementCourse;
				j++;
				i++;}
			else i++;}		
		// TODO: implement this method
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		int i=0;
		while(courses[i]!=null)
			if(course==courses[i])
				return false;
		return true;
		
		// TODO: implement this method
	}

}
