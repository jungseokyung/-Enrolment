
import java.util.*;

/*
- Add a menu so user can select desired function.
- Search student by ID and name
- Print information of all students
- Update student information
- Delete student information 
 */ 

public class Professor_Management
{
	public static Professor [] pf = new Professor[100];
	public static Professor p = new Professor();
	public static Professor_Management pm = new Professor_Management();

	
	public static Student_[] stds = new Student_[100];
	
	//1사람당, 10과목씩 저장 가능.
	public static int[] course = new int [100];
	public static Course_[] cor = new Course_[10];
	
	//public static CoureManagement[] c = new CoureManagement[10];
	
	static CoureManagement cm = new CoureManagement();
	static Course_ cs = new Course_();
	
	public static int next=0;
	private static int search;
	public static int course_index=0;
	
	private int[] Course= new int [100];////1사람당, 10과목씩 저장 가능.
	
	private int size=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	
	public static String Drop(int pf_id, int c_id) {//학생과 연동
		// TODO Auto-generated method stub
		String s="\n\nERROR : ID is not proper. \n Enter another ID!";
	
		if(ID_Exist(pf_id)&&CoureManagement.Course_Exist(c_id)) {
			 //Course Delete 하는 것처럼...??
			//삭제된 곳을 알아내서, 그 부분 다음부터, 한 칸식앞으로 당김.
			for(int j=CoureManagement.ReturnIndex(c_id); j<course_index; j++) {
				//한 칸씩 옮기기
				for(int i=j; i<course_index-1; i++) {
					course[j]=course[j+1]; //학생 테이블에서, 과목을 드랍한거임.
				}
			}//for
			//course[course_index]=c_id;//학생 데이타의 과목에 과목 추가.임시임..!!
			course_index--;//학생이 과목을 드랍했으므로, 한 과목 적게 듣는거임.
			pf[search].setCourse(course);//과목 추가...
				
		}
		return s;
		
	}
	
			//return String = 
	public static String Register(int pf_id,int c_id) {//코스과 연동
		// TODO Auto-generated method stub //교수 꺼에 과목 배열을 추가.
		String s="\n\nERROR : ID is not proper! \n Enter another ID";
		if(ID_Exist(pf_id)&&CoureManagement.Course_Exist(c_id)) {
			
			course[course_index]=c_id;//학생 데이타의 과목에 과목 추가.임시임..!!
			
			//pf[search].setCourse(course);//지금 추가한 과목을, 학생 데이타 클래스에 저장.
			//s=pf[search].setCourse(course);
			pf[search].setCourse(course);//이건 한꺼번, 맨 마지막에..!!!
			s=CoureManagement.Search(c_id);		
			course_index++;//추가추가.
		}//if
		
		return s; 
		//pf[search].getCourse(); //과목 ID만 가져오기.
	}

 
	public static String Delete(int ID) {
		// TODO Auto-generated method stub
		String s=null;
		if(ID_Exist(ID)) {
			s=Search(ID);
			for(int i=search; i<next; i++) {
				if(pf[i].getID()==ID) {
					for(int j=i; j<next-1; j++) {
						pf[j]=pf[j+1];
					}//for
				}//if									
			}//for
			
			next--;
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
			pf[search].setID(UP_ID);
			s="/nProfessor ID: "+pf[search].getID()+"\n Name: "+pf[search].getName()+"\nDepartmet :"+pf[search].getDept()+"\nCourse : "+pf[search].getCourse();		}
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

*/
	public static String Course_Print(int p_id) {//인자 추가 안해도??
		// TODO Auto-generated method stub
		String s=null;
		//course id를 연동해,  course class에서, 정보를 가져온다.
//		String Name=cs.getName();
//		int Professor=cs.getProfessor();
	/*	ID_Exist(p_id);
		
		pf[search].getName();
		pf[search].getDept();
		pf[search].getCourse();
	*/	//p.getCourse();
		String P_Name = pf[search].getName();
		String Depth= pf[search].getDept();
		
		int len=pf[search].getCourse().length;
			int[] c=pf[search].getCourse();
	
		//index에 있는 걸 가져와야되는뎁...                                   
		for(int i=0; i<len; i++) {
			//cm.Course_Exist(c[i]);
			//int c_index=cm.ReturnIndex(c[i]); //= Course 의 index : 그 아이디가 어딨는지
			s= s+CoureManagement.Search(c[i]);
			//s="\n"+" )Course ID: "++"Course Name: "+Name+"Course's Professor: "+ Professor;

		}
		return s;
	}

	public static String Search(int ID) {
		// TODO Auto-generated method stub
		String s="/n/nERROR :  ID is not proper. Enter Proper ID";
	
		if(ID_Exist(ID)){
			
			pf[search].getID();
			pf[search].getName();
			pf[search].getDept();
		//	pf[search].getCourse();
			s="/nProfessor ID: "+pf[search].getID()+"\n Name: "+pf[search].getName()+"\nDepartmet :"+pf[search].getDept()+"\nCourse : "/*+pf[search].getCourse()*/;
		}
		//return search;	
		return s;
	}

	public static void Add(int ID, String name, String Dept/*,int[] Course*/) {
//교수니		 

			pf[next]=new Professor();
			pf[next].setID(ID);
			pf[next].setName(name);
			pf[next].setDept(Dept);
		//	pf[next].setCourse(Course);
			next++;

	}

	public static boolean ID_Exist(int st_id) {

		if(next !=0) {
			for(int i=0; i<next; i++) {
				if(st_id==pf[i].getID()) {
					search=i;
					return true;
				}//if		
			}//for
		}//if
		return false;  
	}

	public static int ReturnIndex(int p_id) {
		ID_Exist(p_id);
		return search;
	}

}
