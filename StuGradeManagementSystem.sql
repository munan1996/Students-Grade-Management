connect 'jdbc:derby:myDB;create=true';
create table Admin(userNo varchar(10) primary key, name varchar(20),
			userPw varchar(10));
create table Teacher(userNo varchar(10) primary key, name varchar(20),
			userPw varchar(10));
create table Stu(userNo varchar(10) primary key, name varchar(20),
			userPw varchar(10),sex varchar(2),
			age int,department varchar(16));
create table Score(studentNo varchar(10), courseNo varchar(10),
			grade int, primary key(studentNo,courseNo));
 

 
