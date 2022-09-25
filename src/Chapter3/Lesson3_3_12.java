package Chapter3;

public class Lesson3_3_12 {

    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human((byte) 40, "Ivan",
                "Petrov", "Streetboll");
        Human human3 = new Human((byte) 34, "Petr", "Ivanov");

        System.out.println(human1 + "\n");
        System.out.println(human2 + "\n");
        System.out.println(human3);
    }

    public static class Human {
      //  private final String defaultValue = "Empty";

        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {

        }
        public Human(byte age2, String name2, String secondName2, String favoriteSport2) {
             this(age2, name2, secondName2);
//            this.age = age2;
//            this.name = name2;
//            this.secondName = secondName2;
            this.favoriteSport = favoriteSport2;

        }

        public Human(byte age3, String name3, String secondName3) {
            // this(age3, name3, secondName3, null);
            this.age = age3;
            this.name = name3;
            this.secondName = secondName3;
        }

        @Override
        public String toString() {
            return "Name: " + name +
                    "\nSecondName: " + secondName +
                    "\nAge: " + age +
                    "\nSport: " + favoriteSport;
        }
    }
}
/*Урок с кодом
Создайте класс Human с полями возраст (age), имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport).

Создайте 3 конструктора в классе Human, 1-ый - пустой, 2-ой, который конструирует Human’a от всех полей и третий,
который конструирует Human’a, от всех полей, кроме любимого вида спорта. Для успешного тестирования решения важно
 объявлять аргументы в конструкторах именно в том порядке, в котором они написаны в данном описании (возраст (age),
  имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport))

В методе main создайте 3 экземпляра человека используя 3 этих разных конструктора. поля класса должны иметь размерность,
 не превышающую необходимую. Класс должен быть объявлен статическим, метод main не должен находиться в классе, поля
 класса должны иметь доступ только внутри класса

Требования:
1. Должен быть метод public static void main(String[] args)
2. Должен быть public static class Human
3. У класс Human должны быть поля
4. Класс Human должен иметь 3 конструктора
5. В методе main нужно создать три объекта класса Human тремя способами*/
