public class Main {
    public static void main(String[] args) {
    CustomerDao customerDao = new MySqlCustomerDao();
    customerDao.add();
    CustomerManager customerManager = new CustomerManager(new OracleCustomerDao());
    customerManager.add();
    }
}
