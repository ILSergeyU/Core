package Chapter4;

import java.util.Arrays;
import java.util.logging.*;

//>>> JM принял. Нужна проверка в методе main!
//https://github.com/BJCreslin/Stepik-Java-4-9-test/blob/master/src/Solution.java
//https://github.com/WhiteK0T/Stepik-Java.BaseCourse/blob/master/src/4-3-8/Main.java


public class Lesson4_3_7 {

    private static final Logger logger = Logger.getLogger("Spy");

    //    public static void main(String[] args) {
//
//        Handler handlerToConsole = new ConsoleHandler();
//        handlerToConsole.setLevel(Level.OFF);
//        Formatter formatter = new SimpleFormatter();
//        handlerToConsole.setFormatter(formatter);
//        logger.addHandler(handlerToConsole);
//
//        AbstractSendable letter = new MailMessage(AUSTIN_POWERS, AUSTIN_POWERS, "Hello my friend");
//        AbstractSendable letter1 = new MailMessage("From_Somebody", "To_Somebody", "Hello Somebody");
//        AbstractSendable parcel = new MailPackage("hui hui", AUSTIN_POWERS, new Package("Hello my friend", 10));
//        AbstractSendable parcel1 = new MailPackage("Sanata", AUSTIN_POWERS, new Package(" 1 stones 3", 6));
//        AbstractSendable parcel2 = new MailPackage("Barbara", "Bomberman", new Package("weapons", 4));
//
//        MailService spy = new Spy(logger);
//        spy.processMail(letter);
//        spy.processMail(letter1);
//        spy.processMail(parcel);
//
//        MailService inspector = new Inspector();
//        inspector.processMail(parcel);
//
//        MailService thief = new Thief(5);
//        thief.processMail(letter);
//        thief.processMail(letter1);
//        thief.processMail(parcel);
//        thief.processMail(parcel1);
//        thief.processMail(parcel2);
//
//        MailService[] mailServices = new MailService[]{spy, thief, inspector};
//        MailService untrustedworker = new UntrustworthyMailWorker(mailServices);
//        //untrustedworker.processMail(parcel2);
//
//    }
    public static void main(String[] args) {
        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        MailService variousWorkers[] = new MailService[]{spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(variousWorkers);

        AbstractSendable correspondence[] = {
                //new MailMessage("Oxxxymiron", "Гнойный", "Я здесь чисто по фану, поглумиться над слабым\n" +
                //"Ты же вылез из мамы под мой дисс на Бабана...."),
                // new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                // "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                // new MailMessage("Жриновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                // new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                // new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("ракетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance", 99)),
                new MailPackage(AUSTIN_POWERS, "ИГИЛ (запрещенная группировка", new Package("tiny bomb", 9000)),
                //new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };
        Arrays.stream(correspondence).forEach(parcell -> {
            try {
                worker.processMail(parcell);
            } catch (StolenPackageException e) {
                logger.log(Level.WARNING, "Inspector found stolen package: " + e);
            } catch (IllegalPackageException e) {
                logger.log(Level.WARNING, "Inspector found illegal package: " + e);
            }
        });
    }

    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    public static abstract class AbstractSendable implements Sendable {

        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AbstractSendable that = (AbstractSendable) o;
            return from.equals(that.from) && to.equals(that.to);
        }
    }

    public static class MailMessage extends AbstractSendable {

        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailMessage that = (MailMessage) o;
            return message.equals(that.message);
        }
    }

    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailPackage that = (MailPackage) o;
            return content.equals(that.content);
        }
    }

    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Package aPackage = (Package) o;
            return price == aPackage.price && content.equals(aPackage.content);
        }
    }

    public interface MailService {
        Sendable processMail(Sendable mail);
    }

    public static class RealMailService implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    //------------------------------------------------------------------------------------
/*1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
 чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот
 объект набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно
 экземпляру RealMailService. У UntrustworthyMailWorker должен быть конструктор от массива MailService
 (результат вызова processMail первого элемента массива передается на вход processMail второго
 элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний экземпляр
 RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.*/
    public static class UntrustworthyMailWorker implements MailService {
        private final MailService[] mailServices;
        private final RealMailService realMailService;

        public UntrustworthyMailWorker(MailService[] mailServices) {
            this.mailServices = mailServices;
            realMailService = new RealMailService();
        }

        public RealMailService getRealMailService() {
            return this.realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for (MailService mailService : mailServices) {
                mail = mailService.processMail(mail);
            }
            return realMailService.processMail(mail);
        }
    }

    /*
    2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется
    от экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
    MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
    полей почты):
    2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с
    уровнем WARN: Detected target mail correspondence: from {from} to {to} "{message}"
    2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
    */
    public static class Spy implements MailService {
        private Logger logger;

        public Spy(Logger logger) {
            this.logger = logger;
            this.logger.setLevel(Level.INFO);
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter());
            this.logger.addHandler(consoleHandler);
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) {
                if (mail.getFrom().equals(AUSTIN_POWERS) | mail.getTo().equals(AUSTIN_POWERS)) {
                    logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                } else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    /*
    3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе
    переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен
    присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
    Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только с
    нулевой ценностью и содержимым посылки "stones instead of {content}".
    */
    public static class Thief implements MailService {

        private final int minCostPackage;
        private int stolenValue;

        public Thief(final int minCostPackage) {
            this.minCostPackage = minCostPackage;
            this.stolenValue = 0;
        }

        public int getStolenValue() {
            return stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) {
                int priceOfPackage = ((MailPackage) mail).getContent().getPrice();
                if (priceOfPackage >= minCostPackage) {
                    stolenValue += priceOfPackage;
                    return new MailPackage(mail.getFrom(), mail.getTo(), new Package("stones instead of  " +
                            ((MailPackage) mail).getContent().getContent(), 0));
                }
            }
            return mail;
        }
    }

    /*
    4) Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
    если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
    ("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состаящую из
    камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны
    объявить самостоятельно в виде непроверяемых исключений.
    */
    public static class Inspector implements MailService {
        @Override
        public Sendable processMail(Sendable mail) {
/*            if (mail.getClass() == NewLatter.MailPackage.class) {
                NewLatter.Package pac = ((NewLatter.MailPackage) mail).getContent();
                String content = pac.getContent();*/
            if (mail instanceof MailPackage) {
                String contentOfPackage = ((MailPackage) mail).getContent().getContent();
                if (contentOfPackage.contains("stones")) {
                    throw new StolenPackageException("Discovered the theft from the parcel!");
                } else if (contentOfPackage.contains(WEAPONS) | contentOfPackage.contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException("In the package discovered forbidden content.");
                }
            }
            return mail;
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException(String message) {
            super(message);
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException(String message) {
            super(message);
        }
    }
}


//content.contains(WEAPONS), метод content.equals() не подходит.}

//===================================================================================
   /* Урок с кодом
        Эта задачка совмещает тренировку по материалу предыдущих двух модулей –
        необходимо разобраться и написать объект-ориентированный код и при этом
        коснуться свежих тем – исключений и логирования.

        Дан набор классов, описывающих работу гипотетической почтовой системы.
         Для начала рассмотрим код, описывающий все используемые сущности.

*//*
Интерфейс: сущность, которую можно отправить по почте.
У такой сущности можно получить от кого и кому направляется письмо.
*//*
public static interface Sendable {
    String getFrom();
    String getTo();
}
    У Sendable есть два наследника, объединенные следующим абстрактным классом:

*//*
Абстрактный класс,который позволяет абстрагировать логику хранения
источника и получателя письма в соответствующих полях класса.
*//*
public static abstract class AbstractSendable implements Sendable {

    protected final String from;
    protected final String to;

    public AbstractSendable(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSendable that = (AbstractSendable) o;

        if (!from.equals(that.from)) return false;
        if (!to.equals(that.to)) return false;

        return true;
    }

}
    Первый класс описывает обычное письмо, в котором находится только текстовое сообщение.

*//*
Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
*//*
public static class MailMessage extends AbstractSendable {

    private final String message;

    public MailMessage(String from, String to, String message) {
        super(from, to);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailMessage that = (MailMessage) o;

        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

}
    Второй класс описывает почтовую посылку:

*//*
Посылка, содержимое которой можно получить с помощью метода `getContent`
*//*
public static class MailPackage extends AbstractSendable {
    private final Package content;

    public MailPackage(String from, String to, Package content) {
        super(from, to);
        this.content = content;
    }

    public Package getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MailPackage that = (MailPackage) o;

        if (!content.equals(that.content)) return false;

        return true;
    }

}

    При этом сама посылка описывается следующим классом:

*//*
Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
*//*
public static class Package {
    private final String content;
    private final int price;

    public Package(String content, int price) {
        this.content = content;
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Package aPackage = (Package) o;

        if (price != aPackage.price) return false;
        if (!content.equals(aPackage.content)) return false;

        return true;
    }
}

    Теперь рассмотрим классы, которые моделируют работу почтового сервиса:

*//*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*//*
public static interface MailService {
    Sendable processMail(Sendable mail);
}

*//*
Класс, в котором скрыта логика настоящей почты
*//*
public static class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}

    Вам необходимо описать набор классов, каждый из которых является MailService:

        1) UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты,
        который вместо того, чтобы передать почтовый объект непосредственно в сервис
         почты, последовательно передает этот объект набору третьих лиц, а затем, в
         конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
         У UntrustworthyMailWorker должен быть конструктор от массива MailService
         (результат вызова processMail первого элемента массива передается на вход
         processMail второго элемента, и т. д.) и метод getRealMailService, который
         возвращает ссылку на внутренний экземпляр RealMailService, он не приходит
         масивом в конструкторе и не настраивается извне класса.

        2) Spy – шпион, который логгирует о всей почтовой переписке, которая проходит
         через его руки. Объект конструируется от экземпляра Logger, с помощью которого
         шпион будет сообщать о всех действиях. Он следит только за объектами класса
         MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить
         части в фигурных скобках на значения полей почты):
        2.1) Если в качестве отправителя или получателя указан "Austin Powers", то
        нужно написать в лог сообщение с уровнем WARN: Detected target mail correspondence:
        from {from} to {to} "{message}"
        2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}

        3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное.
        Вор принимает в конструкторе переменную int – минимальную стоимость посылки,
         которую он будет воровать. Также, в данном классе должен присутствовать метод
         getStolenValue, который возвращает суммарную стоимость всех посылок, которые
         он своровал. Воровство происходит следующим образом: вместо посылки, которая
         пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым
         посылки "stones instead of {content}".

        4) Inspector – Инспектор, который следит за запрещенными и украденными посылками
        и бьет тревогу в виде исключения, если была обнаружена подобная посылка. Если он
        заметил запрещенную посылку с одним из запрещенных содержимым ("weapons" и "banned
        substance"), то он бросает IllegalPackageException. Если он находит посылку,
        состоящую из камней (содержит слово "stones"), то тревога прозвучит в виде
        StolenPackageException. Оба исключения вы должны объявить самостоятельно в
        виде непроверяемых исключений.

        Все классы должны быть определены как публичные и статические, так как в
        процессе проверки ваш код будет подставлен во внешний класс, который занимается
        тестированием и проверкой структуры. Для удобства во внешнем классе объявлено
         несколько удобных констант и импортировано все содержимое пакета java.util.logging.
          Для определения, посылкой или письмом является Sendable объект воспользуйтесь
          оператором instanceof.


public static final String AUSTIN_POWERS = "Austin Powers";
public static final String WEAPONS = "weapons";
public static final String BANNED_SUBSTANCE = "banned substance";*/