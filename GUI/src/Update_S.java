import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update_S extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStudent_ID;
	private JTextField textUpdate_ID;
	private JTextArea textArea= new JTextArea();
	private int ID;
	private int UP_ID;

	/**
	 * Launch the application.
	 */
	
	Student_Management stm=new Student_Management();
	Student_  st = new Student_();
	
	
	public static void main(String[] args) {
		TextArea textArea=new TextArea("Hello");
		try {
			Update_S dialog = new Update_S();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Update_S() {
		setBounds(100, 100, 573, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterStudentId = new JLabel("Enter Student ID:");
			lblEnterStudentId.setBounds(35, 51, 144, 21);
			contentPanel.add(lblEnterStudentId);
		}
		{
			txtStudent_ID = new JTextField();
			txtStudent_ID.setBounds(210, 48, 156, 27);
			contentPanel.add(txtStudent_ID);
			txtStudent_ID.setColumns(10);
		}
		{
			JButton okButton = new JButton("Search");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ID=Integer.parseInt(txtStudent_ID.getText());
					st.setID(Integer.parseInt(txtStudent_ID.getText()));
					//먼저, 입력한 값을 검사해야 하므로, 임시저장.상태
					//st.getID();//ID를 찾기....????
					if(Student_Management.ID_Exist(ID)) {
						//Display
						String c=Student_Management.Search(ID);
						textArea.append(c);
						//Course ID
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
					}
					else
						ID_NOT_S.main(null);
				}
			});
			okButton.setBounds(398, 47, 97, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JLabel lblNewStudentId = new JLabel("New Student ID");
			lblNewStudentId.setBounds(28, 99, 136, 21);
			contentPanel.add(lblNewStudentId);
		}
		{
			textUpdate_ID = new JTextField();
			textUpdate_ID.setBounds(210, 96, 156, 27);
			contentPanel.add(textUpdate_ID);
			textUpdate_ID.setColumns(10);
		}
		{
			JButton btnNewButton = new JButton("Update");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// ID avaliable 검사
					UP_ID=Integer.parseInt(textUpdate_ID.getText());
					st.setID(Integer.parseInt(textUpdate_ID.getText()));
					if(!Student_Management.ID_Exist(UP_ID) && Student_Management.ID_Exist(ID)) {
						//st.setID(UP_ID);//또하나??!!....
						String s=Student_Management.Update(ID,UP_ID);
						//Display
						JFrame jf = new JFrame();
						textArea.append(s);
						jf.getContentPane().add(textArea);
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
							
					}
						
					else
						ID_NOT_S.main(null);
				}
			});
			btnNewButton.setBounds(398, 95, 97, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
