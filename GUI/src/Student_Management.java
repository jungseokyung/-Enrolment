
import java.util.*;

/*
- Add a menu so user can select desired function.
- Search student by ID and name
- Print information of all students
- Update student information
- Delete student information 
 */

public class Student_Management{

	public static Student_[] stds = new Student_[100];
	//1사람당, 10과목씩 저장 가능.
	public static int[] course = new int [100];
	public static Course_[] cor = new Course_[10];
	
	public static CoureManagement[] c = new CoureManagement[10];
	
	
	static CoureManagement cm = new CoureManagement();
	static Course_ cs = new Course_();
	
	public static int nextStudent=0;
	private static int search;
	public static int course_index=0;
	
	private int[] Course= new int [100];////1사람당, 10과목씩 저장 가능.
	
	private int size=0;
	
	
	public static void main(String[] args) {
	
		
	}
	
/*	public boolean Register(int st_id,int c_id) { //AddLast
		Course[size]=c_id;
		size++;
		return true;
		
	}
	
	public int indexOf(Object o) {
		for(int i=0; i<size; i++) {
			if(o.equals(Course[i])) {
				return i;
			}//if
		}//for
		return -1;
	}
	
	public int Drop(int index) {
		int removed = Course[index];
		
		for (int i=index; i<=size-1; i++) {
			Course[i-1]=Course[i];
		}
		size--;
		Course[size]=(Integer) null;
		return removed;
	}*/
	
/*	for(int i=search; i<nextStudent; i++) {
		if(stds[i].getID()==ID) {
			for(int j=i; j<nextStudent-1; j++) {
				stds[j]=stds[j+1];
			}//for
		}//if									
	}//for
*/
	public static String Drop(int s_id, int c_id) {//학생과 연동
		// TODO Auto-generated method stub
		String s="\n\nERROR : ID is not proper. \n Enter another ID!";
	
		if(ID_Exist(s_id)&&CoureManagement.Course_Exist(c_id)) {
			//Course Delete 하는 것처럼...??
			//삭제된 곳을 알아내서, 그 부분 다음부터, 한 칸식 앞으로 당김.
			for(int j=CoureManagement.ReturnIndex(c_id); j<course_index; j++) {
				//한 칸씩 옮기기
				for(int i=j; i<course_index-1; i++) {
					course[j]=course[j+1]; //학생 테이블에서, 과목을 드랍한거임.
				}
				
			}//for
			s=CoureManagement.Print(c_id)+Search(s_id);
			//course[course_index]=c_id;//학생 데이타의 과목에 과목 추가.임시임..!!
			course_index--;//학생이 과목을 드랍했으므로, 한 과목 적게 듣는거임.
			//stds[search].setCourse(course);//지금 추가한 과목을, 학생 데이타 클래스에 저장.
			
		}
		return s;
		
	}
	
			//return String = 
	public static Object Register(int st_id,int c_id) {//학생과 연동
		// TODO Auto-generated method stub //학생 꺼에 과목 배열을 추가.  //어레이 리스트ㅡ...??
		String s="\n\nERROR : ID is not proper! \n Enter another ID";
		if(ID_Exist(st_id)&&CoureManagement.Course_Exist(c_id)) {
		
			course[course_index]=c_id;//학생 데이타의 과목에 과목 추가.임시임..!!
			course_index++;//추가추가.
			stds[search].setCourse(course);//지금 추가한 과목을, 학생 데이타 클래스에 저장.
			//s=stds[search].setCourse(course);
		}//if
			
		//return cs.getStudent();
		//(course_ID);
		return stds[search].getCourse(); //과목 ID만 가져오기.
	}


	public static void GPA() {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Student ID");
		int ID=input.nextInt();
		double total=0;
		double gpa;
		
		if(ID_Exist(ID)) {
			System.out.println("Enter number of subject:");
			int subject=input.nextInt();
			double score[]= new double [subject];
			System.out.println("Enter Student score:");
			
			for(int i=0; i<subject; i++) {
				score[i]=input.nextDouble();
				total=score[i]+total;
			}
			gpa=total/subject;
			
			stds[search].setGPA(gpa);
	
			System.out.println("GPA: "+ gpa);
			
		}//if
	}

	public static String Delete(int ID) {
		// TODO Auto-generated method stub
		String s=null;
		if(ID_Exist(ID)) {
			s=Search(ID);
			//삭제시엔, 무조건 "지금" 지우는 그 인덱스부터 시작...!!
			for(int i=search; i<nextStudent; i++) {
				if(stds[i].getID()==ID) {
					for(int j=i; j<nextStudent-1; j++) {
						stds[j]=stds[j+1];
					}//for
				}//if									
			}//for
			
			nextStudent--;
		}//if
		else
			s="/n/nERROR : ID is not proper.\n Enter again.";
		return s;
	}

	public static String Update(int ID,int UP_ID) {
		String s="/n/nERROR : ID is not proper.\n Enter again.";
		// TODO Auto-generated method stub

		if(ID_Exist(ID) && !(ID_Exist(UP_ID))) {
		//	System.out.println("Enter an update ID: ");
			stds[search].setID(UP_ID);
			s="/nStudent ID: "+stds[search].getID()+"\nStudent Name: "+stds[search].getName()+"\nStudent EmailAddress"+stds[search].getEmailAddress();
		}
		else 
			return s;
		
		return s;
	}

	//Course 정보 출력.
/*	public static String Print(int c_ID) {//인자 추가 안해도??
		// TODO Auto-generated method stub
		String s=null;
	
		//course id를 연동해,  course class에서, 정보를 가져온다.
//		String Name=cs.getName();
//		int Professor=cs.getProfessor();
	
		cm.ReturnIndex(c_ID);
		String Name = 
		//index에 있는 걸 가져와야되는뎁...                                   
	//	for(int i=0; i<course_index; i++) {
			s="\n"+" )Course ID: "+course+"Course Name: "+Name+"Course's Professor: "+ Professor;
	//	}
		return s;
	}
	public static String PrintAll() {//인자 추가 안해도??
		// TODO Auto-generated method stub
		String s=null;
	
		//course id를 연동해,  course class에서, 정보를 가져온다.
	
		//index에 있는 걸 가져와야되는뎁...                                   
		for(int i=0; i<course_index; i++) {
			String Name=cs.getName();
			int Professor=cs.getProfessor();
			
			s="\n"+i+" )Course ID: "+course[i]+"Course Name: "+Name+"Course's Professor: "+ Professor;
		}
		return s;
	}
*/
	public static String Search(int ID) {
		// TODO Auto-generated method stub
		String s="/n/nERROR :  ID is not proper. Enter Proper ID";
		String c=null;
		if(ID_Exist(ID)){
			
			stds[search].getID();
			stds[search].getName();
			stds[search].getEmailAddress();
			stds[search].getGPA();
			s="/nStudent ID: "+stds[search].getID()+"\nStudent Name: "+stds[search].getName()+"\nStudent EmailAddress :"+stds[search].getEmailAddress()+"\nStudent's GPA: "+stds[search].getGPA()+c;
			
			if(course_index!=0) {
				for(int i=0; i<course_index; i++) {
					c=c+course[course_index];//학생 데이타의 과목에 과목 추가.임시임..!!
					//c=stds[search].getCourse(); //과목 ID만 가져오기.
					//하지만, 이 ID들을 또 가져와야 해..!!!!
				}//for
			}//if	
			else
				c="\nStudent didn't register the course.n";
			
		}//if
		//return search;	
		return s+c;
	}

	public static void Add(int ID, String name, String emailAddress,double gpa) {
//교수니		 

			stds[nextStudent]=new Student_();
			stds[nextStudent].setID(ID);
			stds[nextStudent].setName(name);
			stds[nextStudent].setEmailAddress(emailAddress);
			stds[nextStudent].setGPA(gpa);
			nextStudent++;

	}

	public static boolean ID_Exist(int st_id) {

		if(nextStudent !=0) {
			for(int i=0; i<nextStudent; i++) {
				if(st_id==stds[i].getID()) {
					search=i;
					return true;
				}//if		
			}//for
		}//if
		return false;  
	}

	
}
