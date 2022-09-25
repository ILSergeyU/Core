package Chapter6;

public class Lesson6_1_9 {
}
/*Выберите правильный ответ
Предположим, у нас есть параметризованный класс с методом someMethod:


public class Example<X>{
    public void someMethod(Object obj) {
        //....
    }
}
Какие операции разрешены внутри метода? ("Разрешены" = "Компилятор скомпилирует")

Создание массива X
Проверка (obj instanceof X)
>>>Приведение obj к типу X
Создание экземпляра X
>>>Получение экземпляра Optional<x> через Optional.empty()
Проверка (obj instanceof Optional<x>)*/