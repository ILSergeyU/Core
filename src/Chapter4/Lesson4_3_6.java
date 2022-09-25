package Chapter4;

import java.util.logging.Level;
import java.util.logging.Logger;

//>>> JM принял. Нужна проверка в методе main!
public class Lesson4_3_6 {

    public static void logging() {
        //Твой код здесь
        final Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.log(Level.INFO, "Все хорошо");
        logger.log(Level.WARNING, "Произошла ошибка");
    }
}


/*Урок с кодом
Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test,
 залогируйте им два сообщения: первое "Все хорошо" с уровнем INFO и второе
 "Произошла ошибка" с уровнем WARNING.

java.util.logging.* импортирован за вас*/

//Сразу решил благодаря видео https://www.youtube.com/watch?v=e1Balqbin84