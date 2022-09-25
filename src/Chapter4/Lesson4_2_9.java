package Chapter4;
//>>> JM принял. Нужна проверка в методе main!
public class Lesson4_2_9 {
    public static void main(String[] args) {

    }

//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        for (int i = 0; i < 3; i++) {
//            try (RobotConnection rc = robotConnectionManager.getConnection()) {
//                rc.moveRobotTo(toX, toY);
//                i = 3;
//            } catch (RobotConnectionException e) {
//                if (i == 2) {
//                    throw e;
//                }
//            }
//        }
//    }
//----------------------------------------------------------------------------------
//   замечания ментора: Бросаешь не новое исключение, а ранее пойманное
//    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        // your implementation here
//        boolean success = false;
//
//        for (int i = 0; !success && i < 3; i++) {
//            try (RobotConnection connection = robotConnectionManager.getConnection()) {
//                connection.moveRobotTo(toX, toY);
//                success = true;
//            } catch (RobotConnectionException ignored) {
//            }
//        }
//
//        if (!success) {
//            throw new RobotConnectionException("Timeout: 3 attempts are failed.");
//        }
//    }
}


//https://www.youtube.com/watch?v=aHO60SmsfJA

//Если совсем плохо, как было у меня, то вот полезный материал
//https://www.youtube.com/watch?v=2_ThvTc3X8Y
//Смотреть с 36:28



/*Урок с кодом
Реши предыдущую задачу с использованием try-with-resources*/