
package lab5calisma;
/**
 *
 * @author İsmail BOZKURT
 */
public class MergeAlgoritmasi {
    String ad;
    String soyad;
    int dizi[];
    int gecici[];
    char karakter[];
    int count;
    int boyut;
    int sayac;

    public MergeAlgoritmasi(String[] kelimeDizisi) 
    {
        this.ad=kelimeDizisi[0];        
        this.soyad=kelimeDizisi[1];        
        this.boyut=ad.length()+soyad.length();
        this.dizi=new int[boyut];
        this.gecici=new int[boyut];
        this.karakter=new char[boyut];
        this.count=0;
        this.count=0;
        System.out.println("\n\n\n     OLUSTURULACAK DIZI BOYUTUNUZ");
        System.out.println("\t\t  "+boyut);
    }
    public void siralamaBaslasin(){
        adSoyadDiziyeYerlestir();
        bolmeIslemi(0, boyut - 1);
        diziyiDonusmusYazdir();        
        karakterDizisiniYazdir();
    }
    
    private void adSoyadDiziyeYerlestir() {
        char karakter;
        for (count = 0; count < ad.length(); count++) {
            karakter = ad.charAt(count);
            dizi[count] = asciOgren(karakter);
        }

        for (; count < boyut; count++) {
            karakter = soyad.charAt(sayac);
            dizi[count] = asciOgren(karakter);
            sayac++;
        }
        diziyiYazdir();

    }
    
    private int asciOgren(char ch) 
    {
        int deger = (int) ch;

        return deger;
    }
    private char karakterOgren(int sayi) 
    {
        char deger = (char) sayi;

        return deger;
    }
    private void diziyiYazdir() {
        System.out.println("\n\n");
        System.out.println("=========================================================");
        System.out.println("            OLUSTURULAN ASCII DIZIMIZ");
        for (int i = 0; i < boyut; i++) {
            System.out.print(dizi[i] + " ");
        }        
    }
    private void diziyiDonusmusYazdir() {
        System.out.println("\n\n\n\n");
        System.out.println("=========================================================");
        System.out.println("    KUCUKTEN-BUYUGE DONUSTURULEN MERGE DIZIMIZ");
        for (int i = 0; i < boyut; i++) {
            System.out.print(dizi[i] + " ");
        }
    }
    public void karakterDizisiniYazdir(){
        for(int i=0; i<boyut; i++){
            karakter[i]=karakterOgren(dizi[i]);
        }

        System.out.println("\n\n");
        System.out.println("=========================================================");
        System.out.println("    DIZIDEKI SAYILARIN KARAKTER KARSILIGI");
        
        for(int i=0; i<boyut; i++){
            System.out.print(karakter[i]+" ");
        }
    }
    private void bolmeIslemi(int sol, int sag) {
        if (sol < sag) {
            int merkez = sol + (sag - sol) / 2; // dizinin ortası
            bolmeIslemi(sol, merkez); // sol tarafı böl
            bolmeIslemi(merkez + 1, sag); // sağ tarafı böl
            mergeIslemi(sol, sag, merkez);
        }
    }
    
    public void mergeIslemi(int sol, int sag, int merkez) {
        for (int i = sol; i <= sag; i++) {
            gecici[i] = dizi[i]; // işlem yapılacak aralık geçici diziye atılır
        }
        int a = sol; // dizinin başlangıç noktası
        int b = merkez + 1; // bölüm noktası + 1 sağ kısmın başlangıç indisi
        int c = sol; // değiştirilen parçanın indisi
        while (a <= merkez && b <= sag) // sol kısım ortaya, diğer kısım bitişe gelene kadar
        {
            // sağ ve sol parçaların değerini karşılaştır
            if (gecici[a] <= gecici[b]) // küçükse eşit ise sol kısımdaki gelir.
            {
                dizi[c] = gecici[a];
                a++; // bir sonraki indisler için 
            } else {
                dizi[c] = gecici[b]; // büyük ise sağ kısım ile yer değiştirir.
                b++; // bir sonraki indisler için
            }
            c++; // diğer indise geç
        }
        while(a <= merkez) // işlem görmemiş kısımları orta noktaya gelene kadar array'a aktarıyoruz
        {
        dizi[c] = gecici[a];
        c++;
        a++;
        }
    }
    
    
    
}
