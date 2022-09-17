package arraysDemo.src;

public class Main {
    public static void main(String[] args) {
        String ogrenci1 = "Ahmet";
        String ogrenci2 = "Mehmet";
        String ogrenci3 = "Ayşe";
        String ogrenci4 = "Atilla";

        System.out.println(ogrenci1);
        System.out.println(ogrenci2);
        System.out.println(ogrenci3);
        System.out.println(ogrenci4);

        System.out.println("------------------------");

        String[] ogrenciler = new String[4];
        ogrenciler[0] = "Ahmet";
        ogrenciler[1] = "Mehmet";
        ogrenciler[2] = "Ayşe";
        ogrenciler[3] = "Atilla";

        for (int i=0; i< ogrenciler.length; i++){
            System.out.println(ogrenciler[i]);
        }

        for (String ogrenci:ogrenciler){
            System.out.println(ogrenci);
        }


    }
}
