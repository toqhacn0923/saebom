
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
	
	DefaultTableModel model=null;
	JTable table=null;
	//Connection conn=null;
	ResultSet rs=null;
	
	public Student() {
		
		
		setLayout(null);
		JLabel la_id=new JLabel("�й�");
		la_id.setSize(new Dimension(30,30));
		la_id.setLocation(10,10+(0*30));
		add(la_id);
		
		tf_id.setLocation(45,12+(0*30));
		tf_id.setSize(200,25);
		add(tf_id);
		
		JButton btnSearch1=new JButton("�˻�");
		btnSearch1.setSize(60,25);
		btnSearch1.setLocation(250,12);
		btnSearch1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Statement stmt = null;
				try {
					//stmt=conn.createStatement();					
	
					rs=DBManager.stmt.executeQuery("select * from student2 where id='"+tf_id.getText()+"'");
	

					
					//����ʱ�ȭ
					model.setNumRows(0);
					
					while(rs.next()) {
						String[] row=new String[4];
						row[0]=rs.getString("id");
						row[1]=rs.getString("name");
						row[2]=rs.getString("dept");
						row[3]=rs.getString("address");
						model.addRow(row);
						
						tf_name.setText(rs.getString("name"));
						tf_dept.setText(rs.getString("dept"));
						tf_dept.setText(rs.getString("address"));
						
					}
					
					
					
					rs.close();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		
		add(btnSearch1);
		
		
		JLabel la_name=new JLabel("�̸�");
		la_name.setSize(new Dimension(30,30));
		la_name.setLocation(10,10+(1*30));
		add(la_name);
		
		tf_name.setLocation(45,12+(1*30));
		tf_name.setSize(200,25);
		add(tf_name);
		
		
		
		JLabel la_dept=new JLabel("�а�");
		la_dept.setSize(new Dimension(30,30));
		la_dept.setLocation(10,10+(2*30));
		add(la_dept);
		tf_dept.setLocation(45,12+(2*30));
		tf_dept.setSize(200,25);
		add(tf_dept);
		
		
		
		
		
		JLabel la_adr=new JLabel("�ּ�");
		la_adr.setSize(new Dimension(30,30));
		la_adr.setLocation(10,10+(3*30));
		add(la_adr);
		tf_adr.setLocation(45,12+(3*30));
		tf_adr.setSize(200,25);
		add(tf_adr);
		
		
		
		

		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		String colName[]={"�й�","�̸�","�а�","�ּ�"};  //ǥ������� �÷���
		model=new DefaultTableModel(colName,0); //ǥ�� ������
		table = new JTable(model);  //���̺� ��(������ ) ���ε�
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		//table.setPreferredScrollableViewportSize(new Dimension(250,270)); //������
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(360,250));
		jp.setLocation(10, 140);
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
				
				tf_id.setText(id);
				tf_name.setText(name);
				tf_dept.setText(dept);
				tf_adr.setText(address);
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
		
		JButton btnInsert=new JButton("���");
		btnInsert.setSize(80,30);
		btnInsert.setLocation(10,400);
		btnInsert.addActionListener(new MyAction());
		add(btnInsert);
		
		
		JButton btnList=new JButton("���");
		btnList.setSize(80,30);
		btnList.setLocation(100,400);
		add(btnList);
		btnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();

				
			}
		});
		
		JButton btnUpdate=new JButton("����");
		btnUpdate.setSize(80,30);
		btnUpdate.setLocation(190,400);
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Statement stmt = null;
				try {
	
					DBManager.stmt.executeUpdate("update student2 set name='"+tf_name.getText()+"',dept='"+tf_dept.getText()+"',address='"+tf_adr.getText()+"' where id='"+tf_id.getText()+"'");
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
					
					showList();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		add(btnUpdate);
		
		JButton btnDelete=new JButton("����");
		btnDelete.setSize(80,30);
		btnDelete.setLocation(280,400);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
	
					int result=JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "Ȯ��",2);
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
//		private JLabel lb_H=new JLabel("�Է��Ͻ� ������ �ٽ��ѹ� Ȯ�����ּ���");
//		private JButton btn=new JButton("Ȯ��");
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
				
				DBManager.stmt.executeUpdate("insert into student2(id,name,dept) values('"+tf_id.getText()+"','"+tf_name.getText()+"','"+tf_dept.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
				
				showList();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void showList() {
		try {
			rs=DBManager.stmt.executeQuery("select * from student2");
			
			
			//��� �ʱ�ȭ
			model.setNumRows(0);
			
			while(rs.next()) {
				String[] row=new String[4];
				row[0]=rs.getString("id");
				row[1]=rs.getString("name");
				row[2]=rs.getString("dept");
				row[3]=rs.getString("address");
				model.addRow(row);
				
				tf_id.setText("");
				tf_name.setText("");
				tf_dept.setText("");
				tf_adr.setText("");
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Student();
		
	}

}