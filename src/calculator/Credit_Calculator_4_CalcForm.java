	//���� �������� � ���� ��� ���������� ������������.
	package calculator;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.util.Scanner;

	//����� �������� ���� ������������.
	public class Credit_Calculator_4_CalcForm extends JFrame
	{

		//�������� ��������� ��� ���� ������������.
		public JTextField vvod; 
		public JTextField vvod1; 
		public JTextField vvod2; 
		public JButton knopka;
		public JLabel vuvod; 
		public JLabel vuvod1; 
		public JLabel vuvod2; 
		public JLabel vuvod3; 

		public Credit_Calculator_4_CalcForm()

			{
			//������� ������������ ����, ��� �������� � ��������.
			setTitle("��������� �����������");
			setLocation(400,400);
			setSize(700,200);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			//���������� ���������� ��� ���������� ����� � ������.
			Container con = getContentPane();
			con.setLayout(new FlowLayout());

			//�������� ������� ���� ��� �����(��������� �����).
			vvod = new JTextField(45);
			con.add(vvod);
			String word = (vvod.getText());

			//�������� �������������� ������ ��� ������� ���� �����.
			vuvod1 = new JLabel("��������� �����");
			con.add(vuvod1);

			//�������� ������� ���� ��� �����(���������� �������).
			vvod1 = new JTextField(45);
			con.add(vvod1);
			String word1 = (vvod1.getText());

			//�������� �������������� ������ ��� ������� ���� �����.
			vuvod2 = new JLabel("���������� �������");
			con.add(vuvod2);

			//�������� �������� ���� ��� �����(���������� ������).
			vvod2 = new JTextField(50);
			con.add(vvod2);
			String word2 = (vvod2.getText());

			//�������� �������������� ������ ��� �������� ���� �����.
			vuvod3 = new JLabel("���������� ������");
			con.add(vuvod3);

			//�������� ������ ��� �������� �������.
			knopka = new JButton("����������");
			knopka.setActionCommand("123");
			con.add(knopka);
	
			//�������� ���� ������ ����������.
			vuvod = new JLabel();
			con.add(vuvod);

			//������ �� ���� ���� �������� ����� ����� � ������ ����.
			vvod.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume(); 
					}
				}
			});

			//������ �� ���� ���� �������� ����� ����� �� ������ ����.
			vvod1.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume(); 
					}
				}
			});

			//������ �� ���� ���� �������� ����� ����� � ������ ����.
			vvod2.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume(); 
					}
				}
			});

			//������������ ������� ��� ������� �� ������.
			knopka.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//��������� ������� �� ������� � ����� ����������.
					Credit_Calculator_4_CalcForm1();
				}
			});
		}

		//��������� ����� �� ����� � ������������� ������� � ��������� ����������.
		double sum(JTextField vvod,JTextField vvod1, JTextField vvod2){
			int sk = Integer.parseInt(vvod.getText());
			int kp = Integer.parseInt(vvod1.getText());
			int ps = Integer.parseInt(vvod2.getText());
			double np = 0;
			double od = sk / (double)kp;
			for(int i = 0; i < kp; i++){
				np += ((double)sk - i * od) * ps / 1200;
			}
			return sk + np;
		}
		//������� �� ������� � �����.
		public void Credit_Calculator_4_CalcForm1() {
			double n;
			n =sum(vvod,vvod1,vvod2);
			vuvod.setText(Double.toString(n));
		}
		public static void main(String[] args) 
		{

			//��������� ���� �����������.
			SwingUtilities.invokeLater(new Runnable() 
			{

				public void run() 
				{

				new Credit_Calc_4_main_AuthorizationForm();
			}
		});
	}
	}
