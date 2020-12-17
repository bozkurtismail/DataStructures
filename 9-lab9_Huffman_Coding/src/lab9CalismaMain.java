
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class lab9CalismaMain {

    public static void yazdir(HuffmanNode root, String s) {

        if (root.sol == null && root.sag == null && Character.isLetter(root.karakter)) {

            System.out.println(root.karakter + ":" + s);

            return;
        }

        yazdir(root.sol, s + "0");
        yazdir(root.sag, s + "1");
    }

    public static void main(String[] args) {      

        int boyut = 6;
        char[] dizi = {'a', 'b', 'k', 'm', 'd', 'g'};
        int[] frekans = {50, 35, 20, 10, 8, 4};

        //min heap öncelikli sira ismiyle yığın yaratıldı
        PriorityQueue<HuffmanNode> sira
                = new PriorityQueue<HuffmanNode>(boyut, new Karsilastirmam());

        //HuffmanNode dugumunden dugumler yaratılıp oncelik sırasına gore yıgına yerlestirildi
        for (int i = 0; i < boyut; i++) {
            HuffmanNode dugum = new HuffmanNode();

            dugum.karakter = dizi[i];
            dugum.deger = frekans[i];

            dugum.sol = null;
            dugum.sag = null;

            sira.add(dugum);
        }

        //bos bir kok dugum olusturuldu
        HuffmanNode root = null;
        
        //yigin buyuklugu 1 dena fazla olana kadar en son elemandan başlamak üzere
        //yigin icerisindeki tüm düğümler teker teker yigindan alınıp iki düğümün
        //frekans değerleri toplanıp yeni bir düğümü yerleştirilerek tekrar yığına yerleştirme
        //işlemi yapılır
        while (sira.size() > 1) {
            
            HuffmanNode x = sira.peek();//yigin içindeki en son eleman
            sira.poll();

            HuffmanNode y = sira.peek();
            sira.poll();

            HuffmanNode huffmanDugumu = new HuffmanNode();//yeni bir düğüm oluşturma

            huffmanDugumu.deger = x.deger + y.deger;//yigindan alınan iki düğümün frekans değerleri toplamı
            huffmanDugumu.karakter = '-';

            huffmanDugumu.sol = x;

            huffmanDugumu.sag = y;

            root = huffmanDugumu;

            sira.add(huffmanDugumu); //düğümü yığına yerleştirme
        }

        yazdir(root, "");

    }
}
