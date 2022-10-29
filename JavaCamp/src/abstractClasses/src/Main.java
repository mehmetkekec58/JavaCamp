public class Main {
    public static void main(String[] args) {
     GameCalculator[] gameCalculators = new GameCalculator[]{new ManGameCalculator(),new WomenGameCalculator(),new KidsGameCalculator()};
        for (GameCalculator gameCalculator: gameCalculators) {
         gameCalculator.hesapla();
         gameCalculator.gameOver();
        }
    }
}
