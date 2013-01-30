package teacher;

import user.User;

public class Teacher extends User {
	
	public Teacher(String userNo,String name){
		super(userNo,name,User.USER_TYPE_TEACHER);
	}
}
