package Chapter4;

public class Lesson4_2_6 {
    public static void main(String[] args) throws BadCreditHistoryException, ProblemWithLawException {

        BankWorker bankWorker = new BankEmpolyee();

        BankClient goodClient = new BankClient("John", true, false, 30_000);
        BankClient badClient1 = new BankClient("Martin", true, false, 15_000);
        BankClient badClient2 = new BankClient("Jane", false, true, 15_000);

        System.out.println(bankWorker.getCreditForClient(bankWorker, goodClient));
        System.out.println(bankWorker.getCreditForClient(bankWorker, badClient1));
        System.out.println(bankWorker.getCreditForClient(bankWorker, badClient2));

    }

    static class BankClient {
        String name;
        private boolean hasGoodCreditHistory;
        private boolean hasCriminalRecord;
        private int salary;

        public BankClient(String name, boolean hasGoodCreditHistory, boolean hasCriminalRecord, int salary) {
            this.name = name;
            this.hasGoodCreditHistory = hasGoodCreditHistory;
            this.hasCriminalRecord = hasCriminalRecord;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public boolean hasGoodCreditHistory() {
            return hasGoodCreditHistory;
        }

        public boolean hasCriminalRecord() {
            return hasCriminalRecord;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "BankClient{" +
                    "name='" + name + '\'' +
                    ", hasGoodCreditHistory=" + hasGoodCreditHistory +
                    ", hasCriminalRecord=" + hasCriminalRecord +
                    ", salary=" + salary +
                    '}';
        }
    }

    interface BankWorker {
        boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException;

        boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException;
    }

    static class BankEmpolyee implements BankWorker {

        private final int MIN_SALARY_FOR_APPROVAL = 30_000;

        @Override
        public boolean checkClientForCredit(BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException {
            if (!bankClient.hasGoodCreditHistory())
                throw new BadCreditHistoryException("Проблемы с банковской историей");
            if (bankClient.hasCriminalRecord())
                throw new ProblemWithLawException("У климента есть судимость");

            return bankClient.getSalary() >= MIN_SALARY_FOR_APPROVAL & bankClient.hasGoodCreditHistory() & !bankClient.hasCriminalRecord();
        }

        //    @Override
//    public boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) throws BadCreditHistoryException, ProblemWithLawException {
//        if (!bankWorker.checkClientForCredit(bankClient)) {
//            if (!bankClient.hasGoodCreditHistory()) {
//                System.out.println("Проблемы с банковской историей");
//                return false;
//            }
//        }
//        return bankWorker.checkClientForCredit(bankClient);
//    }

        //Ответ
        @Override
        public boolean getCreditForClient(BankWorker bankWorker, BankClient bankClient) /*throws BadCreditHistoryException, ProblemWithLawException*/ {
            try {
                return bankWorker.checkClientForCredit(bankClient);
            } catch (BadCreditHistoryException e) {
                System.out.println("Проблемы с банковской историей");
            } catch (ProblemWithLawException e) {
            }
            return false;
        }
    }

    static class BadCreditHistoryException extends Exception {
        public BadCreditHistoryException(String message) {
            super(message);
        }
    }

    static class ProblemWithLawException extends Exception {
        public ProblemWithLawException(String message) {
            super(message);
        }
    }
}



/*Урок с кодом
Есть класс BankClient - это класс, описывающий клиента банка.

Есть интерфейс BankWorker. Объект класса, который реализует этот
интерфейс является работником банка, в задачу которого входит
одобрение или отклонение заявок на кредиты.

У него есть метод checkClientForCredit, который на вход принимает
экземпляр BankClient и возвращает true, если всё впорядке и кредит
переданному клиенту можно выдавать, или false - если клиент не подходит
 под условия кредита. Также, этот метод может выбросить исключение
 BadCreditHistoryException, если у клиента плохая кредитная история.
 Или ProblemWithLawException, если у клиента есть проблемы с законом.

Ваша задача:

Реализовать метод getCreditForClient, который принимает работника банка
 и клиента, который хочет получить кредит. Метод должен возвращать true -
  если кредит выдать можно и все условия соблюдены и false если есть какие-то
  проблемы. Если клиенту отказали в выдаче кредита по причине плохой банковской
  истории - метод должен выводить в консоль сообщение "Проблемы с банковской
  историей", если клиенту отказали по причине проблем с законом то ничего выводить
   на экран не нужно.*/
