import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Add_P extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textProfessorID;
	private JTextField textProfessorName;
	private JTextField textDept;
	
	static JTextArea textArea = new JTextArea();
	
	private static int c_id;
	private static int p_id;
	private static int ID;
	private static String Name;
	private static String Dept;
	private static int [] course;
	private static int index=0;
	
	Professor pf = new Professor();
	Professor_Management pm = new Professor_Management();
	CoureManagement cm = new CoureManagement();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Add_P dialog = new Add_P();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Add_P() {
		setBounds(100, 100, 577, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProfessorId = new JLabel("Professor ID");
			lblProfessorId.setBounds(27, 55, 117, 21);
			contentPanel.add(lblProfessorId);
		}
		{
			textProfessorID = new JTextField();
			textProfessorID.setBounds(176, 52, 156, 27);
			contentPanel.add(textProfessorID);
			textProfessorID.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("ID Check\r\n");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					p_id = Integer.parseInt(textProfessorID.getText());
					
					if(!Professor_Management.ID_Exist(p_id)) {
						ID_OK_C.main(null);
					}
					else
						ID_NOT_C.main(null);
				}
			});
			btnNewButton.setBounds(367, 51, 125, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblProessorName = new JLabel("Proessor Name");
			lblProessorName.setBounds(28, 107, 133, 21);
			contentPanel.add(lblProessorName);
		}
		{
			JLabel lblDepartment = new JLabel("Department");
			lblDepartment.setBounds(27, 151, 106, 21);
			contentPanel.add(lblDepartment);
		}
		{
			textProfessorName = new JTextField();
			textProfessorName.setBounds(176, 148, 156, 27);
			contentPanel.add(textProfessorName);
			textProfessorName.setColumns(10);
		}
		{
			textDept = new JTextField();
			textDept.setBounds(176, 104, 156, 27);
			contentPanel.add(textDept);
			textDept.setColumns(10);
		}
		{
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ID = Integer.parseInt(textProfessorID.getText());
					
					//textProfessorID
					//textProfessorName
					//textDept
					//textcourse
					
					pf.setID(Integer.parseInt(textProfessorID.getText()));
					//먼저, getText를 통해 읽어들이고,  setID를 통해, 저장한다.
					//이때 배열이 필요한가....???
					Name = textProfessorName.getText();
					pf.setName(Name);
					Dept = textDept.getText();
					pf.setDept(Dept);
					
					//여기 에러남;;;;ㅎㅎ
			/*		course[index]=Integer.parseInt(textCourse.getText());
					//Nullpoint Exception
					pf.setCourse(course);
					index++;
				*/	//이게 맞을까..!!?? 
					
					Professor_Management.Add(ID,Name,Dept/*,course*/);

					String pfc=null;
					String s="\nProfessor ID : "+ID+"\n Name: "+Name+" \n Dept: "+ Dept+ " \nRegistered Course ID: "+pfc;
					
					if(index !=0) {
						for(int i=0; i<index; i++) {
							pfc=pfc+ course[i];
						}
					}
					else
						pfc="Course ID is Not Registred yet!!";
						
					textArea.append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea);
					jf.setSize(500, 500);
					jf.setVisible(true);
			
				}
			});
			btnAdd.setBounds(188, 214, 125, 29);
			contentPanel.add(btnAdd);
		}
		
		JButton btnNewButton_1 = new JButton("Add Course");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Course.main(null);
			}
		});
		btnNewButton_1.setBounds(379, 216, 159, 52);
		contentPanel.add(btnNewButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
