import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Student dialog = new Student();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Student() {
		setBounds(100, 100, 484, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Delete");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Delete_S.main(null);
				}
			});
			btnNewButton.setBounds(30, 137, 125, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Add");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Add_S.main(null);
				}
			});
			btnNewButton_1.setBounds(30, 80, 125, 29);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_2 = new JButton("Search");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Search_S.main(null);
				}
			});
			btnNewButton_2.setBounds(30, 260, 125, 29);
			contentPanel.add(btnNewButton_2);
		}
		{
			JButton btnNewButton_3 = new JButton("Update");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Update_S.main(null);
				}
			});
			btnNewButton_3.setBounds(30, 202, 125, 29);
			contentPanel.add(btnNewButton_3);
		}
		{
			JLabel lblStudentManagementProgram = new JLabel("Student Management Program");
			lblStudentManagementProgram.setBounds(30, 31, 253, 21);
			contentPanel.add(lblStudentManagementProgram);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
