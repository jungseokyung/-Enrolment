import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JFrame;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Add_S extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtStudentId;
	private JTextField txtCourseId;
	private JTextField txtStudentName;
	private JTextField txtEmailAddress;
	private JTextField txtStudentGPA;
	
	static JTextArea textArea = new JTextArea();
	
	private static int ID;
	private int i=0;
	private int[] Course_ID;
	private double GPA;
	private static String Name;
	private static String Email;
	
//	private static name;
	/**
	 * Launch the application.
	 */
	
	Student_Management stm=new Student_Management();
	Student_  st = new Student_();
	//protected String txtStudentId;
	
	/**
	 * Create the dialog.
	 */
	public Add_S() {
		setBounds(100, 100, 574, 467);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStudentId = new JLabel("Student ID");
			lblStudentId.setBounds(37, 27, 112, 21);
			contentPanel.add(lblStudentId);
		}
		{
			JLabel lblStudentName = new JLabel("Student NAme");
			lblStudentName.setBounds(37, 73, 131, 21);
			contentPanel.add(lblStudentName);
		}
		{
			JLabel lblStudentEmail = new JLabel("Student Email");
			lblStudentEmail.setBounds(37, 118, 131, 21);
			contentPanel.add(lblStudentEmail);
		}
		{
			JLabel lblStudentGpa = new JLabel("Student GPA");
			lblStudentGpa.setBounds(37, 169, 112, 21);
			contentPanel.add(lblStudentGpa);
		}
		
		txtStudentId = new JTextField();
		txtStudentId.setBounds(190, 24, 156, 27);
		contentPanel.add(txtStudentId);
		txtStudentId.setColumns(10);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(190, 73, 156, 27);
		contentPanel.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(190, 115, 156, 27);
		contentPanel.add(txtEmailAddress);
		txtEmailAddress.setColumns(10);
		
		txtStudentGPA = new JTextField();
		txtStudentGPA.setBounds(190, 166, 156, 27);
		contentPanel.add(txtStudentGPA);
		txtStudentGPA.setColumns(10);
		
		JButton btnIdAvailable = new JButton("ID available");
		btnIdAvailable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = Integer.parseInt(txtStudentId.getText());
				//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
				st.setID(Integer.parseInt(txtStudentId.getText()));
				
				if(stm.ID_Exist(ID))
					ID_NOT_S.main(null);
				else
					ID_OK_S.main(null);
			}
		});
		btnIdAvailable.setBounds(406, 23, 125, 29);
		contentPanel.add(btnIdAvailable);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID = Integer.parseInt(txtStudentId.getText());
				//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
				st.setID(Integer.parseInt(txtStudentId.getText()));
				//먼저, getText를 통해 읽어들이고,  setID를 통해, 저장한다.
				//이때 배열이 필요한가....???
				Name = txtStudentName.getText();
				st.setName(Name);
				Email = txtEmailAddress.getText();
				st.setEmailAddress(Email);
				
				GPA=Integer.parseInt(txtStudentGPA.getText());
				//Nullpoint Exception
				st.setGPA(GPA);
				//이거따로, Add() 따로?!!
				Student_Management.Add(ID,Name,Email,GPA);
				
				String c="Student ID : "+ID+"\n Student Name: "+Name+" \nStudent Email: "+ Email+ " \nStudent GPA: "+GPA+"\nStored Success!!";
				
				textArea.append(c);
				//Course ID
				JFrame jf= new JFrame();
				jf.getContentPane().add(textArea);
				jf.setSize(500, 500);
				jf.setVisible(true);
			}
		});
		btnAdd.setBounds(24, 228, 125, 29);
		contentPanel.add(btnAdd);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		try {
			Add_S dialog = new Add_S();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
