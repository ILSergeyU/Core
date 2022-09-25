package Chapter3;
//https://github.com/Maslak-Andrey/Stepik-Robot-3.3/blob/master/src/Robot.java   ПРОВЕРКА РОБОТА!!!!!!!!!!!
//import com.sun.javafx.scene.traversal.Direction;

public class Lesson3_3_13 {
    public static void main(String[] args) {

        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 3, 0);
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction dirX = (robot.getX() < toX ? Direction.RIGHT : Direction.LEFT);
        Direction dirY = (robot.getY() < toY ? Direction.UP : Direction.DOWN);

        if (robot.getX() != toX) {
            while (robot.getDirection() != dirX) {
                robot.turnRight();
            }
            while (robot.getX() != toX) {
                robot.stepForward();
            }
        }

        if (robot.getY() != toY) {
            while (robot.getDirection() != dirY) {
                robot.turnLeft();
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        private int x;
        private int y;
        private Direction direction;

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public Direction getDirection() {
            // текущее направление взгляда
            return direction;
        }

        public int getX() {
            // текущая координата X
            return x;
        }

        public int getY() {
            // текущая координата Y
            return y;
        }

        public void turnLeft() {
            // повернуться на 90 градусов против часовой стрелки
            switch (direction) {
                case DOWN:
                    System.out.println("turning left down -> right");
                    direction = Direction.RIGHT;
                    break;
                case LEFT:
                    System.out.println("turning left left -> down");
                    direction = Direction.DOWN;
                    break;
                case RIGHT:
                    System.out.println("turning left right -> up");
                    direction = Direction.UP;
                    break;
                case UP:
                    System.out.println("turning left up ->left");
                    direction = Direction.LEFT;
                    break;
//                default:
//                    break;
            }
        }

        public void turnRight() {
            // повернуться на 90 градусов по часовой стрелке
            switch (direction) {
                case DOWN:
                    System.out.println("turning right down -> left");
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    System.out.println("turning right left -> up");
                    direction = Direction.UP;
                    break;
                case RIGHT:
                    System.out.println("turning right right -> down");
                    direction = Direction.DOWN;
                    break;
                case UP:
                    System.out.println("turning right up -> right");
                    direction = Direction.RIGHT;
                    break;
//                default:
//                    break;
            }
        }

        public void stepForward() {
            // шаг в направлении взгляда
            // за один шаг робот изменяет одну свою координату на единицу
            switch (direction) {
                case DOWN:
                    --y;
                    System.out.println("moving down");
                    break;
                case LEFT:
                    --x;
                    System.out.println("moving left");
                    break;
                case RIGHT:
                    ++x;
                    System.out.println("moving right");
                    break;
                case UP:
                    System.out.println("moving up");
                    ++y;
                    break;
//                default:
//                    break;
            }
        }
    }
}
//--------------------------------------------------------------------------------------------

/*Урок с кодом
На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами:
X и Y. Ось X смотрит слева направо, ось Y - снизу вверх. (Помните, как рисовали графики функций в школе?)

В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит:
вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.

Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):

public class Robot {

    public Direction getDirection() {
        // текущее направление взгляда
    }

    public int getX() {
        // текущая координата X
    }

    public int getY() {
        // текущая координата Y
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }
}
Direction, направление взгляда робота, - это перечисление:

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}
Как это выглядит:



Пример
В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0,
robot.getDirection() == Direction.UP

Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:

robot.turnRight();
robot.stepForward();
robot.stepForward();
robot.stepForward();
Требования:
1. должен быть метод public static void moveRobot(Robot robot, int toX, int toY)
2. метод moveRobot должен переместить робота в позицию int toX, int toY*/




