public class Main {
    public static void main(String[] args) {
        BaseKrediManager[] baseKrediManagers = new BaseKrediManager[]{new OgrenciKrediManager(), new TarimKrediManager(), new OgrenciKrediManager()};
        for (BaseKrediManager baseKrediManager : baseKrediManagers) {
            System.out.println(baseKrediManager.hesapla(1000));
        }
    }
}
