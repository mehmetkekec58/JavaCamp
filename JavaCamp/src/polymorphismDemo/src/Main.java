public class Main {
    public static void main(String[] args) {
        BaseLogger[] baseLoggers = new BaseLogger[]{new EmailLogger(),new DatabaseLogger()};
        for (BaseLogger baseLogger:baseLoggers) {
            baseLogger.log("mesaj loglandı");
        }

        CustomerManager customerManager = new CustomerManager(new DatabaseLogger());
        customerManager.add();

    }
}
