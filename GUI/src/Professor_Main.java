import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Professor_Main extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Professor_Main dialog = new Professor_Main();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Professor_Main() {
		setBounds(100, 100, 505, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnAdd = new JButton("Add");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Add_P.main(null);
				}
			});
			btnAdd.setBounds(134, 71, 125, 29);
			contentPanel.add(btnAdd);
		}
		{
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Search_P.main(null);
				}
			});
			btnSearch.setBounds(134, 127, 125, 29);
			contentPanel.add(btnSearch);
		}
		{
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Update_P.main(null);
				}
			});
			btnUpdate.setBounds(134, 182, 125, 29);
			contentPanel.add(btnUpdate);
		}
		{
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Delete_P.main(null);
				}
			});
			btnDelete.setBounds(134, 240, 125, 29);
			contentPanel.add(btnDelete);
		}
		{
			JLabel lblProfessorManagement = new JLabel("Professor Management");
			lblProfessorManagement.setBounds(112, 15, 227, 21);
			contentPanel.add(lblProfessorManagement);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
