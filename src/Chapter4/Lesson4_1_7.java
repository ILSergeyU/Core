package Chapter4;

//>>> JM принял. Нужна проверка в методе main!
public class Lesson4_1_7 {

    public static void main(String[] args) {
//        try {
//            testExp();  // Нужен static в методе
//        } catch (MyNewException ex) {
//            System.out.println(ex.getStackTrace());
//        }
    }

    static class MyNewException extends Exception {
    }

    public /*static*/ void testExp() throws MyNewException {
        throw new MyNewException();
    }
}



/*Урок с кодом
Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(),
который выбрасывает MyNewException при вызове.

Требования:
1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
2. Класс исключения должен иметь модификатор доступа по умолчанию.
3. Метод testExp() расположите вне класса исключения.

*/




