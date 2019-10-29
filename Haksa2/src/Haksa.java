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
//		Login.fr.setTitle("�л����");
//		Login.fr.setPreferredSize(new Dimension(500,500));
		//setSize(500,500);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = Login.fr.getContentPane();
//		imgIcon=new ImageIcon("images/bg2.jpg");
//		panel = new JPanel();
		JMenuBar mb = new JMenuBar();
		
		JMenu Menu1 = new JMenu("�޴�");
		JMenu Menu2 = new JMenu("�л�����");
		JMenu Menu3 = new JMenu("��������");
		
		JMenuItem item1_1 = new JMenuItem("�α׾ƿ�");
		JMenuItem item1_2 = new JMenuItem("Exit");
		JMenuItem item2_1 = new JMenuItem("�л�����");
		JMenuItem item2_2 = new JMenuItem("��������");
		JMenuItem item3_1 = new JMenuItem("������");
		JMenuItem item3_2 = new JMenuItem("������Ȳ");
		
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
			case "�л�����":
				System.out.println("�л�����");
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new Student());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				Login.fr.setResizable(false);
				Login.fr.pack();
				break;
			case "�α׾ƿ�":
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
			case "������":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new BookRent());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(490,400));
				Login.fr.setResizable(false);
				Login.fr.pack();
				break;
			case "������Ȳ":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new BookGraph2());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(620,500));
				Login.fr.pack();
				//Login.fr.setLayout(new BorderLayout());
				break;
			case "��������":
				System.out.println("��������");
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

// �׷캰  ������Ȳ�� groupby�� ���� ��Ʈ�� ǥ��











