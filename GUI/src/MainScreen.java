import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	 private JPanel contentPane;
	 public JTextField txtID;
	 public JTextField txtName;
	 public JTextField txtEmail;

	 public JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 577);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Student ID");
		lbl1.setBounds(22, 61, 84, 15);
		contentPane.add(lbl1);
		
		txtID = new JTextField();
		txtID.setBounds(132, 58, 116, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JLabel lbl2 = new JLabel("Student Name");
		lbl2.setBounds(22, 100, 98, 15);
		contentPane.add(lbl2);
		
		txtName = new JTextField();
		txtName.setBounds(132, 97, 116, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lbl3 = new JLabel("Email Address");
		lbl3.setBounds(22, 135, 98, 15);
		contentPane.add(lbl3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(132, 132, 116, 21);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnAdd = new JButton("Add Student");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ID = Integer.parseInt(txtID.getText());
				 String name = txtName.getText();
				 String emailAddress = txtEmail.getText();
				 
				 
				 //textArea.setText("user entered name " +txtName.getText() + "emailAddress " + txtEmail.getText() + "and ID "+ txtID.getText()  ); 
				
				 textArea.append("user entered name " +txtName.getText() + "emailAddress " + txtEmail.getText() + "and ID "+ txtID.getText()+"" );
								
			}
		});
		btnAdd.setBounds(88, 198, 140, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBounds(240, 198, 97, 23);
		contentPane.add(btnCancel);
		
		JButton btnNewButton = new JButton("check ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtID.setEnabled(true);
				txtName.setEnabled(true);
				txtEmail.setEnabled(true);
			}
		});
		btnNewButton.setBounds(272, 57, 65, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("search");
		btnNewButton_1.setBounds(349, 57, 97, 23);
		contentPane.add(btnNewButton_1);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setRows(10);
		textArea.setBounds(102, 305, 321, 160);
		contentPane.add(textArea);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Male");
		chckbxNewCheckBox.setBounds(279, 131, 115, 23);
		
		//chckbxNewCheckBox.gett
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setBounds(272, 158, 115, 23);
		contentPane.add(chckbxFemale);
	}
}