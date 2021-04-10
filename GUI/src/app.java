import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class app {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student.main(null);
			}
		});
		btnStudent.setBounds(173, 82, 125, 29);
		frame.getContentPane().add(btnStudent);
		
		JButton btnCourse = new JButton("Course");
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course.main(null);
			}
		});
		btnCourse.setBounds(173, 177, 125, 29);
		frame.getContentPane().add(btnCourse);
	}

}
