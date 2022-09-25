package Chapter3;

//https://github.com/EUxGB/3.5_Stepik_TextAnalyzer/tree/master/src    Хорошо решил!!!!
// не работает проверка!!!!!!!!!!!!!!!!!!!!!!!!! ++++the problem is solved++++
public class Lesson3_5_8 {

    public static void main(String[] args) {

        String[] keywords_spam = new String[]{"купите", "реклама", "цена", "цене"};

        int maxLength = 100;

        String[] test_txt = new String[]{
                "Катерина не успела на автобус и заматерилась =) . 8) :( купите наши услуги",
                "Прохожий обернулся, и многозначительно взглянув на нее произнес. Мадам, а Вы не =) против.. !!! ",
                "Мне не понравился этот текст поэтому :((((((( не смотря на то, что цен привлекательная",
                "Реклама по доступной цене :)",
                "Прохожий обернулся, и многозначительно взглянув на нее произнес. Мадам, а Вы не =) против.. !!! sssssssssssssssssssssssssssssssssss",
        };
        TextAnalyzer[] analyzers = new TextAnalyzer[]{
                new SpamAnalyzer(keywords_spam),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(maxLength)
        };

        CheckLabels txt_check = new CheckLabels();
        for (String txt : test_txt) {
            System.out.println(txt_check.checkLabels(analyzers, txt) + "\n " + txt + "\n");
        }
    }
    // тесты 2

/*    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers4 = {
                new TooLongTextAnalyzer(commentMaxLength),
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords)
        };
        TextAnalyzer[] textAnalyzers5 = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength)
        };
        TextAnalyzer[] textAnalyzers6 = {
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords)
        };
        // тестовые комментарии
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3,
                textAnalyzers4, textAnalyzers5, textAnalyzers6};
        Main testObject = new Main();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}
        int numberOfTest = 0; // номер теста, который соответствует индексу тестовых комментариев
        for (String test : tests) {
            numberOfAnalyzer = 1;
            System.out.print("test #" + numberOfTest + ": ");
            System.out.println(test);
            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, test));
                numberOfAnalyzer++;
            }
            numberOfTest++;
        }
    }*/
}


interface TextAnalyzer {
    Label processText(String text);
}

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

class CheckLabels {
    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer obj_txt_an : analyzers) {
            Label label_check = obj_txt_an.processText(text);
            if (label_check != Label.OK) {
                return label_check;
            }
        }
        return Label.OK;
    }
}

abstract class KeywordAnalyzer implements TextAnalyzer {
    protected abstract String[] getKeywords();

    protected abstract Label getLabel();

    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}

class SpamAnalyzer extends KeywordAnalyzer/* implements TextAnalyzer */ {
    private String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
//    public Label processText(String text) {
//        String[] keywords = getKeywords();
//        for (String keyword : keywords) {
//            if (text.contains(keyword)) {
//                return getLabel();
//            }
//        }
//        return Label.OK;
//    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer /*implements TextAnalyzer*/ {
    private final String[] keywords = {":(", "=(", ":|"};

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
//    public Label processText(String text) {
//        String[] keywords = getKeywords();
//        for (String keyword : keywords) {
//            if (text.contains(keyword)) {
//                return getLabel();
//            }
//        }
//        return Label.OK;
//    }
}

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int threshold) {
        this.maxLength = threshold;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        } else {
            return Label.OK;
        }
    }
}


/*Урок с кодом
Пришло время попробовать реализовать иерархию классов определенного вида и решить конкретную задачу.
Представим, вы делаете систему фильтрации комментариев на каком-то веб-портале, будь то новости,
видео-хостинг, а может даже для системы онлайн-обучения :). Вы хотите фильтровать комментарии по
разным критериям, уметь легко добавлять новые фильтры и модифицировать старые. Допустим, мы будем
фильтровать спам, комментарии с негативным содержанием и слишком длинные комментарии.

Спам будем фильтровать по наличию указанных ключевых слов в тексте.Негативное содержание будем
определять по наличию одного из трех смайликов -  :( =( :|. Слишком длинные комментарии будем о
пределять исходя из данного числа - максимальной длины комментария.

Вы решили абстрагировать фильтр в виде следующего интерфейса:

interface TextAnalyzer {
    Label processText(String text);
}

Label – тип-перечисление, которые содержит метки, которыми будем помечать текст:

enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

Дальше, вам необходимо реализовать три класса, которые реализуют данный интерфейс: SpamAnalyzer,
 NegativeTextAnalyzer и TooLongTextAnalyzer. SpamAnalyzer должен конструироваться от массива строк
 с ключевыми словами. Объект этого класса должен сохранять в своем состоянии этот массив строк в
 приватном поле keywords. NegativeTextAnalyzer должен конструироваться конструктором по-умолчанию.
  TooLongTextAnalyzer должен конструироваться от int-а с максимальной допустимой длиной комментария.
   Объект этого класса должен сохранять в своем состоянии это число в приватном поле maxLength.

Наверняка вы уже заметили, что SpamAnalyzer и NegativeTextAnalyzer во многом похожи: они оба проверяют
текст на наличие каких-либо ключевых слов (в случае спама мы получаем их из конструктора, в случае
негативного текста мы заранее знаем набор грустных смайликов) и в случае нахождения одного из ключевых
 слов возвращают Label (SPAM и NEGATIVE_TEXT соответственно), а если ничего не нашлось возвращают OK.
  Давайте эту логику абстрагируем в абстрактный класс KeywordAnalyzer следующим образом:

Выделим два абстрактных метода getKeywords и getLabel, один из которых будет возвращать набор ключевых
слов, а второй метку, которой необходимо пометить положительные срабатывания. Нам незачем показывать эти
методы потребителям классов, поэтому оставим доступ к ним только для наследников. Реализуем processText
таким образом, чтобы он зависел только от getKeywords и getLabel. Сделаем SpamAnalyzer и NegativeTextAnalyzer
 наследниками KeywordAnalyzer и реализуем абстрактные методы.

Последний штрих - написать метод checkLabels, который будет возвращать метку для комментария по набору
анализаторов текста. checkLabels должен возвращать первую не-OK метку в порядке данного набора анализаторов,
и OK, если все анализаторы вернули OK. Используйте, пожалуйста, самый открытый модификатор доступа для всех классов.
 В итоге, реализуйте классы KeywordAnalyzer, SpamAnalyzer, NegativeTextAnalyzer и TooLongTextAnalyzer и метод
 checkLabels. TextAnalyzer и Label уже подключены, лишние импорты вам не потребуются.

Все классы реализации должны быть публичные*/


