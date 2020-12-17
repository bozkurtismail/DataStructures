
import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class lab10CalismaMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Heap yigin = new Heap();

        int boyut = 0;

        System.out.println("DIZI BOYUTUNU GIRINIZ:");
        boyut = input.nextInt();

        int[] dizi = new int[boyut];

        for (int i = 0; i < boyut; i++) {
            System.out.println((i + 1) + ". elemani giriniz:");
            dizi[i] = input.nextInt();
        }

        System.out.println("SIRASIZ DIZINIZ");
        yigin.yazdir(dizi);

        System.out.println("\nMENU");
        System.out.println("1-Max Heap\n2-Min Heap\nSecim Yapiniz:");
        int secim = input.nextInt();
        switch (secim) {
            case 1:
                yigin.maxSort(dizi);
                System.out.println("\nSIRALANMIS DIZINIZ");
                yigin.yazdir(dizi);
                System.out.println("\nEN BUYUK DEGER : " + yigin.maxEnBuyuk(dizi));
                System.out.println("EN KUCUK DEGER : " + yigin.maxEnkucuk(dizi));
                break;
            case 2:
                yigin.minSort(dizi);
                System.out.println("\nSIRALANMIS DIZINIZ");
                yigin.yazdir(dizi);
                System.out.println("\nEN KUCUK DEGER : " + yigin.maxEnBuyuk(dizi));
                System.out.println("EN BUYUK DEGER : " + yigin.maxEnkucuk(dizi));
                break;
            default:
                System.out.println("YANLIS SECIM TEKRAR DENEYIN");
                break;
        }

    }

}
