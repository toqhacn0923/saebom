import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Grade extends JPanel {

	DefaultTableModel model=null;
	JTable table=null;
	ResultSet rs=null;
	JTextField tf_id=new JTextField(20);
//	JTextField tf_name=new JTextField(20);
	JTextField tf_grade1=new JTextField(20);
	JTextField tf_grade2=new JTextField(20);
	JTextField tf_grade3=new JTextField(20);
	JTextField tf_grade4=new JTextField(20);
	public Grade() {
	
		BtnAction btnAction=new BtnAction();
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
		
//		JLabel la_name=new JLabel("이름");
//		la_name.setSize(new Dimension(30,30));
//		la_name.setLocation(10,10+(1*30));
//		add(la_name);
//		
//		tf_name.setLocation(45,12+(1*30));
//		tf_name.setSize(200,25);
//		add(tf_name);


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
		
		JButton btnInsert=new JButton("등록");
		btnInsert.setSize(80,30);
		btnInsert.setLocation(10,400);
		btnInsert.addActionListener(btnAction);
		add(btnInsert);
		
		JButton btnUpdate=new JButton("수정");
		btnUpdate.setSize(80,30);
		btnUpdate.setLocation(190,400);
		btnUpdate.addActionListener(btnAction);
		add(btnUpdate);
		
		
		JButton btnList=new JButton("목록");
		btnList.setSize(80,30);
		btnList.setLocation(100,400);
		btnList.addActionListener(btnAction);
		add(btnList);
//		btnList.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				showList();
//
//				
//			}
//		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		String colName[]={"학번","1학년","2학년","3학년","4학년"};  //표에출력할 컬럼명
		model=new DefaultTableModel(colName,0); //표의 데이터
		table = new JTable(model);  //테이블에 모델(데이터 ) 바인딩
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(70);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		//table.getColumnModel().getColumn(5).setPreferredWidth(70);
		JScrollPane jp = new JScrollPane(table);
		jp.setSize(new Dimension(380,220));
		jp.setLocation(10, 170);
		add(jp);
		
		// DefaultTableCellHeaderRenderer 생성 (가운데 정렬을 위한)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRenderer의 정렬을 가운데 정렬로 지정
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		// 정렬할 테이블의 ColumnModel을 가져옴
		TableColumnModel tcmSchedule = table.getColumnModel();
		// 반복문을 이용하여 테이블을 가운데 정렬로 지정
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				table=(JTable)e.getComponent();
				model=(DefaultTableModel)table.getModel();
				String id=(String)model.getValueAt(table.getSelectedRow(), 0); //id
				//String name=(String)model.getValueAt(table.getSelectedRow(), 1);//name
				String grade_1=(String)model.getValueAt(table.getSelectedRow(), 1);//dept
				String grade_2=(String)model.getValueAt(table.getSelectedRow(), 2);//address
				String grade_3=(String)model.getValueAt(table.getSelectedRow(), 3);//bir
				String grade_4=(String)model.getValueAt(table.getSelectedRow(), 4);//year
				tf_id.setText(id);
				//tf_name.setText(name);
				tf_grade1.setText(grade_1);
				tf_grade2.setText(grade_2);
				tf_grade3.setText(grade_3);
				tf_grade4.setText(grade_4);
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
		
		
		setVisible(true);
		setSize(500,500);
		
	}
	
	class BtnAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case"등록":
				
				break;
			case"목록":
				showList();
				break;
			}
		}
		
	}
	
	public void showList() {
		try {
			rs=DBManager.stmt.executeQuery("select * from grade order by id");


			//목록 초기화
			model.setNumRows(0);

			while(rs.next()) {
				String[] row=new String[5];
				row[0]=rs.getString("id");
				row[1]=rs.getString("grade_1");
				row[2]=rs.getString("grade_2");
				row[3]=rs.getString("grade_3");
				row[4]=rs.getString("grade_4");
				model.addRow(row);

				tf_id.setText("");
				tf_grade1.setText("");
				tf_grade2.setText("");
				tf_grade3.setText("");
				tf_grade4.setText("");

			}

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}


	
	
	public static void main(String[] args) {
		new Grade();
	}

}
