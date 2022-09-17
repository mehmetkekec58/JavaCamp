package loopDemo.src;

public class Main {
    public static void main(String[] args) {
        // for döngüsü
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("for dögüsü bitti");

        //while döngüsü

        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        System.out.println("While döngüsü bitti");


        //do-while
        int j = 1;
        do {
            System.out.println(j);
            j++;
        } while (j < 10);

        System.out.println("do-While döngüsü bitti");
    }
}
