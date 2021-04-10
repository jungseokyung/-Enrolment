

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Main dialog = new Main();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Main() {
		setBounds(100, 100, 621, 524);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("Student Management");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Student.main(null);				}
			});
			btnNewButton.setBounds(150, 104, 248, 60);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Course Management");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Course.main(null);
				}
			});
			btnNewButton_1.setBounds(150, 179, 248, 60);
			contentPanel.add(btnNewButton_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Student & Course Management Program");
			lblNewLabel.setBounds(102, 15, 374, 40);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnRegiesterDrop = new JButton("Regiester/ Drop ");
			btnRegiesterDrop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Register.main(null);
				}
			});
			btnRegiesterDrop.setBounds(150, 343, 248, 65);
			contentPanel.add(btnRegiesterDrop);
		}
		{
			JButton btnNewButton_2 = new JButton("Professor Management\r\n");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Professor_Main.main(null);
				}
			});
			btnNewButton_2.setBounds(150, 268, 248, 60);
			contentPanel.add(btnNewButton_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
