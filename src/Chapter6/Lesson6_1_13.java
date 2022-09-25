package Chapter6;

import java.util.Arrays;

//https://www.delftstack.com/ru/howto/java/java-dynamic-array/
//https://www.youtube.com/watch?v=ZYzmt4LLvD0
public class Lesson6_1_13 {

    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();
        arr.add(1534);
        arr.add(2234);
        arr.add(3542);
        arr.add(45);
        arr.add(512);
        arr.add(246);
        arr.add(687);
        arr.add(8345);
        arr.add(2349);
        arr.add(1140);
        arr.add(2311);
        arr.add(132132);
        arr.add(153);
        arr.add(14);

        System.out.println("Размер массива " + arr.size);
        System.out.println("Третий элемент массива " + arr.get(3));
        arr.remove(3);
        System.out.println("Размер массива после удаления одного элемента " + arr.size);
        System.out.println("Третий элемент массива после удаления " + arr.get(3));

    }

/*    public static class DynamicArray<T> {

        private static final int DEFAULT_CAPACITY = 10;
        private T[] elements;
        private int size;

        public DynamicArray() {
            this.elements = (T[]) new Object[DEFAULT_CAPACITY];
            this.size = 0;
        }

        public void add(T el) {
            int newSize = elements.length + elements.length / 2;
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, newSize);
            }
            this.elements[size++] = el;
        }

        public T get(int index) {
            if (index >= 0 && index < size) {
                return elements[index];
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
            //  return null;
        }

        public void remove(int index) {
            int newSize = size - 1;
            if (newSize > index) {
                System.arraycopy(elements, index + 1, elements, index, newSize - index);
            }
            elements[size = newSize] = null;
        }
    }*/


    public static class DynamicArray<T> {
        private T[] array = (T[]) new Object[10];
        public int size = 0;

        public <T> DynamicArray() {
        }

        public T get(int index) throws ArrayIndexOutOfBoundsException {
            if (index >= 0 && index < size) {
                return (T) array[index];
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        public void add(T el) {
            if (size < array.length) {
                this.array[size] = el;
                size++;
            } else if (size == array.length) {
                T[] oldArray = this.array;
                this.array = (T[]) new Object[oldArray.length << 1];
                System.arraycopy(oldArray, 0, array, 0, oldArray.length);
                this.array[size] = el;
                size++;
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        public void remove(int index) {
            if (array.length > 0) {
                System.arraycopy(array, index + 1, array, index, array.length - index - 1);
                size--;
            }
        }
    }

}

/*Урок с кодом
Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray,
который хранит в себе массив, и имеет методы для добавления void add(T el), void remove(int index)
удаления и извлечения T get(int index) из него элементов, при переполнении текущего массива, должен
создаваться новый, большего размера.

Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи
 можно воспользоваться методами из класса java.util.Arrays. Импорт этого класса уже объявлен в
 тестирующей системе. Добавлять его явно не нужно

Требования:
1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. класс DynamicArray должен  иметь публичный конструктор по умолчанию
3. работа методов должна соответствовать условию*/
