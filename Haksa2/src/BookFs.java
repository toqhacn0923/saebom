import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BookFs extends JPanel {
	DefaultTableModel model=null;
	JTable table=null;
	ResultSet rs=null;
	
	public BookFs() {
		
		setLayout(null);
		Font a=new Font("����",Font.BOLD,20);
		
		try {
			rs=DBManager.stmt.executeQuery("select name,id,dept,year from student2 where id='"+Login.tf_id.getText()+"'");
			rs.next();
			JLabel la_Name=new JLabel("�̸�: ");
			la_Name.setFont(a);
			la_Name.setSize(130,30);
			la_Name.setLocation(40,30);
			//la_Name.setBorder(b);
			add(la_Name);

			JLabel la_Rbook=new JLabel("�������Ǽ�: ");
			la_Rbook.setFont(a);
			la_Rbook.setSize(200,30);
			la_Rbook.setLocation(40,80);
			//la_Name.setBorder(b);
			add(la_Rbook);

			JLabel la_All_Rbook=new JLabel("�Ѵ���Ǽ�: ");
			la_All_Rbook.setFont(a);
			la_All_Rbook.setSize(200,30);
			la_All_Rbook.setLocation(40,130);
			//la_Name.setBorder(b);
			add(la_All_Rbook);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
		
		JButton btn_Search=new JButton("��ȸ");
		btn_Search.setSize(80,30);
		btn_Search.setLocation(320, 160);
		add(btn_Search);
		btn_Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showList();


			}
		});

		
		
		
		
		
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		String colName[]={"�й�","�뿩��ȣ","å��ȣ","å�̸�","�뿩��"};  //ǥ������� �÷���
		model=new DefaultTableModel(colName,0); //ǥ�� ������
		table = new JTable(model);  //���̺� ��(������ ) ���ε�
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		//table.setPreferredScrollableViewportSize(new Dimension(250,270)); //������
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(380,190));
		jp.setLocation(30, 200);
		add(jp);
		
		
		
		
		
		
		
		
		
		
		
		
		setSize(450,450);
		setVisible(true);
	}
	
	
	public void showList() {
		try {
			rs=DBManager.stmt.executeQuery(
					"select a.id, c.no, c.bookno, b.title, c.rDate\r\n" + 
					"from student2 a, books b, bookrent c\r\n" + 
					"where a.id=c.id\r\n" + 
					"and b.bookno=c.bookno\r\n"+
					"and a.id='"+Login.tf_id.getText()+"'");
			
			
			//��� �ʱ�ȭ
			model.setNumRows(0);
		
			
			while(rs.next()) {
				
				String[] row=new String[6];
				row[0]=rs.getString("id");
				row[1]=rs.getString("no");
				row[2]=rs.getString("bookno");
				row[3]=rs.getString("title");
				row[4]=rs.getString("rdate");
				model.addRow(row);

//				tf_id.setText("");
//				tf_name.setText("");
//				tf_dept.setText("");
//				tf_adr.setText("");
//				tf_bir.setText("");
//				tf_year.setText("");
					
				
				
				
			}
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	
	public static void main(String[] args) {
		new BookFs();
	}

}
