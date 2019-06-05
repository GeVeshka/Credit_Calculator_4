	//Файл содержит в себе код кредитного калькулятора.
	package calculator;
	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.util.Scanner;

	//Класс рабочего окна калькулятора.
	public class Credit_Calculator_4_CalcForm extends JFrame
	{

		//Создание элементов для окна калькулятора.
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
			//Задание расположения окна, его размеров и названия.
			setTitle("Кредитный калькулятор");
			setLocation(400,400);
			setSize(700,200);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			//Добавление контейнера для размещения полей и кнопок.
			Container con = getContentPane();
			con.setLayout(new FlowLayout());

			//Создание первого поля для ввода(начальной суммы).
			vvod = new JTextField(45);
			con.add(vvod);
			String word = (vvod.getText());

			//Создание пояснительного текста для первого поля ввода.
			vuvod1 = new JLabel("Начальная сумма");
			con.add(vuvod1);

			//Создание второго поля для ввода(количество месяцев).
			vvod1 = new JTextField(45);
			con.add(vvod1);
			String word1 = (vvod1.getText());

			//Создание пояснительного текста для второго поля ввода.
			vuvod2 = new JLabel("Количество месяцев");
			con.add(vuvod2);

			//Создание третьего поля для ввода(процентная ставка).
			vvod2 = new JTextField(50);
			con.add(vvod2);
			String word2 = (vvod2.getText());

			//Создание пояснительного текста для третьего поля ввода.
			vuvod3 = new JLabel("Процентная ставка");
			con.add(vuvod3);

			//Создание кнопки для рассчета кредита.
			knopka = new JButton("Рассчитать");
			knopka.setActionCommand("123");
			con.add(knopka);
	
			//Создание поля вывода результата.
			vuvod = new JLabel();
			con.add(vuvod);

			//Запрет на ввод всех символов кроме чисел в первое поле.
			vvod.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume(); 
					}
				}
			});

			//Запрет на ввод всех символов кроме чисел во второе поле.
			vvod1.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume(); 
					}
				}
			});

			//Запрет на ввод всех символов кроме чисел в третье поле.
			vvod2.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
						e.consume(); 
					}
				}
			});

			//Обрабатываем событие при нажатии на кнопку.
			knopka.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//Вызвываем подсчет по формуле и вывод результата.
					Credit_Calculator_4_CalcForm1();
				}
			});
		}

		//Считываем числа из полей в целочисленном формате и выполняем вычисления.
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
		//Подсчет по формуле и вывод.
		public void Credit_Calculator_4_CalcForm1() {
			double n;
			n =sum(vvod,vvod1,vvod2);
			vuvod.setText(Double.toString(n));
		}
		public static void main(String[] args) 
		{

			//Запускаем окно авторизации.
			SwingUtilities.invokeLater(new Runnable() 
			{

				public void run() 
				{

				new Credit_Calc_4_main_AuthorizationForm();
			}
		});
	}
	}
