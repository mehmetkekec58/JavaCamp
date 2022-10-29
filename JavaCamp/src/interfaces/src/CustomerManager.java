public class CustomerManager {
    private final CustomerDao customerDao;
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public void add(){
        System.out.println("Eklendi");
        this.customerDao.add();
    }

}
