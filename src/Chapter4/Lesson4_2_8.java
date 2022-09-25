package Chapter4;

//>>> JM принял. Нужна проверка в методе main!
//https://github.com/EUxGB?tab=repositories
public class Lesson4_2_8 {
    public static void main(String[] args) {

    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    //--------------------------------------------------------------------------------------
//Последние от Сергея вроде-бы как без замечаний.
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection connection = null;
        for (int i = 0; i < 3; i++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                }
            }
        }
        throw new RobotConnectionException(">3");
    }
}

/*
* public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
	RobotConnection rc = null;
	for (int i = 0; i < 3; i++) {
		try {
			rc = robotConnectionManager.getConnection();
			rc.moveRobotTo(toX, toY);
			break;
		} catch (RobotConnectionException e) {
			if (i == 2) {
				throw new RobotConnectionException ("Все три попытки соединения были неудачны!");
        	}
		} finally {
			try {
				if (rc != null) {
					rc.close();
				}
			} catch (Exception e) {
			}
		}
	}
}
И так, первая строка
public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
Создаем публичный статический метод, который называется moveRobot, ни чего не возвращает. В параметры принимает объект
* типа RobotConnectionManager, переменную х и переменную у.
Тут хочется отметить объект типа RobotConnectionManager. По условию RobotConnectionManager это интерфейс, а мы знаем,
*  что нельзя создать объект интерфейса. Я долго не понимал что это запись обозначает. Оказалось, что это так называемое
* "слабое связывание". Почему то на эту тему мало информации. Понимать эту запись следует так: мы создаем объект класса,
* который реализует этот интерфейс. То есть, получается, что robotConnectionManager - объект какого-то класса, который
* имплиментит (реализует) интерфейс RobotConnectionManager. Нас не интересует, что это за класс, потому что нам к этому
* объекту требуется применить только один метод, который есть в этом интерфейсе. Как то так.
public static указывается в начале, чтобы валидатор смог интегрировать этот весь код, который мы пишем, в свой код проверки.
toX, toY - конечные координаты, куда робот должен прийти.
Строка 2:RobotConnection rc = null;
Создаем объект типа RobotConnection с названием rc и сразу инициализируем его как null. Тоже самое слабое связывание.
* Создаем объект какого-то класса, который реализует интерфейс RobotConnection. По условию задачи этот интерфейс - это
* абстрактное представление соединения с роботом. То есть, написание этой строки можно представить как будто мы взяли
* бумажку, далее нажали на "пульте управления" "кнопку ВКЛ", тем самым, если все хорошо - включили робота, если что то
* пошло не так - не включили, и далее результат записали на эту бумажку. Если честно, я уже не помню, почему мы его
* (объект) сразу проинициализировали как null. Точно помню, что если этого не сделать, идея ругалась. Да и если в 5
* строке вылетит исключение, rc у нас останется = null, то есть закрывать такой ресурс не нужно будет, а в блоке finally
*  нам нужно закрыть его. Как следствие этот null нам пригодиться как минимум для проверки есть у нас что закрывать или нет.
Строка 3:for (int i = 0; i < 3; i++) {
По условию сказано, что у программы должно быть максимум три попытки для того чтобы создать соединение с роботом
* ("включить нашего робота"). Тут думаю все понятно.
Строка 4:try {
Открываем блок try, потому что дальше начнется код, который может выкинуть исключения, которые нам требуется отловить.
Строка 5:rc = robotConnectionManager.getConnection();
Начинается магия. Эту строчку можно абстрактно представить, так: взяли нашу бумажку, уже реально нажали на кнопку
* включения робота и записали на бумажку результат(робот включился/не включился). Метод getConnection() вызванный у
* объекта robotConnectionManager как раз устанавливает соединение. Стоит отметить, что если "робот не включился", то
* у нас сразу вылетит исключение RobotConnectionException и выполнение программы перейдет в блок catch, а все что было
*  написано в 6 и 7 строке - не выполнится. Если все нормально и "робот включился" переходим к 6 строке.
Строка 6:rc.moveRobotTo(toX, toY);
Тут все просто. У нас есть соединение с роботом (он включился) и мы "задаем координаты"(это если в абстракции, в
* реальности эти координаты задавать не нужно, они передаются в первой строке, в параметры метода), куда робот должен
* переместиться и отправляем ему их. По аналогии с предыдущей строкой, если координаты дошли до робота, он перемещается
* в них, если не дошли - вылетает исключение и ход программы переходит в блок catch.
Строка 7:break;
До этой строки программа дойдет только в том случае, если все было хорошо и не было ни каких исключений. А значит все
* условия по манипуляциям с роботом выполнены и дополнительные попытки соединения с роботом не нужны. Что бы дополнительных
* попыток больше не было, нам нужно выйти из блока for. break это и делает. Завершает итерацию и выходит из блока.
Строка 8:} catch (RobotConnectionException e) {
У нас закончилась часть кода, где могли быть выброшены исключения. А это значит, что пора заняться блоком catch. По
* условию задачи, методы getConnection() и moveRobotTo() могут выкинуть исключение RobotConnectionException. Значит в
* catch его и будем отлавливать. Что в этой строке и происходит. Про себя можно эту строку проговорить, как: Если ранее
* где то вылетело исключение RobotConnectionException, программа перейдет в этот блок.
Строка 9:if (i == 2) {
Теперь нужно осознать одну вещь. Если у нас ранее вылетело исключение RobotConnectionException, то это была неудачная
* попытка. А неудачных попыток у нас может быть не больше трех. Если это была, последняя, третья попытка, и она стала
* неудачной, то программа заходит в этот блок if. Потому что у первой попытке i=0, у второй i=1, у третьей i=2. Но если
* это была первая или вторая попытка, то по условию задачи в такой ситуации исключение RobotConnectionException должно
* игнорироваться. То есть, если i не равно 2, то программа идет мимо этого блока if, и так как в блоке catch после if ни
* чего нет, то программа переходит к блоку finally.
Строка 10:throw new RobotConnectionException ("Все три попытки соединения были неудачны!");
По условию задачи "после третьей неудачи метод должен бросить исключение RobotConnectionException." Именно это и
* происходит. Фраза в круглых скобках может быть любая. Это то, что высветится на экране, когда эта строчка кода отработает.
Строка 12:} finally {
Начинается блок finally. Блок который выполнится в любом случае, было ли выброшено какое то исключение или нет.
Строка 13:try {
Далее последует код, в котором могут быть выброшены исключения, которые нам нужно отловить и проигнорировать. Так как
* мы планируем использовать метод close() для закрытия нашего соединения, он(этот метод) может выбрасывать исключения
* типа Exception. И если это произойдет, предыдущее исключение (если оно было) станет утерянным и информацию о нем мы
* не получим. А то исключение (если оно было) важнее того, которое может выкинуть метод close().
Строка 14:if (rc != null) {
Ну вот и пришло время той проверки, о которой говорилось в строке 2. Если нам так и не удалось открыть соединение (все
* три попытки были провальные), то объект rc до сих пор будет = null, а значит и закрывать нам нечего. Собственно это
* тут и проверяется. Если rc не равна null то программа зайдет в блок if...
Строка 15:rc.close();
... и закроет наше соединение.
Строка 17:} catch (Exception e) {
Если метод close() выбросил какое то исключение типа Exception, то программа перейдет в этот блок catch, где по условию
*  задачи, оно должно быть проигнорировано, а значит блок catch должен быть пустым.
* */


/*Урок с кодом
Вспомним нашего старого знакомого робота. Теперь мы будем давать роботу команды удаленно,
подключаясь к нему по беспроводному каналу связи.

Подключение к роботу представляется в программе интерфейсом RobotConnection:

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();
}
Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную точку
(метод moveRobotTo). Ему больше не нужны пошаговые инструкции.

RobotConnection - это временно устанавливаемое соединение, которое надо закрывать,
когда оно больше не нужно. Для закрытия соединения в интерфейсе есть метод close().

За установку соединения отвечает RobotConnectionManager:

public interface RobotConnectionManager {
    RobotConnection getConnection();
}
Метод getConnection() делает попытку соединиться с роботом и возвращает установленное
соединение, через которое можно отдавать роботу команды.

Установка соединения может завершиться неуспешно, а также уже установленное соединение
может внезапно разорваться. Всякое бывает. Поэтому любой метод RobotConnectionManager и
RobotConnection может бросить непроверяемое исключение RobotConnectionException:

public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
Ваша задача - реализовать метод который устанавливает соединение с роботом, отдает ему
команду на перемещение в заданную точку и затем закрывает соединение, выполняя при
необходимости повтор этой последовательности до трех раз.

При этом:

Попытка отдать команду роботу считается успешной, если удалось установить соединение
и выполнить метод RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения
не важна и должна игнорироваться.

Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем
соединение и выполняем вторую попытку. Если вторая тоже не удалась, то выполняется третья.
 После третьей неудачи метод должен бросить исключение RobotConnectionException.

Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить,
то оно обязательно должно быть закрыто несмотря на возможные исключения, случившиеся
в дальнейшем во время работы метода.

Если во время работы метода случилось исключение любого типа, отличного от
RobotConnectionException, метод должен завершиться и выбросить это исключение,
не выполняя повторных попыток пообщаться с роботом. Единственное, что метод должен
сделать перед выбросом этого исключения — закрыть открытое соединение RobotConnection.

В решение должен использоваться классический try-catch.*/

//-------------------------------------------------------------------
//    ментор принял: но есть замечание try catch вложи в проверку на налл break замени на int переменную
//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        RobotConnection connection = null;
//        for (int i = 0; i < 3; i++) {
//            try {
//                connection = robotConnectionManager.getConnection();
//                connection.moveRobotTo(toX, toY);
//                break;
//            } catch (RobotConnectionException e) {
//                if (i == 2) {
//                    throw e;
//                }
//            } finally {
//                if (connection != null) {
//
//                }
//                try {
//                    connection.close();
//                } catch (Throwable e) {
//                }
//            }
//        }
//    }
//-----------------------------------------------------------------------------
//   замечания ментора: При закрытии проверка.!!!!!!!!!!!!
//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        RobotConnection robotConnection;
//
//        for (int i = 0; i < 3; i++) {
//
//            try {
//                robotConnection = robotConnectionManager.getConnection();
//            } catch (RobotConnectionException e) {
//                continue;
//            }
//
//            try {
//                robotConnection.moveRobotTo(toX, toY);
//                return;
//            } catch (RobotConnectionException e) {
//            } finally {
//                try {
//                    robotConnection.close();
//                } catch (RobotConnectionException e) {
//                }
//            }
//
//        }
//
//        throw new RobotConnectionException("help me!");
//    }
//-----------------------------------------------------------
//       Сообщение от ментора пробрасывай исключение в catch Блоке реши
//       через цикл for return Замени на Int переменную
//public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//    int count = 0;
//    while (true) {
//        count++;
//        if (count > 3) {
//            throw new RobotConnectionException("Failed to establish a connection");
//        }
//        RobotConnection rc = null;
//        try {
//            rc = robotConnectionManager.getConnection();
//            rc.moveRobotTo(toX, toY);
//            return;
//        } catch (RobotConnectionException ignored) {
//        } finally {
//            if (rc != null) {
//                try {
//                    rc.close();
//                } catch (Exception ignored) {
//                }
//            }
//        }
//    }
//}
