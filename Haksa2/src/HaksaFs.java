import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HaksaFs extends JFrame {
	
	
	
	public HaksaFs() {
		setTitle("학생용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		JMenuBar mb=new JMenuBar();
		JMenu Menu1 = new JMenu("내정보");
		JMenu Menu2 = new JMenu("학점정보");
		JMenuItem itemLoad = new JMenuItem("학생정보");
		JMenuItem itemExit = new JMenuItem("Exit");
		JMenuItem item2 = new JMenuItem("대출목록");
		JMenuItem item3 = new JMenuItem("대출현황");
		Menu1.add(itemLoad);
		Menu1.addSeparator();
		Menu1.add(itemExit);
		Menu2.add(item2);
		Menu2.add(item3);
		
		mb.add(Menu1);
		mb.add(Menu2);
		
		c.add(mb);
		
		
		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new HaksaFs();
	}

}
