import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class My_Info extends JPanel{
	
	DBManager db = null;
	ResultSet rs = null;
	
	public My_Info() {
		
		setLayout(null);
		Font a=new Font("�������",Font.BOLD,20);
		//Border b=LineBorder.createBlackLineBorder();
		//setBorder();
		
		
		ImageIcon id=new ImageIcon("images/idp01.png");
		JLabel la_img=new JLabel(id);
		la_img.setLocation(50,50);
		la_img.setSize(150,200);
		add(la_img);
		
		try {
			rs=DBManager.stmt.executeQuery("select name,id,dept,year from student2 where id='"+Login.tf_id.getText()+"'");
			rs.next();
			System.out.println(rs.getString("name"));
			
			JLabel la_Name=new JLabel("�̸�: "+rs.getString("name"));
			la_Name.setFont(a);
			la_Name.setSize(130,30);
			la_Name.setLocation(250,60);
			//la_Name.setBorder(b);
			add(la_Name);
			
			JLabel la_Id=new JLabel("�й�: "+rs.getString("id"));
			la_Id.setFont(a);
			la_Id.setSize(150,30);
			la_Id.setLocation(250,110);
			add(la_Id);
			
			JLabel la_Dept=new JLabel("�а�: "+rs.getString("dept"));
			la_Dept.setFont(a);
			la_Dept.setSize(190,30);
			la_Dept.setLocation(250,160);
			add(la_Dept);
			
			JLabel la_Hak=new JLabel("�г�: "+rs.getString("year"));
			la_Hak.setFont(a);
			la_Hak.setSize(130,30);
			la_Hak.setLocation(250,210);
			add(la_Hak);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new My_Info();
	}

}
