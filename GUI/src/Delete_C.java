import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Delete_C extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCourseID;
	private JTextArea textArea = new JTextArea();
	/**
	 * Launch the application.
	 */
	
	private int ID;
	CoureManagement cm = new CoureManagement();
	Course_ cs = new Course_();
	
	public static void main(String[] args) {
		try {
			Delete_C dialog = new Delete_C();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Delete_C() {
		setBounds(100, 100, 459, 340);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Search");
			okButton.setBounds(304, 54, 95, 29);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent arg0) {
					ID=Integer.parseInt(textCourseID.getText());
					cs.setID(Integer.parseInt(textCourseID.getText()));
					
					if(CoureManagement.Course_Exist(ID)) {
					//	CoureManagement.Delete(ID);
						String s=CoureManagement.Search(ID);	
						//String s="Course ID: "+ID+"\nCoures Name: "+ cs.getName()+ "\nCourse's Professor ID: "+ cs.getProfessor();
						textArea.append(s);
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						
						//Display
					}
						
					else
						ID_NOT_C.main(null);
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel lblCourseId = new JLabel("Course ID");
		lblCourseId.setBounds(29, 58, 97, 21);
		contentPanel.add(lblCourseId);
		
		textCourseID = new JTextField();
		textCourseID.setBounds(127, 55, 156, 27);
		contentPanel.add(textCourseID);
		textCourseID.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ID=Integer.parseInt(textCourseID.getText());
				cs.setID(Integer.parseInt(textCourseID.getText()));
				
				if(CoureManagement.Course_Exist(ID)) {
					
					JFrame jf= new JFrame();
					String s="\n\nDeleted Sucess!!";
					textArea.append(s);
					jf.getContentPane().add(textArea);
					jf.setSize(500, 500);
					jf.setVisible(true);
					//Delete
//					int search=CoureManagement.Delete(ID);
					//Display
					CoureManagement.Delete(ID);
				}
					
				else
					ID_NOT_C.main(null);
			}
		});
		btnDelete.setBounds(137, 108, 125, 29);
		contentPanel.add(btnDelete);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
