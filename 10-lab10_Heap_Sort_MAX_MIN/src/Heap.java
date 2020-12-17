
/**
 *
 * @author İsmail BOZKURT
 */
public class Heap {

    private static int boyut;

    private int sol(int i) {
        return (2 * i) + 1;
    }

    private int sag(int i) {
        return (2 * i) + 2;
    }

    public int maxEnkucuk(int[] dizi) {
        return dizi[dizi.length - 1];
    }

    public int maxEnBuyuk(int[] dizi) {
        return dizi[0];
    }

    public void maxSort(int[] dizi) {
        boyut = dizi.length - 1;
        heapify(dizi);
    }

    public void minSort(int[] dizi) {
        boyut = dizi.length - 1;

        heapify(dizi);

        for (int i = boyut; i >= 0; i--) {
            int gecici = dizi[0];
            dizi[0] = dizi[i];
            dizi[i] = gecici;
            boyut = boyut - 1;
            heap(dizi, 0);
        }
    }

    private void heapify(int[] dizi) {
        for (int i = boyut; i >= 0; i--) {
            heap(dizi, i);
        }
    }

    private void heap(int[] dizi, int i) {
        int sol = sol(i); // şu an bulunduğumuzun düğümün çoçuğun konumu
        int sag = sag(i);//  şu an bulunduğumuzun düğümün çoçuğun konumu
        int enBuyuk = i;

        if ((sol <= boyut) && (dizi[sol] > dizi[enBuyuk])) // sol çoçuksa büyükse en büyük onu yapıyoruz
        {
            enBuyuk = sol;
        }

        if ((sag <= boyut) && (dizi[sag] > dizi[enBuyuk])) // sağ çoçuk ile en büyüğü karşılaştırıyoruz
        {
            enBuyuk = sag; // büyükse en büyük sağ çocuk yapıyoruz
        }
        if (enBuyuk != i) // iki konum aynı olana kadar
        {
            // konumlar arası değiştirme, change işlemi yapıyoruz
            int gecici = dizi[i];
            dizi[i] = dizi[enBuyuk];
            dizi[enBuyuk] = gecici;

            heap(dizi, enBuyuk); // değiştirilen konumları kontrol ediyoruz
        }
    }

    public void yazdir(int[] dizi) {
        int boyut = dizi.length;
        System.out.println("============================");
        for (int i = 0; i < boyut; i++) {
            System.out.print(dizi[i] + " ");
        }
    }

}
