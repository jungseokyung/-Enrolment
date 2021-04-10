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

public class Search_P extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textProfessorID;
	private static JTextArea textArea = new JTextArea();
	
	private static int ID;

	/**
	 * Launch the application.
	 */
	Professor_Management pfm= new Professor_Management();
	Professor pf = new Professor();
	
	public static void main(String[] args) {
		try {
			Search_P dialog = new Search_P();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Search_P() {
		setBounds(100, 100, 557, 342);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProfessorId = new JLabel("Professor ID");
			lblProfessorId.setBounds(51, 50, 109, 21);
			contentPanel.add(lblProfessorId);
		}
		{
			textProfessorID = new JTextField();
			textProfessorID.setBounds(177, 50, 156, 27);
			contentPanel.add(textProfessorID);
			textProfessorID.setColumns(10);
		}
		{
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ID = Integer.parseInt(textProfessorID.getText());
					
					pf.setID(Integer.parseInt(textProfessorID.getText()));
					//먼저, getText를 통해 읽어들이고,  setID를 통해, 저장한다.
					//이때 배열이 필요한가....???
					
					if(Professor_Management.ID_Exist(ID)) {
						String s=Professor_Management.Search(ID);
						
						textArea.append(s);
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						
						ID(ID);
						//ID를 가져가기위한 메소드를 만들어서, 여기서 실행시킨다.
					}//if
					else
						ID_NOT_S.main(null);
					
				}//action

			});
			btnSearch.setBounds(366, 46, 125, 29);
			contentPanel.add(btnSearch);
		}
		{
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Update_P.main(null);
					
				}
			});
			btnUpdate.setBounds(51, 139, 125, 29);
			contentPanel.add(btnUpdate);
		}
		{
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Delete_P.main(null);
				/*	String s="Do you want to delete really?";
					textArea.append(s);
					//Course ID
					JFrame jf1= new JFrame();
					jf1.getContentPane().add(textArea);
					jf1.setSize(500, 500);
					jf1.setVisible(true);
					*/
					
				}
			});
			btnDelete.setBounds(212, 139, 125, 29);
			contentPanel.add(btnDelete);
		}
		{
			JButton btnAddCourse = new JButton("Add Course");
			btnAddCourse.setBounds(378, 139, 140, 29);
			contentPanel.add(btnAddCourse);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	public int ID(int id) {
		return id;
	}

}
