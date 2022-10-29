public class CustomerManager {
      private BaseDatabaseManager baseDatabaseManager;

    public CustomerManager(BaseDatabaseManager baseDatabaseManager) {
        this.baseDatabaseManager = baseDatabaseManager;
    }


    public void getCustomer(){
        System.out.println("Müsteriler getirildi");
        this.baseDatabaseManager.getData();
    }
}
