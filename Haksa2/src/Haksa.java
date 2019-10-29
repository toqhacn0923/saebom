import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Haksa extends JPanel{
	//static JFrame f = new JFrame();
	DBManager db = null;
	ResultSet rs = null;
//	static JPanel panel = null;
	ImageIcon imgIcon;
	public Haksa() {
//		db = new DBManager();
//		db.Connection();
//		Login.fr.setTitle("학사관리");
//		Login.fr.setPreferredSize(new Dimension(500,500));
		//setSize(500,500);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = Login.fr.getContentPane();
//		imgIcon=new ImageIcon("images/bg2.jpg");
//		panel = new JPanel();
		JMenuBar mb = new JMenuBar();
		
		JMenu Menu1 = new JMenu("메뉴");
		JMenu Menu2 = new JMenu("학생관리");
		JMenu Menu3 = new JMenu("도서관리");
		
		JMenuItem item1_1 = new JMenuItem("로그아웃");
		JMenuItem item1_2 = new JMenuItem("Exit");
		JMenuItem item2_1 = new JMenuItem("학생정보");
		JMenuItem item2_2 = new JMenuItem("학점관리");
		JMenuItem item3_1 = new JMenuItem("대출목록");
		JMenuItem item3_2 = new JMenuItem("대출현황");
		
		Menu1.add(item1_1);
//		Menu1.addSeparator();
		Menu1.add(item1_2);
		
		Menu2.add(item2_1);
//		Menu2.addSeparator();
		Menu2.add(item2_2);
		
		Menu3.add(item3_1);
//		Menu3.addSeparator();
		Menu3.add(item3_2);
		mb.add(Menu1);
		mb.add(Menu2);
		mb.add(Menu3);
		HaksaMenuActionListener listener = new HaksaMenuActionListener();
		
		item1_1.addActionListener(listener);
		item1_2.addActionListener(listener);
		item2_1.addActionListener(listener);
		item2_2.addActionListener(listener);
		item3_1.addActionListener(listener);
		item3_2.addActionListener(listener);
		
		Login.fr.setJMenuBar(mb);
//		this.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				try {
//					db.Close();
//				}
//				catch(Exception we) {
//					we.printStackTrace();
//				}
//			}
//		});
//		add(panel);
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setLocation((screenSize.width-Login.fr.getPreferredSize().width)/2,(screenSize.height-Login.fr.getPreferredSize().height)/2);
//		Login.fr.pack();
//		Login.fr.setResizable(false);
		setSize(500,500);
		setVisible(true);
	}

	public class HaksaMenuActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {
			case "학생정보":
				System.out.println("학생정보");
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new Student());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				Login.fr.setResizable(false);
				Login.fr.pack();
				break;
			case "로그아웃":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new Login().bg);
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				//Login.fr.pack();
				//Login.fr.setLayout(new BorderLayout());
				break;
			case "Exit":
				System.exit(0);
			case "대출목록":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new BookRent());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(490,400));
				Login.fr.setResizable(false);
				Login.fr.pack();
				break;
			case "대출현황":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new BookGraph2());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(620,500));
				Login.fr.pack();
				//Login.fr.setLayout(new BorderLayout());
				break;
			case "학점관리":
				System.out.println("학점관리");
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new Grade());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				Login.fr.pack();
				break;
			}
		}
	}
	public static void main(String[] args) {
		new Haksa();
	}
}

// 그룹별  대출현황을 groupby를 통해 차트로 표현











