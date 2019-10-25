import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Grade extends JPanel {

	DefaultTableModel model=null;
	JTable table=null;
	ResultSet rs=null;
	JTextField tf_id=new JTextField(20);
	JTextField tf_grade1=new JTextField(20);
	JTextField tf_grade2=new JTextField(20);
	JTextField tf_grade3=new JTextField(20);
	JTextField tf_grade4=new JTextField(20);
	public Grade() {
	
		
		setLayout(null);
		
		
		
		JLabel la_id=new JLabel("학번");
		la_id.setSize(new Dimension(30,30));
		la_id.setLocation(10,10+(0*30));
		add(la_id);
		
		tf_id.setLocation(45,12+(0*30));
		tf_id.setSize(200,25);
		add(tf_id);
		
		JButton btnSearch=new JButton("검색");
		btnSearch.setSize(60,25);
		btnSearch.setLocation(250,12);
		add(btnSearch);


		JLabel la_grade1=new JLabel("1학년");
		la_grade1.setSize(new Dimension(40,30));
		la_grade1.setLocation(10,10+(1*30));
		add(la_grade1);
		
		tf_grade1.setLocation(45,12+(1*30));
		tf_grade1.setSize(200,25);
		add(tf_grade1);
		
		JLabel la_grade2=new JLabel("2학년");
		la_grade2.setSize(new Dimension(40,30));
		la_grade2.setLocation(10,10+(2*30));
		add(la_grade2);
		
		tf_grade2.setLocation(45,12+(2*30));
		tf_grade2.setSize(200,25);
		add(tf_grade2);
		
		JLabel la_grade3=new JLabel("3학년");
		la_grade3.setSize(new Dimension(40,30));
		la_grade3.setLocation(10,10+(3*30));
		add(la_grade3);
		
		tf_grade3.setLocation(45,12+(3*30));
		tf_grade3.setSize(200,25);
		add(tf_grade3);
		
		JLabel la_grade4=new JLabel("4학년");
		la_grade4.setSize(new Dimension(40,30));
		la_grade4.setLocation(10,10+(4*30));
		add(la_grade4);
		
		tf_grade4.setLocation(45,12+(4*30));
		tf_grade4.setSize(200,25);
		add(tf_grade4);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String colName[]={"학번","이름","1학년","2학년","3학년","4학년"};  //표에출력할 컬럼명
		model=new DefaultTableModel(colName,0); //표의 데이터
		table = new JTable(model);  //테이블에 모델(데이터 ) 바인딩
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(70);
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(380,220));
		jp.setLocation(10, 200);
		add(jp);
		
//		table.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				table=(JTable)e.getComponent();
//				model=(DefaultTableModel)table.getModel();
//				String id=(String)model.getValueAt(table.getSelectedRow(), 0); //id
//				String name=(String)model.getValueAt(table.getSelectedRow(), 1);//name
//				String grade_1=(String)model.getValueAt(table.getSelectedRow(), 2);//dept
//				String grade_2=(String)model.getValueAt(table.getSelectedRow(), 3);//address
//				String grade_3=(String)model.getValueAt(table.getSelectedRow(), 4);//bir
//				String grade_4=(String)model.getValueAt(table.getSelectedRow(), 5);//year
//				tf_id.setText(id);
//				tf_name.setText(name);
//				tf_dept.setText(dept);
//				tf_adr.setText(address);
//				tf_bir.setText(bir);
//				tf_year.setText(year);
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {}
//			@Override
//			public void mousePressed(MouseEvent e) {}
//			@Override
//			public void mouseExited(MouseEvent e) {}
//			@Override
//			public void mouseEntered(MouseEvent e) {}
//		});
		
		
		setVisible(true);
		setSize(500,500);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new Grade();
	}

}
