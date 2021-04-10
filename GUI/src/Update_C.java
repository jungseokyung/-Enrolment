import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;

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

public class Update_C extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textID;
	private JTextField textUP_ID;
	private static JTextArea textArea= new JTextArea();
	//private static JTextArea textArea1= new JTextArea();

	
	private int ID;
	private int UP_ID;
	CoureManagement cm = new CoureManagement();
	Course_ cs = new Course_();
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			Update_C dialog = new Update_C();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Update_C() {
		setBounds(100, 100, 512, 348);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("Search");
			okButton.addActionListener(new ActionListener() {
				//private Object ID;

				public void actionPerformed(ActionEvent e) {
					
					ID=Integer.parseInt(textID.getText());
					cs.setID(Integer.parseInt(textID.getText()));
					
					//먼저, 입력한 값을 검사해야 하므로, 임시저장.상태
					//st.getID();//ID를 찾기....????
					
					if(CoureManagement.Course_Exist(ID)) {
					
						String s=CoureManagement.Search(ID);//=UP_ID	
						
						textArea.append(s);
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						//Display
					}
						
					else
						ID_NOT_C.main(null);
				
				}
			});
			okButton.setBounds(358, 55, 104, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JLabel lblCourseId = new JLabel("Course ID");
			lblCourseId.setBounds(45, 59, 96, 21);
			contentPanel.add(lblCourseId);
		}
		{
			textID = new JTextField();
			textID.setBounds(170, 56, 156, 27);
			contentPanel.add(textID);
			textID.setColumns(10);
		}
		{
			JLabel lblUpdateCourseId = new JLabel("Update Course ID");
			lblUpdateCourseId.setBounds(17, 114, 156, 21);
			contentPanel.add(lblUpdateCourseId);
		}
		{
			textUP_ID = new JTextField();
			textUP_ID.setBounds(170, 111, 156, 27);
			contentPanel.add(textUP_ID);
			textUP_ID.setColumns(10);
		}
		{
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UP_ID=Integer.parseInt(textUP_ID.getText());//NumberFormatExceptino
					cs.setID(Integer.parseInt(textUP_ID.getText()));
					//먼저, 입력한 값을 검사해야 하므로, 임시저장.상태
					//st.getID();//ID를 찾기....????
					if(!CoureManagement.Course_Exist(UP_ID) /*&& CoureManagement.Course_Exist(ID)*/) {
						ID=UP_ID;
						//Display
						String s=CoureManagement.Update(ID,UP_ID);
		
						textArea.append(s);
						JFrame jf= new JFrame();
						jf.getContentPane().add(textArea);
						jf.setSize(500, 500);
						jf.setVisible(true);
						
					}
					else {
						ID_NOT_C.main(null);

					}
				}
			});
			btnUpdate.setBounds(365, 110, 108, 29);
			contentPanel.add(btnUpdate);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
