import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Add_C extends JDialog implements ActionListener{//implements ActionListener

	private final JPanel contentPanel = new JPanel();
	private JTextField textCourseID;
	private JTextField textCourseName;
	private JTextField textProfessorID;

	private int ID;
	private int i=0;
	private int[] Student_ID;
	private int ProfessorID;
	private String Name;
	
	/**
	 * Launch the application.
	 */
	CoureManagement cm = new CoureManagement();
	Course_ cs = new Course_();
	
	public static void main(String[] args) {
		try {
			Add_C dialog = new Add_C();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Add_C() {
		setBounds(100, 100, 513, 401);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCourseId = new JLabel("Course ID");
			lblCourseId.setBounds(28, 28, 109, 21);
			contentPanel.add(lblCourseId);
		}
		{
			textCourseID = new JTextField();
			textCourseID.setBounds(160, 25, 156, 27);
			contentPanel.add(textCourseID);
			textCourseID.setColumns(10);
		}
		{
			JLabel lblCourseName = new JLabel("Course Name");
			lblCourseName.setBounds(28, 75, 125, 21);
			contentPanel.add(lblCourseName);
		}
		{
			textCourseName = new JTextField();
			textCourseName.setBounds(160, 72, 156, 27);
			contentPanel.add(textCourseName);
			textCourseName.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Professor ID");
			lblNewLabel.setBounds(28, 123, 104, 21);
			contentPanel.add(lblNewLabel);
		}
		{
			textProfessorID = new JTextField();
			textProfessorID.setBounds(160, 120, 156, 27);
			contentPanel.add(textProfessorID);
			textProfessorID.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("ID Available");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ID = Integer.parseInt(textCourseID.getText());
					//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
					cs.setID(Integer.parseInt(textCourseID.getText()));
					
					if(CoureManagement.Course_Exist(ID)) {
						 ID_NOT_C.main(null);
					}
						
					else
						ID_OK_C.main(null);
				}
			});
			btnNewButton.setBounds(346, 24, 125, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JButton okButton = new JButton("Add");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ID = Integer.parseInt(textCourseID.getText());
					//먼저, txtStudentID를 Get TExt()여기에서의 getter를 해줌.
					cs.setID(Integer.parseInt(textCourseID.getText()));
					Name = textCourseName.getText();
					cs.setName(Name);
					ProfessorID =  Integer.parseInt(textProfessorID .getText());
					cs.setProfessor(ProfessorID);
					CoureManagement.Add(ID, Name, ProfessorID);
					
					JTextArea textArea = new JTextArea();
					String s=CoureManagement.Add(ID, Name, ProfessorID);
					textArea.append(s);
					JFrame jf= new JFrame();
					jf.getContentPane().add(textArea);
					jf.setSize(500, 500);
					jf.setVisible(true);
					
					
				}
			});
			okButton.setBounds(38, 171, 65, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			String c=ID+" "+ Name+ " "+ ProfessorID;
			

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*JTextArea textArea = new JTextArea();
		String c=ID+" "+Name+" "+ ProfessorID;
		textArea.setText(c);
			
		/*	String text=textField.getText();
			textField.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLine());
		*/
		JTextArea textArea = new JTextArea();
		String c=ID+" "+Name+" "+ ProfessorID;
//		textArea.append(출력할 내용)
		textArea.append(c);
	}
	 public static void messageBox(Object obj , String message){
	        JOptionPane.showMessageDialog( (Component)obj , message);
	    }
	
}
