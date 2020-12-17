
import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class lab6CalismaMain {

    public static void main(String[] args) {
        int secim;
        int n;
        int eleman;
        Scanner input = new Scanner(System.in);

        System.out.println("===================================");
        System.out.print("ELEMAN SAYINIZI GIRINIZ:");
        n = input.nextInt();

        ShellSort siralama = new ShellSort(n);

        do {
            siralama.menuListele();
            secim = input.nextInt();

            switch (secim) {
                case 1:
                    if(siralama.count==0){
                        for (int i = 0; i < siralama.boyut; i++) {

                        System.out.print((i + 1) + ". ELEMANI GIRINIZ:");
                        siralama.dizi[i] = input.nextInt();
                        siralama.count++;
                    }
                    }else{
                        System.out.println("===================================");
                        System.out.println("DIZI SU ANDA DOLU");
                    }
                    
                    break;
                case 2:
                    siralama.listeleme();
                    break;
                case 3:
                    if (siralama.count == 0) {
                        System.out.println("===================================");
                        System.out.println("DIZIDE HIC ELEMAN YOK");
                    } else {
                        siralama.shellSort();
                    }

                    break;
                case 4:
                    System.out.println("SISTEMDEN CIKIS YAPILIYOR...");
                    break;
                default:
                    System.out.println("YANLIS SECIM YAPTINIZ TEKRAR DENEYIN!!");

            }
        } while (secim != 4);
    }
}
