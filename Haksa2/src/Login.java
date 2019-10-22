import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Login extends JFrame{
	static JPanel bg;
	static JPanel main;
	ImageIcon imgIcon;
	JScrollPane scrollPane;
	Student st=new Student();
	DBManager db = null;
	static JFrame fr=new JFrame();
	
	JTextField tf_id=new JTextField(20);
	JPasswordField tf_ps=new JPasswordField(20);

	
	public Login() {
		db = new DBManager();
		db.Connection();
		
		fr.setTitle("학사관리시스템");
		fr.setSize(500,500);
		
		
		
		imgIcon=new ImageIcon("images/bg2.jpg");
		bg=new JPanel(null) {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(imgIcon.getImage(), 0, 0, d.width, d.height, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		main=new JPanel(null);
		
		JLabel la_main=new JLabel("학사관리시스템");
		la_main.setFont(new Font("Serif",Font.BOLD,25));
		la_main.setLocation(150,200);
		la_main.setSize(200,30);
		bg.add(la_main);
		
		JLabel la_id=new JLabel("ID");
		la_id.setFont(new Font("Serif",Font.BOLD,22));
		la_id.setLocation(108,250);
		la_id.setSize(la_id.getPreferredSize().getSize());
		bg.add(la_id);
		
		
		tf_id.setLocation(140,250);
		tf_id.setSize(210,30);
		bg.add(tf_id);
		
		
		
		JLabel la_ps=new JLabel("password");
		la_ps.setFont(new Font("Serif",Font.BOLD,22));
		la_ps.setLocation(41,300);
		la_ps.setSize(la_ps.getPreferredSize().getSize());
		bg.add(la_ps);
		
		
		tf_ps.setLocation(140,300);
		tf_ps.setSize(210,30);
		bg.add(tf_ps);
		
		JButton btn_join=new JButton("회원가입");
		btn_join.setLocation(150,350);
		btn_join.setSize(90,30);
		bg.add(btn_join);
		
		JButton btn_login=new JButton("로그인");
		btn_login.setLocation(260,350);
		btn_login.setSize(80,30);
		
		ma m1=new ma();
		btn_login.addActionListener(m1);
		bg.add(btn_login);
		
		
		scrollPane = new JScrollPane(bg);
		setContentPane(scrollPane);
		
		Container c=fr.getContentPane();
		fr.add(bg);
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					db.Close();
				}
				catch(Exception we) {
					we.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		bg.setOpaque(false);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);
	}
	
	public class ma implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String s_ps=new String(tf_ps.getPassword());
			if(tf_id.getText().equals("admin")&&s_ps.equals("1234")) {
//				bg=new JPanel(null) {
//					public void paintComponent(Graphics g) {
//						Dimension d = getSize();
//						//g.drawImage(null, 0, 0, d.width, d.height, null);
//						setOpaque(false);
//						super.paintComponent(g);
//						
//					}
//				};
//				fr.add(bg);
				bg.removeAll();
				bg.revalidate();
				bg.repaint();
				bg.add(new Haksa());
				bg.setLayout(null);
				Login.fr.setPreferredSize(new Dimension(500,500));
				Login.fr.setResizable(false);
				Login.fr.pack();
				JOptionPane.showMessageDialog(fr, "관리자로 로그인되었습니다.");
				
			}
			else {
				JOptionPane.showMessageDialog(fr,"ID와패스워드를 확인하세요",null,2);
			}
		}
		
	}
	


	public static void main(String[] args) {
		new Login();
	}

}
















