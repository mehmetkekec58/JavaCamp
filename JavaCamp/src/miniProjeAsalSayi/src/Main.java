package miniProjeAsalSayi.src;

public class Main {
    public static void main(String[] args) {
        int number = 1;
        int remainder = number % 2;
      //  System.out.println(remainder);
        boolean isPrime = true;

        if (number == 1) {
            System.out.println("Asal sayı değil");
            return;
        }

        if (number < 1) {
            System.out.println("Sayı geçersiz");
            return;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }

        if (isPrime)
            System.out.println("Sayı asal");
        else
            System.out.println("Sayı asal değil");
    }
}
