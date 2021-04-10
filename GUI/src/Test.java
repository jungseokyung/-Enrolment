//Swing 
import java.awt.*;
import javax.swing.*;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1 JFrame = 1 Window
		
		JFrame mainScreen = new JFrame();
		mainScreen.setVisible(true);//윈도우 창 뜬다.
		mainScreen.setSize(500, 500);
		
		FlowLayout f1= new FlowLayout();//버튼 열거?
		mainScreen.setLayout(f1);    //버튼 2 개 다 나타내기 위해. 열거하기 위해.

		JButton b1=new JButton();
		mainScreen.add(b1);
		b1.setText("SMS");
		b1.setBackground(Color.BLUE);

		
		JButton b2=new JButton();
		mainScreen.add(b2);
		b2.setText("CMS");
		
		//text 받기
		JTextField tf1=new JTextField();
		tf1.setText("Enter text here");
		tf1.setSize(300,300);
		mainScreen.add(tf1);
	}

}
