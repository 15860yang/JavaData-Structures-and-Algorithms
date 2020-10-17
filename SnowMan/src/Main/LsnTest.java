package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LsnTest extends JFrame{
	public LsnTest() {
		setBounds(400, 100, 600, 500);
		JPanel jpn = new JPanel();
		final JButton jbt = new JButton("���������");
//		����ť��� �¼� ������ ���ڲ�׽��ť�ϵĶ��� MyListener ���¼��ľ��崦����
		jbt.addMouseListener(new MyListener(jbt));
		
//		�ı���
		JTextArea jta = new JTextArea(10,50);
//		���ÿؼ� ���ı������Լ���С
		jta.setFont(new Font("����",2,20));
//		���ÿؼ���  �ı���ɫ
		jta.setForeground(Color.red);
//		���ı�����Ӽ����¼� �����������ڲ�׽�ؼ��ϵļ����¼�
//		MyKeyListener �ڲ���������׽�����¼�
		jta.addKeyListener(new MyKeyListener(jta));
//		�����ı���ؼ��� �༭����
		jta.setEditable(false);
		
		jpn.add(jta);
		jpn.add(jbt);
		
		this.add(jpn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new LsnTest();
	}
	
//	�¼�������
	private class MyListener extends MouseAdapter{
		JButton jbt = null;
		public MyListener(JButton jbt) {
			this.jbt = jbt;
		}
//		������¼�������
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");
			jbt.setBackground(Color.pink);
		}
	}
	class MyKeyListener extends KeyAdapter{
		JTextArea jta = null;
		public MyKeyListener(JTextArea jta) {
			this.jta = jta;
		}
//		�����¼�������
		@Override
		public void keyPressed(KeyEvent e) {
			int in = e.getKeyCode();
			char cc = (char)(in+32);
			System.out.println(cc+"");
			
//			setText ����  JTextArea ���� JTextField �����ݣ� 
//			û������ �����ݻ��滻 ������
//			jta.setText(cc+"");
//			�ı���� ����׷�� 
			jta.append(cc+"");
		}

	}
}
