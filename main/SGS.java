package main;

import java.util.HashMap;

import course.Course;
import course.CourseCatalog;
import derby.SgsDb;
import score.Score;
import student.Student;
import teacher.Teacher;
import user.Admin;
import user.User;
public class SGS {
	public static User currentUser =null;
	public static Admin admin = new Admin("a001","admin");
	public static HashMap<String,Teacher> faculty;//全体教师
	public static HashMap<String,Student> school;//全体学生
	public static CourseCatalog  courseCatalog ;//开课目录
	//初始化全体教师
	public static void initFaculty(){
		faculty = new HashMap<String,Teacher>();
		faculty.put("t001", new Teacher("t001","tom"));
		faculty.put("t002", new Teacher("t002","alice"));
	}
	//初始化全体学生
	public static void initSchool(){
		school = new HashMap<String,Student>();
		school.put("s001", new Student("s001","john"));
		school.put("s002", new Student("s002","bill"));
		school.put("s003", new Student("s003","mary"));
	}
	//初始化开课目录
	public static void initCourseCatalog(){
		initFaculty();
		initSchool();
		courseCatalog = new CourseCatalog();
		
		Teacher  t1 = faculty.get("t001");
		Course  c1 = new Course("c001", "Java", 6, 2011, 2, t1);
		c1.addStudent(school.get("s001"));
		c1.addStudent(school.get("s002"));
		courseCatalog.addCourse(c1);	
		c1.setScore(new Score("s001","c001",90));
		c1.setScore(new Score("s002","c001",70));

		Teacher  t2 = faculty.get("t002");
		Course  c2 = new Course("c002", "数据结构", 4, 2011, 2, t2);
		c2.addStudent(school.get("s001"));
		c2.addStudent(school.get("s003"));
		courseCatalog.addCourse(c2);	
		c2.setScore(new Score("s001","c002",60));
		c2.setScore(new Score("s003","c002",85));
	}
	public static void main(String[] args){
		initCourseCatalog();
	//	SgsDb mydb = SgsDb.getInstance();
		new MainFrame();
	}
}
