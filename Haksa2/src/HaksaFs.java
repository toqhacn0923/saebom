import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class HaksaFs extends JPanel {
	
//	ImageIcon img;
//	public void paintComponent(Graphics g) {
//		Dimension d = getSize();
//		g.drawImage(img.getImage(), 0, 0, d.width, d.height, null);
//		setOpaque(false);
//		super.paintComponent(g);
//	}
//	
//	
	
	public HaksaFs() {
//		setTitle("�л���");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
//		Container c=getContentPane();
//		c.setLayout(new BorderLayout());
		
		JMenuBar mb=new JMenuBar();
		JMenu Menu1 = new JMenu("�޴�");
		JMenu Menu2 = new JMenu("�л�����");
		JMenuItem itemLoad = new JMenuItem("�α׾ƿ�");
		JMenuItem itemExit = new JMenuItem("Exit");
		JMenuItem item2 = new JMenuItem("������");
		JMenuItem item3 = new JMenuItem("�л�����");
		Menu1.add(itemLoad);
		Menu1.addSeparator();
		Menu1.add(itemExit);
		Menu2.add(item2);
		Menu2.add(item3);
		
		mb.add(Menu1);
		mb.add(Menu2);
		
		Login.fr.setJMenuBar(mb);
		
		HaksaFsMenuActionListener listener = new HaksaFsMenuActionListener();

		itemLoad.addActionListener(listener);
		itemExit.addActionListener(listener);
		item2.addActionListener(listener);
		item3.addActionListener(listener);
		
		
		
		
		
		
		setSize(500,500);
		setVisible(true);
	}
	
	
	
	public class HaksaFsMenuActionListener implements ActionListener{
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
			case "Exit":
				System.exit(0);
				break;
			case "������":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new My_Info());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				Login.fr.setResizable(false);
				Login.fr.pack();
				break;
			case "�α׾ƿ�":
				Login.bg.removeAll();
				Login.bg.revalidate();
				Login.bg.repaint();
				Login.bg.add(new Login());
				Login.bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				//Login.fr.pack();
				//Login.fr.setLayout(new BorderLayout());
				break;
			}
		}
	}
	
	

	public static void main(String[] args) {
		new HaksaFs();
	}

}
