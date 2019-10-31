
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel{

	JTextField tf_id=new JTextField(20);
	JTextField tf_name=new JTextField(20);
	JTextField tf_dept=new JTextField(20);
	JTextField tf_adr=new JTextField(20);
	JTextField tf_bir=new JTextField(20);
	JTextField tf_year=new JTextField(20);
	
	DefaultTableModel model=null;
	JTable table=null;
	ResultSet rs=null;
	
	public Student() {
		
		
		setLayout(null);
		JLabel la_id=new JLabel("학번");
		la_id.setSize(new Dimension(30,30));
		la_id.setLocation(10,10+(0*30));
		add(la_id);
		
		tf_id.setLocation(45,12+(0*30));
		tf_id.setSize(200,25);
		add(tf_id);
		
		JButton btnSearch1=new JButton("검색");
		btnSearch1.setSize(60,25);
		btnSearch1.setLocation(250,12);
		btnSearch1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Statement stmt = null;
				try {
					//stmt=conn.createStatement();					
	
					rs=DBManager.stmt.executeQuery("select * from student2 where id='"+tf_id.getText()+"'");
	

					
					//목록초기화
					model.setNumRows(0);
					
					while(rs.next()) {
						String[] row=new String[6];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						row[4]=rs.getString("bir");
						row[5]=rs.getString("year");
						model.addRow(row);
						
						tf_name.setText(rs.getString("name"));
						tf_dept.setText(rs.getString("dept"));
						tf_adr.setText(rs.getString("address"));
						tf_bir.setText(rs.getString("bir"));
						tf_year.setText(rs.getString("year"));
						
					}
					
					
					
					rs.close();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		
		add(btnSearch1);
		
		
		JLabel la_name=new JLabel("이름");
		la_name.setSize(new Dimension(30,30));
		la_name.setLocation(10,10+(1*30));
		add(la_name);
		
		tf_name.setLocation(45,12+(1*30));
		tf_name.setSize(200,25);
		add(tf_name);
		
		
		
		JLabel la_dept=new JLabel("학과");
		la_dept.setSize(new Dimension(30,30));
		la_dept.setLocation(10,10+(2*30));
		add(la_dept);
		tf_dept.setLocation(45,12+(2*30));
		tf_dept.setSize(200,25);
		add(tf_dept);
		
		
		
		
		
		JLabel la_adr=new JLabel("주소");
		la_adr.setSize(new Dimension(30,30));
		la_adr.setLocation(10,10+(3*30));
		add(la_adr);
		tf_adr.setLocation(45,12+(3*30));
		tf_adr.setSize(200,25);
		add(tf_adr);
		
		
		JLabel la_bir=new JLabel("생일");
		la_bir.setSize(new Dimension(30,30));
		la_bir.setLocation(10,10+(4*30));
		add(la_bir);
		tf_bir.setLocation(45,12+(4*30));
		tf_bir.setSize(200,25);
		add(tf_bir);
		
		JLabel la_year=new JLabel("학년");
		la_year.setSize(new Dimension(30,30));
		la_year.setLocation(10,10+(5*30));
		add(la_year);
		tf_year.setLocation(45,12+(5*30));
		tf_year.setSize(200,25);
		add(tf_year);
		
		
		
		

		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		String colName[]={"학번","이름","학과","주소","생일","학년"};  //표에출력할 컬럼명
		model=new DefaultTableModel(colName,0); //표의 데이터
		table = new JTable(model);  //테이블에 모델(데이터 ) 바인딩
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		//table.setPreferredScrollableViewportSize(new Dimension(250,270)); //사이즈
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(380,190));
		jp.setLocation(10, 200);
		add(jp);
		
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				table=(JTable)e.getComponent();
				model=(DefaultTableModel)table.getModel();
				String id=(String)model.getValueAt(table.getSelectedRow(), 0); //id
				String name=(String)model.getValueAt(table.getSelectedRow(), 1);//name
				String dept=(String)model.getValueAt(table.getSelectedRow(), 2);//dept
				String address=(String)model.getValueAt(table.getSelectedRow(), 3);//address
				String bir=(String)model.getValueAt(table.getSelectedRow(), 4);//bir
				String year=(String)model.getValueAt(table.getSelectedRow(), 5);//year
				tf_id.setText(id);
				tf_name.setText(name);
				tf_dept.setText(dept);
				tf_adr.setText(address);
				tf_bir.setText(bir);
				tf_year.setText(year);
			}

			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
		});
		
		JButton btnInsert=new JButton("등록");
		btnInsert.setSize(80,30);
		btnInsert.setLocation(10,400);
		btnInsert.addActionListener(new MyAction());
		add(btnInsert);
		
		
		JButton btnList=new JButton("목록");
		btnList.setSize(80,30);
		btnList.setLocation(100,400);
		add(btnList);
		btnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();

				
			}
		});
		
		JButton btnUpdate=new JButton("수정");
		btnUpdate.setSize(80,30);
		btnUpdate.setLocation(190,400);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				Statement stmt = null;
				try {
	
					DBManager.stmt.executeUpdate("update student2 set name='"+tf_name.getText()+"',dept='"+tf_dept.getText()+"',address='"+tf_adr.getText()+"',bir='"+tf_bir.getText()+"',year='"+tf_year.getText()+"' where id='"+tf_id.getText()+"'");
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					
					showList();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		add(btnUpdate);
		
		JButton btnDelete=new JButton("삭제");
		btnDelete.setSize(80,30);
		btnDelete.setLocation(280,400);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	
					int result=JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "확인",2);
					if (result==JOptionPane.YES_OPTION) {
						DBManager.stmt.executeUpdate("delete from student2 where id='"+tf_id.getText()+"'");
					}
					showList();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
				
			}
		});
		add(btnDelete);
		
		
		
		
		
		this.setSize(500,500);
		this.setVisible(true);
	}
	
//	class InsertDialog extends JDialog{
//		private JLabel lb_H=new JLabel("입력하신 정보를 다시한번 확인해주세요");
//		private JButton btn=new JButton("확인");
//		public InsertDialog(JFrame frame, String title) {
//			super(frame,title);
//			this.setLayout(new FlowLayout());
//			
//			btn.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					setVisible(false);
//				}
//			});
//			this.add(lb_H);
//			this.add(btn);
//			setSize(300,200);
//			
//		}
//	}
	
	
	
	class MyAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
//			if(tf_id.getText().equals("")) {
//				idialog.setVisible(true);
//			}
//			else if(tf_name.getText().equals("")) {
//				idialog.setVisible(true);
//			}
//			else if(tf_dept.getText().equals("")) {
//				idialog.setVisible(true);
//			}
//			else if(tf_adr.getText().equals("")) {
//				idialog.setVisible(true);
//			}
			
			
				
			
			try {
				
				DBManager.stmt.executeUpdate("insert into student2(id,name,dept,address,bir,year) values('"+tf_id.getText()+"','"+tf_name.getText()+"','"+tf_dept.getText()+"','"+tf_adr.getText()+"','"+tf_bir.getText()+"','"+tf_year.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "등록되었습니다.");
				
				showList();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void showList() {
		try {
			rs=DBManager.stmt.executeQuery("select * from student2 order by id");
			
			
			//목록 초기화
			model.setNumRows(0);
			
			while(rs.next()) {
				String[] row=new String[6];
				row[0]=rs.getString("id");
				row[1]=rs.getString("name");
				row[2]=rs.getString("dept");
				row[3]=rs.getString("address");
				row[4]=rs.getString("bir");
				row[5]=rs.getString("year");
				model.addRow(row);
				
				tf_id.setText("");
				tf_name.setText("");
				tf_dept.setText("");
				tf_adr.setText("");
				tf_bir.setText("");
				tf_year.setText("");
				
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Student();
		
	}

}