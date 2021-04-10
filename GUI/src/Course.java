import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Course extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Course dialog = new Course();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Course() {
		setBounds(100, 100, 426, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCourseManagementProgram = new JLabel("Course Management Program");
			lblCourseManagementProgram.setBounds(71, 37, 259, 21);
			contentPanel.add(lblCourseManagementProgram);
		}
		{
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Add_C.main(null);
				}
			});
			btnAdd.setBounds(53, 103, 125, 29);
			contentPanel.add(btnAdd);
		}
		{
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Search_C.main(null);
				}
			});
			btnSearch.setBounds(53, 147, 125, 29);
			contentPanel.add(btnSearch);
		}
		{
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Delete_C.main(null);
				}
			});
			btnDelete.setBounds(53, 191, 125, 29);
			contentPanel.add(btnDelete);
		}
		{
			JButton btnNewButton = new JButton("Update");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Update_C.main(null);
				}
			});
			btnNewButton.setBounds(53, 235, 125, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
