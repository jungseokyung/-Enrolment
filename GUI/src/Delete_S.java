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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;



public class Delete_S extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStudentId;
	private JTextArea textArea = new JTextArea();
	
	private int ID;
	private String Name;
	private String Email;

	/**
	 * Launch the application.
	 */
	
	Student_Management stm=new Student_Management();
	Student_  st = new Student_();
	
	public static void main(String[] args) {
		try {
			Delete_S dialog = new Delete_S();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Delete_S() {
		setBounds(100, 100, 549, 279);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEnterIdTo = new JLabel("Student ID ");
			lblEnterIdTo.setBounds(49, 69, 150, 21);
			contentPanel.add(lblEnterIdTo);
		}
		{
			txtStudentId = new JTextField();
			txtStudentId.setBounds(162, 66, 156, 27);
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
						
						String s=Student_Management.Search(ID);
						
						textArea.append(s);//nullpointerException//Delete code º¸±â...
						
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						//Student_Management.Delete(ID);
					}
						
					else
						ID_NOT_S.main(null);
				}
			});
			okButton.setBounds(335, 65, 113, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton btnNewButton = new JButton("Delete");
			btnNewButton.addActionListener(new ActionListener() {
				

				public void actionPerformed(ActionEvent e) {
					ID=Integer.parseInt(txtStudentId.getText());
					st.setID(Integer.parseInt(txtStudentId.getText()));
					
					if(Student_Management.ID_Exist(ID)) {
						//Display
						JFrame jf= new JFrame();
						textArea.append("\n\nDelete Sucess!");
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						Student_Management.Delete(ID);	
					}
						
				}
			});
			btnNewButton.setBounds(179, 141, 125, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
