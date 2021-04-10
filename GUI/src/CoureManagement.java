
import java.util.*;

/*
 * Course management

  - Add Courese
  - Search Course
  - Update Course Information
  - Delete Course Information
  - Register course
  - Drop course
 */

public class CoureManagement {
	private static int index_st=0;//�л� index.
	private static int next_c=0;//course �� ������ŭ.
	private static int index=0; //��� ����Ǿ� �ִ��� �˱� ����
	public static int up_ID;
	
	public static Course_[] course=new Course_[100];
	public static Student_[] stds=new Student_[100];
	static Course_ cs = new Course_();
	static Student_ st= new Student_();
//	Professor_Management pfm = new Professor_Management();
	static Professor_Management pfm = new Professor_Management();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arraylist list = new Arraylist();

	}
/*
	public static String Drop(int s_id, int c_id) {//�л��� ����
		// TODO Auto-generated method stub
		String s="ERROR : ID is not proper. \n Enter another ID!";
	/*	Scanner input=new Scanner(System.in);
		System.out.println("Enter a student ID:");
		int ID=input.nextInt();
	*/
		//if(Course_Exist(c_id)) {//�� ������ �����ϰ�
		//	for(int i=0; i<length(st.getCourse()_)
			//if(stds[index_st].setID(c_id)==c_id)
				//�л��� �� ������ ��´ٸ�,
	/*		//setCourse(null);
			
			next_c--;	
		}
		return s;
		
	}

	
			//return String = 
	public static String Register(int st_id,int c_id) {//�л��� ����
		// TODO Auto-generated method stub //�л� ���� ���� �迭�� �߰�.
		String s="ERROR : ID is not proper! \n Enter another ID";
/*		Scanner input=new Scanner(System.in);
		System.out.println("Enter a student ID:");
		int ID=input.nextInt();
*///		if(Student_Management.ID_Exist(st_id)&&Course_Exist(c_id)) {
		//	System.out.println("Enter a course ID:");
		//	int course_ID=input.nextInt();	
			//stds[index_st].setID(c_id);
/*			stds[index_st].setCourse(course);
/			System.out.println("Register succeess!");
			index_st++;// �³�??.... //���� �л��� �߰���... 
		}//if
			
		//return cs.getStudent();
		//(course_ID);
		return s;
	}
*/
	public static String Delete(int id) {
		// TODO Auto-generated method stub
		String s="\n\nERROR : There is no ID ";
	
		if(Course_Exist(id)) { //���� �����Ѵٸ�,
			s=Search(id);
			for(int i=index; i<next_c; i++) {
				if(course[i].getID()==id) {
					for(int j=i; j<next_c-1;j++) {
						course[j]=course[j+1];
					}
				}
				//index--;
			}//for �����.
			next_c--;
		}//if
		//next_c--;
		return s;
		
	}

	public static String Update(int id,int up_id) {
		String s="\nERROR : ID is not proper.\n Enter again.";
		// TODO Auto-generated method stub
		if(!(Course_Exist(up_id))) {
		course[index].setID(up_id);
		s="\nCourse ID: "+course[index].getID()+"\nCourse Name: "+course[index].getName()+"\nCourse's Professor ID: "+ course[index].getProfessor()+"\n\nStored Success !!";
		}

		return s;
	}

	public static String Search(int id) {
		String s="/nERROR : ID is not proper.\n Enter again.\n";
		// TODO Auto-generated method stub
	
		if(Course_Exist(id)) {
			s="/nCourse ID : "+course[index].getID()+"\nCourse Name: "+course[index].getName()+"\nCourse's Professor ID: "+ course[index].getProfessor()+"\n";
		}
	//	return index;//search
		return s;
	}

	public static String Add(int course_id, String name, int professor_id) {
		// TODO Auto-generated method stub
		
		String s="/n/nERROR: Already exist ID";
		//if(!Course_Exist(course_id)) {
			course[next_c] = new Course_();
			course[next_c].setID(course_id);
			course[next_c].setName(name);
			course[next_c].setProfessor(professor_id);
			
			//System.out.println("Stored!");
			s="/nCourse ID: "+course_id +"\nCourse Name: "+name + "\nCourse's professor name : "+professor_id;
			next_c++;
		//}
		return s;
	}
	
	public static boolean Course_Exist(int c_id) {
		
		if(next_c !=0) {
			for(int i=0; i<next_c; i++) {
				if(c_id==course[i].getID()) {//NullPointException
					index=i;//��� ����Ǿ� �ִ��� �˱� ����
					return true;
				}		
			}
		}
		return false;  
	}

	public static int ReturnIndex(int c_id) {
		Course_Exist(c_id);
		return index;
	}
	
	public static int ReturnProfessor(int c_id,int p_id) {//�� �ڽ��� �ش�Ǵ� ���� ���̵� ����
		pfm.ID_Exist(p_id);
		int search=pfm.ReturnIndex(p_id);
//		String s= 
		return search; //d�̰� Ʋ��..!!
	}
	
	public static String Print(int c_ID) {//���� �߰� ���ص�??
		// TODO Auto-generated method stub
		String s=null;
	
		//course id�� ������,  course class����, ������ �����´�.
//		String Name=cs.getName();
//		int Professor=cs.getProfessor();
	
		ReturnIndex(c_ID);
		String Name = course[index].getName();
		int Professor= course[index].getProfessor();
		//index�� �ִ� �� �����;ߵǴµ�...                                   
	//	for(int i=0; i<course_index; i++) {
			s="\n"+" )Course ID: "+c_ID+"Course Name: "+Name+"Course's Professor: "+ Professor;
	//	}
		return s;
	}
	public static String PrintAll() {//���� �߰� ���ص�??
		// TODO Auto-generated method stub
		String s=null;
	
		//course id�� ������,  course class����, ������ �����´�.
	
		//index�� �ִ� �� �����;ߵǴµ�...                                   
		for(int i=0; i<next_c; i++) {
			//String Name=cs.getName();
			//int Professor=cs.getProfessor();
			
			String Name = course[i].getName();
			int Professor= course[i].getProfessor();
			
			s="\n"+i+" )Course ID: "+course[i]+"Course Name: "+Name+"Course's Professor: "+ Professor;
		}
		return s;
	}

/*	public static String Print(int c_id,int index) {
		String s=null;
		if(Course_Exist(c_id)) {
			s=
		}		
		
		return s;
	}*/
	
	
}
