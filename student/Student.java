package student;

import user.User;

public class Student extends User{
	private String sex;
	private int age;
	private String department;
	public Student(String studentNo,String name,String sex,int age,String department){
		super(studentNo,name,User.USER_TYPE_STUDENT);
		this.sex = sex;
		this.age = age;
		this.department = department;
	}
	public Student(String studentNo,String name){
		this(studentNo,name,"��",19,"�����ϵ");
	}	

	
}
