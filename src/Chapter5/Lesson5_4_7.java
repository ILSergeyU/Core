package Chapter5;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;


public class Lesson5_4_7 {

    public static void main(String[] args) throws IOException {
        //создание экземпляра класса с объектами dog, cow, cat, rabbit
        Animal[] animals = new Animal[]{new Animal("dog"), new Animal("cow"), new Animal("cat"), new Animal("rabbit")};
        //открываем поток вывода данных
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        //записываем в поток количество объектов в классе
        oos.writeInt(4);

        //Записываем объекты в поток вывода
        for (Animal animal1 : animals) {
            oos.writeObject(animal1);
        }
        //закрываем поток
        oos.close();

        //восстанавливаем из потока объекты класса
        byte[] bArray = os.toByteArray();
        Animal[] animal2 = deserializeAnimalArray(bArray);
        System.out.println(Arrays.toString(animal2));//печатаем в консоль
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] animal = null;
        try (/*ByteArrayInputStream out = new ByteArrayInputStream(data);
             ObjectInputStream ani = new ObjectInputStream(out)*/
                ObjectInputStream ani = new ObjectInputStream(new ByteArrayInputStream(data))) {

            animal = new Animal[ani.readInt()];

            for (int i = 0; i < animal.length; i++) {
                animal[i] = (Animal) ani.readObject();
            }
            // ani.close();
            return animal;

        } catch (IOException | ClassNotFoundException | RuntimeException e) {
            throw new IllegalArgumentException(e);
        }
    }

// то что было. Замечания от ментора (use try with res реши без интовой
// переменной лови все исключения убрать java.lang.)

//    public static Animal[] deserializeAnimalArray(byte[] data) {
//        int countOfAnimals = 0;
//        Animal[] animals = new Animal[0];
//
//        ByteArrayInputStream dataInputStream = new ByteArrayInputStream(data);
//        try {
//            ObjectInputStream ois = new ObjectInputStream(dataInputStream);
//
//            countOfAnimals = ois.readInt();
//            animals = new Animal[countOfAnimals];
//
//            for (int i = 0; i < countOfAnimals; i++) {
//                Animal a = (Animal) ois.readObject();
//                animals[i] = a;
//            }
//
//        } catch (Exception e) {
//            throw new java.lang.IllegalArgumentException();
//        }
//
//        return animals;
//    }

}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}


/*Урок с кодом
Дан сериализуемый класс Animal:

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
 Массив байт устроен следующим образом. Сначала идет число типа int, записанное при помощи
 ObjectOutputStream.writeInt(size). Далее подряд записано указанное количество объектов
 типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
то метод должен бросить исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные. Попробуйте подать на вход методу разные
некорректные данные и посмотрите, какие исключения будут возникать. Вот их-то и
нужно превратить в IllegalArgumentException и выбросить. Если что-то забудете,
то проверяющая система подскажет. Главное не глотать никаких исключений, т.е.
не оставлять нигде пустой catch.

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: Animal[] deserializeAnimalArray(byte[] data)*/