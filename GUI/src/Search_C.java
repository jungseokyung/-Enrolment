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



public class Search_C extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	private JTextField textCourseID;
	static JTextArea textArea = new JTextArea();
	
	private static int ID;
	/**
	 * Launch the application.
	 */
	CoureManagement cm = new CoureManagement();
	Course_ cs = new Course_();
	public static void main(String[] args) {
		try {
			Search_C dialog = new Search_C();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search_C() {
		setBounds(100, 100, 473, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Search");
			okButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					ID=Integer.parseInt(textCourseID.getText());
					cs.setID(Integer.parseInt(textCourseID.getText()));
					if(CoureManagement.Course_Exist(ID)) {
						//Display
						//CoureManagement.Search(ID);
						String s=	CoureManagement.Search(ID);
						//String s="Course ID: "+ID+"\nCourse Name:"+cs.getName()+ "\nCourse's Professor ID:"+cs.getProfessor();
						
						textArea.append(s);
						
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
					
					}
					else
						ID_NOT_C.main(null);
				}
			});
			okButton.setBounds(167, 108, 104, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JLabel lblCourseId = new JLabel("Course ID");
			lblCourseId.setBounds(43, 47, 100, 21);
			contentPanel.add(lblCourseId);
		}
		{
			textCourseID = new JTextField();
			textCourseID.setBounds(149, 44, 156, 27);
			contentPanel.add(textCourseID);
			textCourseID.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
