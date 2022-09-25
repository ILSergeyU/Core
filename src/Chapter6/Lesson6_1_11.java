package Chapter6;

//https://github.com/netology-code/jd-homeworks/blob/master/generics/task1/README.md
//https://www.youtube.com/watch?v=ZUYxY-UJ3aI
public class Lesson6_1_11 {

    public static void main(String a[]) {
        // параметризируем класс типом String
        Box<String> sample1 = new Box<>("Нетология");
        System.out.println(sample1);
        // параметризируем класс типом Integer
        Box<Integer> sample2 = new Box<>(1);
        System.out.println(sample2);
        // параметризируем класс типом Boolean
        Box<Boolean> sample3 = new Box<>(Boolean.TRUE);
        System.out.println(sample3);
    }


    public static class Box<T> {
        //твой код здесь
        private T object;

        public Box(T object) {
            this.object = object;
        }

        public Box() {
        }

//        public void setObject(T object) {
//            this.object = object;
//        }

//        public T getBox() {
//            return this.object;
//        }

        public static <T> Box<T> getBox() {
            return new Box<T>();
        }

//        @Override
//        public String toString() {
//            return "Box{" +
//                    "object=" + object +
//                    "; objType=" + object.getClass().getName() +
//                    '}';
//        }
    }
}
//>>>Ответ для JM

//public static class Box<T> {
//    //твой код здесь
//    private T object;
//
//    public static <T> Box<T> getBox() {
//        return new Box<T>();                 ----------- убрал: return new Box<>();-----------
//    }
//}

//>>>

/*Урок с кодом
В классе Box из прошлой задачи нужно добавить статический метод getBox(),
который возвращает пустой параметризованный объект типа Box,

Требования:
1. Класс должен быть параметризован T.
2. Поле должно быть приватным с именем object.
3. Класс должен иметь публичный модификатор доступа.
4. Класс должен иметь публичный статический метод getBox().
5. метод getBox() должен работать согласно условию..
6. Класс Box должен быть статическим.*/
