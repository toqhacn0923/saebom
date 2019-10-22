import java.awt.Dimension;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookRent extends JPanel{
	DefaultTableModel model=null;
	JTable table=null;
	//Connection conn=null;
	//Statement stmt=null;
	String sql=null;
	ResultSet rs=null;
	
	
	public BookRent() {
		
		

	sql="select a.id, a.name, b.title, c.rdate" + 
			" from student2 a, books b, bookrent c" + 
			" where a.id=c.id" + 
			" and b.bookno=c.bookno";
	
    setLayout(null);//레이아웃설정. 레이아웃 사용 안함.
   
    JLabel l_dept=new JLabel("학과");
    l_dept.setBounds(10, 10, 30, 20);
    add(l_dept);
    
    String colName[]={"학번","이름","도서명","대출일"};
    model=new DefaultTableModel(colName,0);
    table = new JTable(model);
    table.setPreferredScrollableViewportSize(new Dimension(470,200));
    add(table);
    JScrollPane sp=new JScrollPane(table);
    sp.setBounds(10, 40, 460, 250);
    add(sp); 
    
    
    
   
   
    String[] dept={"전체","컴퓨터시스템","멀티미디어","컴퓨터공학"};
    JComboBox cb_dept=new JComboBox(dept);
    cb_dept.setBounds(45, 10, 100, 20);
    cb_dept.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox cb=(JComboBox)e.getSource();
			int a=cb.getSelectedIndex();
			if(a==0) {
				 sql="select a.id, a.name, b.title, c.rdate" + 
							" from student2 a, books b, bookrent c" + 
							" where a.id=c.id" + 
							" and b.bookno=c.bookno";
				list();
			}
			
			else if(a==1) {
				System.out.println("컴퓨터시스템");
				sql="select a.id, a.name, b.title, c.rdate" + 
						" from student2 a, books b, bookrent c" + 
						" where a.id=c.id" + 
						" and b.bookno=c.bookno"+
						" and a.dept='컴퓨터시스템'";
				list();
			}
			else if(a==2) {
				sql="select a.id, a.name, b.title, c.rdate" + 
						" from student2 a, books b, bookrent c" + 
						" where a.id=c.id" + 
						" and b.bookno=c.bookno"+
						" and a.dept='멀티미디어'";
				list();
			}
			else if(a==3) {
				sql="select a.id, a.name, b.title, c.rdate" + 
						" from student2 a, books b, bookrent c" + 
						" where a.id=c.id" + 
						" and b.bookno=c.bookno"+
						" and a.dept='컴퓨터공학'";
				list();
			}
		}
	});
    add(cb_dept);
    
    setSize(490, 400);//화면크기
    setVisible(true);
    
    //전체목록
    list();
    
    
	}
	
	
	public void list(){
	    try{
	     //System.out.println("연결되었습니다.....");
	    
	     // Select문 실행     
	     rs=DBManager.stmt.executeQuery(sql);
	    
	     //JTable 초기화
	     model.setNumRows(0);
	    
	     while(rs.next()){
	      String[] row=new String[4];//컬럼의 갯수가 4
	      row[0]=rs.getString("id");
	      row[1]=rs.getString("name");
	      row[2]=rs.getString("title");
	      row[3]=rs.getString("rdate");
	      model.addRow(row);
	     }
	     rs.close();
	    
	    }
	    catch(Exception e1){
	     e1.printStackTrace();
	     System.out.println(e1.getMessage());
	    }
	 }
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new BookRent();
	}	
}