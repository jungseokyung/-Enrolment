import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class Search_S extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStudentId;
	private static JTextArea textArea = new JTextArea();
	
	
	private int ID;

	/**
	 * Launch the application.
	 */
	
	Student_Management stm=new Student_Management();
	Student_  st = new Student_();
	
	public static void main(String[] args) {
		try {
			Search_S dialog = new Search_S();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search_S() {
		setBounds(100, 100, 550, 244);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterStudentId = new JLabel("Enter Student ID:");
			lblEnterStudentId.setBounds(30, 75, 173, 21);
			contentPanel.add(lblEnterStudentId);
		}
		{
			txtStudentId = new JTextField();
			txtStudentId.setBounds(189, 72, 156, 27);
			contentPanel.add(txtStudentId);
			txtStudentId.setColumns(10);
		}
		{
			JButton okButton = new JButton("Search");
			okButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					ID=Integer.parseInt(txtStudentId.getText());
					st.setID(Integer.parseInt(txtStudentId.getText()));
					
					if(Student_Management.ID_Exist(ID)) {
					//	ID_OK_S.main(null);
						String s=Student_Management.Search(ID);
						//String s="Student ID: "+ID+"\nStudent Name: "+st.getName()+"\nStudent EmailAddress"+st.getEmailAddress();
					//	textArea.append(st.getID());
					//	textArea.append(st.getName());
					//	textArea.append(st.getEmailAddress());
/*						st.getID();//.[search].getID();
						st.getName();
						st.getEmailAddress();
	*/					
						//Display
						textArea.append(s);
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
					}
						
					else
						ID_NOT_S.main(null);
				}
				}
			);
			okButton.setBounds(385, 71, 92, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
