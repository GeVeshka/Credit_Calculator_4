package tests;

/* Подключение библиотеки JUnit, позволяющая создавать тесты для программ */
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import calculator.Credit_Calculator_4_CalcForm;

/* Создание класса, содержащего код теста */
public class Credit_Calculator_4_CalcForm_Test2 {
    
	/* Аннотация @Test указывает JUnit, что в методе находится код теста */
    @Test
    public void testCalculator(){
		/* Обработка исключения на случай возникновения ошибок в процессе выполнения теста */
			/* Создание объекта класса, содержащего программу */
    	Credit_Calculator_4_CalcForm lc = new Credit_Calculator_4_CalcForm();
			/* Заполнение поля ввода программы определенной последовательностью символов */
            lc.vvod.setText("12");
            lc.vvod1.setText("12");
            lc.vvod2.setText("10");
			/* Запуск программы */
            lc.Credit_Calculator_4_CalcForm1();
			/* Сравнение результата, выдаваемого программой, с ожидаемым значением */
            Assert.assertTrue("12.65".equals(lc.vuvod.getText()));
		/* Код, выполняемый при возникновении ошибок в процессе выполнения теста */
    }
}