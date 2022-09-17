package recapDemo1.src;

public class Main {
    public static void main(String[] args) {
        int sayi1 = 12;
        int sayi2 = 15;
        int sayi3 = 8;

        int enBuyukSayi = sayi1;

        if(enBuyukSayi<sayi2){
            enBuyukSayi = sayi2;
        }
        if(enBuyukSayi<sayi3){
            enBuyukSayi = sayi3;
        }

        System.out.println("En büyük sayı: " + enBuyukSayi);
    }
}
