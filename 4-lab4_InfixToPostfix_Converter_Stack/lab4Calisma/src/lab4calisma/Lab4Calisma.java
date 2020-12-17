package lab4calisma;

import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class Lab4Calisma {

    public static void main(String[] args) {

        int diziBoyutu = 17;
        Scanner input = new Scanner(System.in);

        String[] sayisalDegerler = new String[diziBoyutu];

        System.out.println("**********************************");
        System.out.println("  DIZI ELEMANLARINIZI GIRINIZ");
        System.out.println("**********************************");

        for (int i = 0; i < diziBoyutu; i++) {
            System.out.print((i + 1) + ". ELEMAN:");
            sayisalDegerler[i] = input.next();
        }       

        System.out.println("\n==========================================");
        System.out.println("              DONUSUM ISLEMI\n");

        System.out.println("              INFIX GOSTERIMI");
        for (int i = 0; i < sayisalDegerler.length; i++) {
            System.out.print(sayisalDegerler[i]);
        }
        donusumBaslasin cevir = new donusumBaslasin(sayisalDegerler);
        
        cevir.InfixCevirPostfix();
    }
}