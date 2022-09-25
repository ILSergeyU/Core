package Chapter5;

public class Lesson5_2_5 {
}
/*Выберите правильный ответ
Предположим, у нас есть экземпляр Path, содержащий путь к файлу на реальной или виртуальной файловой системе.
Как правильно получить InputStream для чтения содержимого этого файла?

new FileInputStream(path.toFile())
Paths.newInputStream(path)
>>>Files.newInputStream(path)
new FileInputStream(path)*/