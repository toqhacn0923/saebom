import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Haksa extends JFrame{

	private JTextField tf_id=new JTextField(14);
	private JTextField tf_name=new JTextField(20);
	private JTextField tf_dept=new JTextField(20);
	private JTextField tf_adr=new JTextField(20);
	
	DefaultTableModel model=null;
	JTable table=null;
	Connection conn=null;
	
	public Haksa() {
		try {
		//DB����
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle", "ora_user", "hong");
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.setTitle("�л����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
		
		
		Container c=this.getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�й�"));
		c.add(tf_id);
		
		JButton btnSearch=new JButton("�˻�");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Statement stmt = null;
				try {
					stmt=conn.createStatement();					
	
					ResultSet rs=stmt.executeQuery("select * from student2 where id='"+tf_id.getText()+"'");
	

					
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
		
		c.add(btnSearch);
		
		
		c.add(new JLabel("�̸�"));
		c.add(tf_name);
		
		c.add(new JLabel("�а�"));
		c.add(tf_dept);
		
		c.add(new JLabel("�ּ�"));
		c.add(tf_adr);
		

		
		String colName[]={"�й�","�̸�","�а�","�ּ�"};  //ǥ������� �÷���
		model=new DefaultTableModel(colName,0); //ǥ�� ������
		table = new JTable(model);  //���̺� ��(������ ) ���ε�
		table.setPreferredScrollableViewportSize(new Dimension(250,270)); //������
		c.add(new JScrollPane(table));
		
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
		btnInsert.addActionListener(new MyAction());
		c.add(btnInsert);
		
		
		JButton btnList=new JButton("���");
		c.add(btnList);
		btnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();

				
			}
		});
		
		JButton btnUpdate=new JButton("����");
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Statement stmt = null;
				try {
					stmt=conn.createStatement();					
	
					stmt.executeUpdate("update student2 set name='"+tf_name.getText()+"',dept='"+tf_dept.getText()+"',address='"+tf_adr.getText()+"' where id='"+tf_id.getText()+"'");
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
					
					showList();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		c.add(btnUpdate);
		
		JButton btnDelete=new JButton("����");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ddialog.setVisible(true);
				Statement stmt = null;
				try {
					stmt=conn.createStatement();					
	
					int result=JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "Ȯ��",2);
					if (result==JOptionPane.YES_OPTION) {
						stmt.executeUpdate("delete from student2 where id='"+tf_id.getText()+"'");
					}
					showList();
				}catch (Exception e1) {
					 e1.printStackTrace();
				}
				
			}
		});
		c.add(btnDelete);
		
		
		
		
		
		this.setSize(300,500);
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
			
			
			Statement stmt=null;	
			ResultSet rs=null;
			try {
				stmt=conn.createStatement();
				//rs=stmt.executeQuery("select * from student2");
				
				stmt.executeUpdate("insert into student2(id,name,dept) values('"+tf_id.getText()+"','"+tf_name.getText()+"','"+tf_dept.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
				
				showList();
				
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void showList() {
		Statement stmt=null;	
		ResultSet rs=null;
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from student2");
			
			
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
		new Haksa();
		
	}

}
