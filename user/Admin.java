package user;

public class Admin extends User{
	public Admin(String userNo,String name){
		super(userNo,name,User.USER_TYPE_ADMIN);
	}
}
