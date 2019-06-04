package calculator;
//Файл содержит в себе авторизацию, запуск программы.

import javax.swing.*;
import java.io.*;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

//Класс окна авторизации.
public class Credit_Calc_4_main_AuthorizationForm extends JFrame {

	//Создание элементов для окна авторизации.
	private JButton button1 = new JButton("Войти");
	private JTextField input1 = new JTextField("", 5);
	private JTextField input2 = new JTextField("", 5);
	private JLabel label = new JLabel("Логин");
	private JLabel label2 = new JLabel("Пароль");
	private Credit_Calculator_4_CalcForm Credit_Calculator_4_CalcForm;
 
	//Конструктор главного окна.
	public Credit_Calc_4_main_AuthorizationForm() {

		//название окна.
		super("Вход");

		//Установка параметров окна.
		this.setBounds(100, 100, 400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Добавление контейнера для размещения панелей и кнопок.
		Container container = this.getContentPane();

		//Установка параметров расположения внутри контейнера.
		container.setLayout(new GridLayout(3, 2, 2, 2));

		//Добавление полей, текста, кнопок в контейнер, очередность имеет значение.
		container.add(label);
		container.add(label2);
		container.add(input1);
		container.add(input2);
		container.add(button1);

		//Создаем основное окно калькулятора из другого класса.
		Credit_Calculator_4_CalcForm = new Credit_Calculator_4_CalcForm();

		//Обрабатываем событие при нажатии на кнопку.
		button1.addActionListener(new ActionListener() {
			int loginAdmin, passwordAdmin, loginUser, passwordUser;
			int[] array = null;

			@Override
			//Авторизация + открытие основного окна калькулятора.
			public void actionPerformed(ActionEvent arg0) {

				//Читаем текстовый файл "SQL.txt".
				try (BufferedReader in = new BufferedReader(new FileReader("SQL.txt")))
				{

					//Заполняем массив значениями из него.
					array = in.lines().mapToInt(Integer::parseInt).toArray();
				}

				//Обрабатываем ошибку формата.
				catch (IOException | NumberFormatException e)
				{

					e.printStackTrace();
				}

				/*Сравниваем длину массива с количеством необходимых паролей и логинов,
				* длина должна быть равна количеству пользователей, умноженному на два. */
				if (4 == array.length)
				{

					//Передаем переменным для входа значения из массива.
					loginAdmin=array[0]; //Логин первого пользователя.
					passwordAdmin=array[1]; //Пароль первого пользователя.
					loginUser=array[2]; //Логин второго пользователя.
					passwordUser=array[3]; //Пароль второго пользователя.
				}

				//В случае, если условие не выполняется, то файл заполняется начальными логинами и паролями.
				else
				{

					//Запись в файл "SQL.txt".
					try(FileWriter writer = new FileWriter("SQL.txt", false))
					{

						//Базовые значения тут.
						loginAdmin = 1; //Начальный логин первого пользователя.
						passwordAdmin = 2; //Начальный пароль первого пользователя.
						loginUser = 3; //Начальный логин второго пользователя.
						passwordUser = 4; //Начальный пароль второго пользователя.
						//Запись в файл.
						writer.write(loginAdmin + "\r\n" + passwordAdmin + "\r\n" + loginUser + "\r\n"+ passwordUser);
					}

					//При ошибки выдает сообщение в консоль, используется для проверки.
					catch(IOException ex)
					{

						System.out.println(ex.getMessage());
					}
				}

				//Присваиваем значения из текстовых полей логина пользователя и пароля.
				int login1 = Integer.parseInt(input1.getText());
				int password1 = Integer.parseInt(input2.getText());
				//Сравниваем введенные данные с данными из файла.
				if ((login1 == loginAdmin && password1 == passwordAdmin) || (login1 == loginUser && password1 == passwordUser)) 
				{

					//Делаем видимым основное окно калькулятора.
					Credit_Calculator_4_CalcForm.setVisible(true);
					//Скрываем окно авторизации.
					setVisible(false);
				}

				//В случае несоответствия логина м пароля скрываем окно авторизации.
				else
				{

					//Скрываем окно авторизации.
					setVisible(false);
				}
			}
		});

		//Располагаем окно авторизации в центре экрана.
		setLocationRelativeTo(null);

		//Делаем его видимым.
		setVisible(true);

	}

	//Запускаем программу.

}