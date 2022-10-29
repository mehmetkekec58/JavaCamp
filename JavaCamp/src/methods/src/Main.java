public class Main {
    public static void main(String[] args) {
       sayiBulmaca();
    }
        public static void sayiBulmaca(){
        int[] sayilar = new int[]{1, 2, 5, 7, 9, 0};
        int aranacak = 5;
        boolean varMi = false;
        for (int sayi : sayilar) {
            if(aranacak == sayi){
                varMi = true;
                break;
            }
        }
        String mesaj = "";
        if(varMi){
            mesaj = "Sayı var: "+ aranacak;
            mesajVer(mesaj);
        }else{
           mesajVer("Sayı yok: "+ aranacak);
        }
    }
        public static void mesajVer(String mesaj){
            System.out.println(mesaj);
        }
}

