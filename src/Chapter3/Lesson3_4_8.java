package Chapter3;

//https://github.com/qcha/JBook/blob/master/object/hashcode.md
public class Lesson3_4_8 {
    public static void main(String[] args) {
        ComplexNumber comNum = new ComplexNumber(1, 1);
        ComplexNumber comNum2 = new ComplexNumber(1, 1);
        System.out.println(comNum.equals(comNum2));
        System.out.println(comNum.hashCode());

    }

    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber that = (ComplexNumber) o;
            return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
        }

        public int hashCode() {
            int result = 31;

            long re = Double.doubleToLongBits(getRe());
            long im = Double.doubleToLongBits(getIm());
            result = result * 17 + (int) (re ^ (re >>> 32));
            result = result * 17 + (int) (im ^ (im >>> 32));

            return result;
        }
    }
}

/*Урок с кодом
Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals()
сравнивал экземпляры ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

Пример

ComplexNumber a = new ComplexNumber(1, 1);
ComplexNumber b = new ComplexNumber(1, 1);
// a.equals(b) must return true
// a.hashCode() must be equal to b.hashCode()
Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.

Подсказка 2. Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет сама
генерировать equals() и hashCode(). Если вы воспользовались помощью IDE, то разберитесь, что было
сгенерировано и почему оно выглядит именно так. Когда вас на собеседовании попросят на бумажке
реализовать equals() и hashCode() для какого-нибудь простого класса, то среда разработки помочь не сможет.

Требования:
1. Должен быть класс public static class ComplexNumber
2. Класс ComplexNumber должен иметь поля re и im типа double
3. Класс ComplexNumber должен переопределять public boolean equals(Object o) и public int hashCode()
4. equals и hashcode должны корректно работать*/