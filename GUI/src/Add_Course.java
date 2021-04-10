import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_Course extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCourseID;
	private JTextField textProfessorID;

	
	static JTextArea textArea = new JTextArea();
	static JTextArea textArea2 = new JTextArea();
	

	private static int c_id;
	private static int p_id;//Professor
	
	Professor pf = new Professor();
	Professor_Management pm = new Professor_Management();
	
	CoureManagement cm = new CoureManagement();
	Course_ cs = new Course_();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Add_Course dialog = new Add_Course();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Add_Course() {
		setBounds(100, 100, 520, 297);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setBounds(37, 131, 94, 21);
		contentPanel.add(lblCourseId);
		
		textCourseID = new JTextField();
		textCourseID.setBounds(154, 128, 156, 27);
		contentPanel.add(textCourseID);
		textCourseID.setColumns(10);
		
		JButton btnIdCheck = new JButton("ID Check");
		btnIdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c_id= Integer.parseInt(textCourseID.getText());
				if(CoureManagement.Course_Exist(c_id)) {
					ID_OK_C.main(null);
					String s=CoureManagement.Search(c_id);
				
					textArea.append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea);
					jf.setSize(500, 500);
					jf.setVisible(true);
					
					
				}else {
					ID_NOT_C.main(null);
				}
			}
		});
		btnIdCheck.setBounds(345, 127, 125, 29);
		contentPanel.add(btnIdCheck);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Professor에다 Course룰 추가?? 아니면, Course에 professor추가??
				//서로 추가...!!!
				p_id = Integer.parseInt(textProfessorID.getText());
				c_id= Integer.parseInt(textCourseID.getText());
				if(CoureManagement.Course_Exist(c_id)&&(Professor_Management.ID_Exist(p_id))) 
				{	
					int c_index=cm.ReturnIndex(c_id);//c의 인덱스
					int p_index=pm.ReturnIndex(p_id);//p의 인덱스
					//인덱스를 찾아서. 거기에 각자 연동되는 아이디를 넣어준다...!!
					//course엔 professor를, professor에겐 course ID 를..!!
					int c[] = new int [10];
					int i=0;
					c[i]=c_id;
					i++;
					
					pf.setCourse(c);
					
					
					int p[] = new int[10];
					int j=0;
					p[j]=p_id;
					j++;
					cs.setProfessor(p_id);
					//그 index에 어떻게 저장할까...??
					//course[c_index].setProfessor(p_id);
					
				}
				else
					ID_NOT_S.main(null);
				
				String s= "Added Success!!";
				textArea2.append(s);
				JFrame jf= new JFrame();
				jf.getContentPane().add(textArea2);
				jf.setSize(500, 500);
				jf.setVisible(true);
				
			}
		});
		btnAddCourse.setBounds(164, 175, 142, 29);
		contentPanel.add(btnAddCourse);
		
		JLabel lblA = new JLabel("Enter courses one by one.");
		lblA.setBounds(133, 27, 227, 21);
		contentPanel.add(lblA);
		
		JLabel lblProfessorId = new JLabel("Professor ID");
		lblProfessorId.setBounds(17, 68, 137, 21);
		contentPanel.add(lblProfessorId);
		
		textProfessorID = new JTextField();
		textProfessorID.setBounds(154, 65, 156, 27);
		contentPanel.add(textProfessorID);
		textProfessorID.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				p_id = Integer.parseInt(textProfessorID.getText());
				if(Professor_Management.ID_Exist(p_id)) {
					String s=Professor_Management.Search(p_id);
					
					textArea.append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea);
					jf.setSize(500, 500);
					jf.setVisible(true);
					
				}else
					ID_NOT_C.main(null);
			}
		});
		btnSearch.setBounds(345, 63, 125, 29);
		contentPanel.add(btnSearch);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
