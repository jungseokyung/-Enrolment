import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Delete_P extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textProfessorID;
	private JTextArea textArea = new JTextArea();

	
	private static int ID;

	/**
	 * Launch the application.
	 */
	Professor_Management pfm = new Professor_Management();
	Professor pf = new Professor();
	
	public static void main(String[] args) {
		try {
			Delete_P dialog = new Delete_P();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Delete_P() {
		setBounds(100, 100, 504, 301);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnYes = new JButton("Search\r\n");
			btnYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ID=Integer.parseInt(textProfessorID.getText());
					pf.setID(Integer.parseInt(textProfessorID.getText()));
					
					if(Student_Management.ID_Exist(ID)) {
						
						String s=Student_Management.Search(ID)+"\n" ;
						
						textArea.append(s);//nullpointerException//Delete code 보기...
						
						JFrame jf= new JFrame();
						jf.add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						//Student_Management.Delete(ID);
					}
						
					else
						ID_NOT_S.main(null);
			
				}
			});
			btnYes.setBounds(352, 38, 125, 29);
			contentPanel.add(btnYes);
		}
		{
			JButton btnNo = new JButton("Delete\r\n");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ID=Integer.parseInt(textProfessorID.getText());
					pf.setID(Integer.parseInt(textProfessorID.getText()));
					Professor_Management.Delete(ID);
					
					if(!Student_Management.ID_Exist(ID)) {
						String s=Student_Management.Search(ID)+"\n" + "Deleted Success!";
						textArea.append(s);//nullpointerException//Delete code 보기...
						
						JFrame jf= new JFrame();
						jf.add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						
						//Student_Management.Delete(ID);
					}
					else
					{	String s="Delete Failed!";
						
						textArea.append(s);//nullpointerException//Delete code 보기...
						
						JFrame jf= new JFrame();
						jf.add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
					}
						
				}
			});
			btnNo.setBounds(178, 109, 125, 29);
			contentPanel.add(btnNo);
		}
		{
			JLabel lblProfessorId = new JLabel("Professor ID");
			lblProfessorId.setBounds(46, 42, 113, 21);
			contentPanel.add(lblProfessorId);
		}
		{
			textProfessorID = new JTextField();
			textProfessorID.setBounds(179, 39, 156, 27);
			contentPanel.add(textProfessorID);
			textProfessorID.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
