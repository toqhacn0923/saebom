import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class My_Info extends JPanel{
	
	
	
	public My_Info() {
		
		setLayout(null);
		
		Font a=new Font("����",Font.BOLD,20);
		
		JLabel la_Name=new JLabel("�̸�: ������");
		la_Name.setFont(a);
		la_Name.setSize(130,30);
		la_Name.setLocation(50,50);
		add(la_Name);
		
		JLabel la_Id=new JLabel("�й�: 1111111");
		la_Id.setFont(a);
		la_Id.setSize(150,30);
		la_Id.setLocation(50,100);
		add(la_Id);
		
		JLabel la_Hak=new JLabel("�г�: 4�г�");
		la_Hak.setFont(a);
		la_Hak.setSize(130,30);
		la_Hak.setLocation(50,150);
		add(la_Hak);
		
		
		setSize(500,500);
		setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new My_Info();
	}

}
