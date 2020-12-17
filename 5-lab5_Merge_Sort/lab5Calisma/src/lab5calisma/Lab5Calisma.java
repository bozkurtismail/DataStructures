package lab5calisma;

import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class Lab5Calisma {

    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int diziBoyutu;
        String[] kelime=null;
        String cumle;
        
        System.out.println("==========================================");
        System.out.println("         ADINIZ VE SOYADINIZ");       
        System.out.print("         ");
        cumle=input.nextLine();
        kelime=cumle.split(" ");
        
        MergeAlgoritmasi siralama=new MergeAlgoritmasi(kelime);
        siralama.siralamaBaslasin();
    }

}
