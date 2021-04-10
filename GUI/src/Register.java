import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

public class Register extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textS_ID;
	private JTextField textS_Name;
	private JTextField textC_ID;
	
	private static JTextArea textArea = new JTextArea();
	private static JTextArea textArea2 = new JTextArea();
	private static JTextArea textArea3 = new JTextArea();
	private static JTextArea textArea4 = new JTextArea();
	private static JTextArea textArea5 = new JTextArea();
	private static JTextArea textArea6 = new JTextArea();

	
	private int S_ID;
	private String S_Name;
	private int C_ID;
	private String C_Name;
	private int i=0;
	private int[] Student_ID;
	private int j=0;
	private int[] Course_ID;
	Student_Management stm = new Student_Management();
	Student_ st= new Student_();
	CoureManagement cm = new CoureManagement();
	Course_ cs = new Course_();
	/**
	 * Launch the application.
	 */
	
	Arraylist list = new Arraylist();

	public static void main(String[] args) {
		try {
			Register dialog = new Register();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Register() {
		setBounds(100, 100, 908, 335);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStudentId = new JLabel("Student ID");
			lblStudentId.setBounds(54, 57, 102, 21);
			contentPanel.add(lblStudentId);
		} 
		{
			textS_ID = new JTextField();
			textS_ID.setBounds(161, 54, 156, 27);
			contentPanel.add(textS_ID );
			textS_ID.setColumns(10);
		}
		{
			textS_Name = new JTextField();
			textS_Name.setBounds(504, 54, 156, 27);
			contentPanel.add(textS_Name);
			textS_Name.setColumns(10);
		}
		
		JLabel lblEnter = new JLabel("Student Name");
		lblEnter.setBounds(345, 57, 134, 21);
		contentPanel.add(lblEnter);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				S_ID = Integer.parseInt(textS_ID.getText());
				//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
				st.setID(Integer.parseInt(textS_ID.getText()));
				S_Name = textS_Name.getText();
				st.setName(S_Name);
				
				if(Student_Management.ID_Exist(S_ID)) {
					//ID_OK_S.main(null);
					String s=Student_Management.Search(S_ID);//=search id
					//Display
					ID_OK_S.main(null);
				}	
				else
					ID_NOT_S.main(null);
				
			}
		});
		btnLogIn.setBounds(723, 53, 125, 29);
		contentPanel.add(btnLogIn);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//학생 배열에 추가...!!??
				//Course_ID[j];
				C_ID = Integer.parseInt(textC_ID.getText());
				//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
				cs.setID(Integer.parseInt(textC_ID.getText()));
				if(CoureManagement.Course_Exist(C_ID)) {
					st.setCourse(Course_ID);
					Student_Management.Register(S_ID,C_ID);
					
					//학생 테이블 뜨면서, 과목을 등록할 수 있도록 한다...
					//String s=CoureManagement.Search(C_ID);//=search
					//Display
					String s =CoureManagement.Print(C_ID)+ "\n"+Student_Management.Search(S_ID)+"\r\n" + 
							"Registration succeeded.";//인자 추가 안해도??!!
					
					textArea2 .append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea2);
					jf.setSize(500, 500);
					jf.setVisible(true);
					
				}
				else
					ID_NOT_C.main(null);
				j++;//?
			}
		});
		btnNewButton.setBounds(54, 171, 125, 29);
		contentPanel.add(btnNewButton);
		
		JButton btnDrop = new JButton("Drop");
		btnDrop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CoureManagement.Course_Exist(C_ID) && Student_Management.ID_Exist(S_ID))
				{	
					//for(int i=0; i<st.getCourse().length; i++) {
						//if(st.getCourse()==C_ID) {
							//stm.Drop(C_ID);//?? int [] Course_ID?
							Student_Management.Drop(S_ID, C_ID);
							//j++;//?
							String s = Student_Management.Drop(S_ID, C_ID)+ 
									"Dropping succeeded.";//인자 추가 안해도??!!
							
							textArea3 .append(s);
							JFrame jf= new JFrame();
							jf.getContentPane().add(textArea3);
							jf.setSize(500, 500);
							jf.setVisible(true);
						//}
							
					//}//for
						
				}else if(!(cm.Course_Exist(C_ID)))
					ID_NOT_C.main(null);
				else
					ID_NOT_S.main(null);
				
			}
		});
		btnDrop.setBounds(231, 171, 125, 29);
		contentPanel.add(btnDrop);
		
		JButton btnSearch = new JButton("Check ID\r\n");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_ID = Integer.parseInt(textC_ID.getText());
				//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
				cs.setID(Integer.parseInt(textC_ID.getText()));
				
				if(CoureManagement.Course_Exist(C_ID)) {
					ID_OK_C.main(null);
					String s=CoureManagement.Search(C_ID);//=search
					//Display
					textArea4 .append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea4);
					jf.setSize(500, 500);
					jf.setVisible(true);
					
				}
				else
					ID_NOT_C.main(null);
				
			}
		});
		btnSearch.setBounds(334, 100, 125, 29);
		contentPanel.add(btnSearch);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setBounds(54, 104, 93, 21);
		contentPanel.add(lblCourseId);
		
		textC_ID = new JTextField();
		textC_ID.setBounds(161, 101, 156, 27);
		contentPanel.add(textC_ID);
		textC_ID.setColumns(10);
		
		JButton btnList = new JButton("List");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s=CoureManagement.PrintAll();
				
				textArea5 .append(s);
				JFrame jf= new JFrame();
				jf.getContentPane().add(textArea5);
				jf.setSize(500, 500);
				jf.setVisible(true);
			}
		});
		btnList.setBounds(723, 97, 125, 29);
		contentPanel.add(btnList);
		
		JLabel lblWhatIRegistred = new JLabel("Show the Courses \r\nWhat I registered.");
		lblWhatIRegistred.setBounds(381, 172, 333, 27);
		contentPanel.add(lblWhatIRegistred);
		
		JLabel lblNewLabel = new JLabel("Show the all the courses.");
		lblNewLabel.setBounds(493, 104, 221, 21);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				S_ID = Integer.parseInt(textS_ID.getText());

				if(Student_Management.ID_Exist(S_ID)) {
					String s=Student_Management.Search(S_ID);
					
					textArea6 .append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea6);
					jf.setSize(500, 500);
					jf.setVisible(true);
				}else
					ID_NOT_S.main(null);
			}
		});
		btnNewButton_1.setBounds(723, 171, 125, 29);
		contentPanel.add(btnNewButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
