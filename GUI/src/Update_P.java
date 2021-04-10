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

public class Update_P extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUpId;
	private JTextArea textArea= new JTextArea();

	
	private static int up_id;
	private static int id;

	/**
	 * Launch the application.
	 * 
	 */
	Professor_Management pfm = new Professor_Management();
	private JTextField textField;
	
	public static void main(String[] args) {
		try {
			Update_P dialog = new Update_P();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Update_P() {
		setBounds(100, 100, 545, 271);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProfessorId = new JLabel("New ID\r\n");
			lblProfessorId.setBounds(37, 110, 80, 21);
			contentPanel.add(lblProfessorId);
		}
		{
			textUpId = new JTextField();
			textUpId.setBounds(134, 107, 156, 27);
			contentPanel.add(textUpId);
			textUpId.setColumns(10);
		}
		{
			JLabel lblUpdateProfessorId = new JLabel("Update Professor ID");
			lblUpdateProfessorId.setBounds(113, 15, 183, 21);
			contentPanel.add(lblUpdateProfessorId);
		}
		{
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//search 다시 다 추가...ㅠ
					up_id=Integer.parseInt(textUpId.getText());
					
					if(!(pfm.ID_Exist(up_id))) {
						//OK
						//ID_OK_S.main(null);
						Professor_Management.Update(id, up_id);
						String c=Student_Management.Search(id);
						textArea.append(c);
						//Course ID
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						
					}
					else {
						ID_NOT_S.main(null);
						//Error
					}
					
					
			
				}
			});
			btnUpdate.setBounds(326, 106, 125, 29);
			contentPanel.add(btnUpdate);
		}
		{
			JLabel lblProfessorId_1 = new JLabel("Professor ID");
			lblProfessorId_1.setBounds(27, 58, 116, 21);
			contentPanel.add(lblProfessorId_1);
		}
		{
			textField = new JTextField();
			textField.setBounds(134, 51, 156, 27);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JButton btnIdCheck_1 = new JButton("ID Check");
			btnIdCheck_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Professor_Management.ID_Exist(id)) {
						// text Area에 나타내기...
						String s=Professor_Management.Update(id,up_id);
						//Display
						JFrame jf = new JFrame();
						textArea.append(s);
						jf.getContentPane().add(textArea);
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
					
					}
					else
						ID_NOT_S.main(null);
					
				}
			});
			btnIdCheck_1.setBounds(316, 54, 125, 29);
			contentPanel.add(btnIdCheck_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
