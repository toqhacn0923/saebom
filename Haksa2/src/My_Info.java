import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class My_Info extends JPanel{
	
	DBManager db = null;
	ResultSet rs = null;
	DefaultTableModel model=null;
	JTable table=null;
	public My_Info() {
		
		setLayout(null);
		Font a=new Font("맑은고딕",Font.BOLD,20);
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
			
			JLabel la_Name=new JLabel("이름: "+rs.getString("name"));
			la_Name.setFont(a);
			la_Name.setSize(130,30);
			la_Name.setLocation(250,60);
			//la_Name.setBorder(b);
			add(la_Name);
			
			JLabel la_Id=new JLabel("학번: "+rs.getString("id"));
			la_Id.setFont(a);
			la_Id.setSize(150,30);
			la_Id.setLocation(250,110);
			add(la_Id);
			
			JLabel la_Dept=new JLabel("학과: "+rs.getString("dept"));
			la_Dept.setFont(a);
			la_Dept.setSize(190,30);
			la_Dept.setLocation(250,160);
			add(la_Dept);
			
			JLabel la_Hak=new JLabel("학년: "+rs.getString("year"));
			la_Hak.setFont(a);
			la_Hak.setSize(130,30);
			la_Hak.setLocation(250,210);
			add(la_Hak);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		JButton btn_Search=new JButton("성적조회");
		btn_Search.setSize(100,30);
		btn_Search.setLocation(320, 280);
		add(btn_Search);
		btn_Search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					rs=DBManager.stmt.executeQuery("select * from grade where id='"+Login.tf_id.getText()+"'");
					model.setNumRows(0);

					while(rs.next()) {
						String[] row=new String[5];
						row[0]=rs.getString("id");
						row[1]=rs.getString("grade_1");
						row[2]=rs.getString("grade_2");
						row[3]=rs.getString("grade_3");
						row[4]=rs.getString("grade_4");
						model.addRow(row);

						

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);

		String colName[]={"학번","1학년평균","2학년평균","3학년평균","4학년평균"};  //표에출력할 컬럼명
		model=new DefaultTableModel(colName,0); //표의 데이터
		table = new JTable(model);  //테이블에 모델(데이터 ) 바인딩
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		//table.setPreferredScrollableViewportSize(new Dimension(250,270)); //사이즈
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(380,110));
		jp.setLocation(50, 320);
		add(jp);

		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
		
		
		
	}

	public static void main(String[] args) {
		new My_Info();
	}

}
