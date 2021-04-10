
import java.util.*;

/*
 - Add Courese
  - Search Course
  - Update Course Information
  - Delete Course Information
  - Register course
  - Drop course
 */

public class Course_ {

	private String Course;
	private int[] Student=new int [10];
	private int ID;
	private String Name;
	private int Professor;
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		this.ID=id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}


	public int getProfessor() {
		return Professor;
	}


	public void setProfessor(int professorID) {
		this.Professor = professorID;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public int[] getStudent() {
		return Student;
	}

	public void setStudent(int[] student) {
		Student = student;
	}
	
	
}

