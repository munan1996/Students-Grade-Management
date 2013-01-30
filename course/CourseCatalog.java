package course;


import java.util.HashMap;

public class CourseCatalog {

	private HashMap<String, Course> courses;

	public CourseCatalog() {
			courses = new HashMap<String, Course>();
	}

	public void addCourse(Course c) {
		String key = c.getCourseNo();
		courses.put(key, c);
	}

	public Course findCourse(String courseNo) {
		return courses.get(courseNo);
	}

}
