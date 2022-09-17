package reCapDemo2.src;

public class Main {
    public static void main(String[] args) {
        double[] list = {1.2, 2.4, 8.4, 9.2};
        double total = 0;
        double max = list[0];
        for (double number : list) {
            if(max<number){
                max = number;
            }
            total = total + number;
            System.out.println(number);
        }

        System.out.println("Toplam: "+total);
        System.out.println("En büyük sayı: "+ max);
    }
}
