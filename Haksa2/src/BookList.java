import java.awt.Dimension;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class BookList extends JPanel {
	DefaultTableModel model=null;
	JTable table=null;
	ResultSet rs=null;
	
	
	public BookList() {
		setLayout(null);
		
		
		
		
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		DefaultTableCellRenderer celAlignRight = new DefaultTableCellRenderer();
		celAlignRight.setHorizontalAlignment(JLabel.RIGHT);
		
		String colName[]={"å��ȣ","����","����"};  //ǥ������� �÷���
		model=new DefaultTableModel(colName,0); //ǥ�� ������
		table = new JTable(model);  //���̺� ��(������ ) ���ε�
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		//table.setPreferredScrollableViewportSize(new Dimension(250,270)); //������
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(200,300));
		jp.setLocation(10, 30);
		add(jp);
		
		
		
		
		
		
		
		
		
		
		setSize(500,450);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BookList();
	}

}
