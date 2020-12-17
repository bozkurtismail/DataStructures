
package lab2calisma;

import java.util.Scanner;

/**
 *
 * @author İsmail BOZKURT
 */
public class Lab2Calisma {

   
    public static void main(String[] args) {
        // TODO code application logic here
        int y1, y2, k1;       
        Scanner input = new Scanner(System.in);

        System.out.println("----------------------------");
        System.out.println("1. YIGIT IN BOYUTUNU GİRİNİZ");
        System.out.println("----------------------------");
        System.out.print("             ");
        y1 = input.nextInt();

        System.out.println("----------------------------");
        System.out.println("2. YIGIT IN BOYUTUNU GİRİNİZ");
        System.out.println("----------------------------");
        System.out.print("             ");
        y2 = input.nextInt();

        System.out.println("----------------------------");
        System.out.println("KUYRUGUN  BOYUTUNU GİRİNİZ");
        System.out.println("----------------------------");
        System.out.print("             ");
        k1 = input.nextInt();

        yigit1 yigit1 = new yigit1(y1);
        yigit2 yigit2 = new yigit2(y2);
        kuyruk kuyruk1 = new kuyruk(k1);

        int eleman;

        for (int i = 1; i <= (y1 + y2 + k1 + 1); i++) {
            System.out.println("");

            System.out.println("EKLENECEK ELEMANI GIRINIZ");

            System.out.print("             ");
            eleman = input.nextInt();

            if (!yigit1.doluMu()) {
                yigit1.push(eleman);
            } else if (!kuyruk1.doluMu()) {
                kuyruk1.push(eleman);
            } else if (!yigit2.doluMu()) {
                yigit2.push(eleman);
            } else {
                System.out.println("DIZILERINDE YER KALMADI");
            }

        }

        kuyruk1.pop();
        System.out.println("KUYRUKTAN ELEMAN ÇIKARILDI\n");
        System.out.println("===============================");
        yigit1.pop();
        System.out.println("STACK 1DEN ELEMAN ÇIKARILDI\n");
        System.out.println("===============================");
        yigit2.pop();
        System.out.println("STACK 2 DEN ELEMAN ÇIKARILDI\n");
        System.out.println("===============================");

    }

}
