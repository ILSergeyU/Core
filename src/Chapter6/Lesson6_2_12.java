package Chapter6;

public class Lesson6_2_12 {
}

/*Выберите правильный ответ
Как должны быть связаны между собой реализации equals() и hashCode() у класса, чтобы экземпляры этого класса можно было спокойно хранить в HashSet?
a.equals(b) тогда и только тогда, когда a.hashCode() == b.hashCode()
>>>если a.equals(b), то a.hashCode() == b.hashCode()
если a.hashCode() == b.hashCode(), то a.equals(b)
если !a.equals(b), то a.hashCode() != b.hashCode()*/