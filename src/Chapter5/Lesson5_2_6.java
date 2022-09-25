package Chapter5;

public class Lesson5_2_6 {
}
/*Выберите правильный ответ
Есть следующий код:


FileInputStream fileInputStream = new FileInputStream(file);
try (DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
    // ...
}
Является ли проблемой то, что не вызван метод fileInputStream.close()? Почему?

Да, т.к. пока этот FileInputStream не закрыт, мы не можем открыть новый FileInputStream.
>>>Нет, т.к. DataInputStream в своем методе close() закроет InputStream, с которым работает.
Да, т.к. это приведет к утечке ресурсов.
Нет, т.к. FileInputStream не использует никаких системных ресурсов, которые надо освобождать.*/