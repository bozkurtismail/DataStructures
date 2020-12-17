package algoritmalar;
import java.util.Scanner;
public class algoritmalar {
    public static void main(String[] args) {
        int diziBoyutu;
        int secim;

        Scanner input = new Scanner(System.in);
        System.out.println("      DIZI BOYUTUNU GIRINIZ");
        System.err.println("**********************************");
        System.out.print("               ");
        diziBoyutu = input.nextInt();

        int[] siralamaDizisi = new int[diziBoyutu];
        
        System.err.println("**********************************");
        input.nextLine();
        System.out.println("  DIZI ELEMANLARINIZI GIRINIZ");
        System.err.println("**********************************");
        

        for (int i = 0; i < diziBoyutu; i++) 
        {
            System.out.print((i+1) +". ELEMAN:" );
            siralamaDizisi[i]=input.nextInt();
        }        
        
         
        System.out.println("  DIZININ SIRALANMAMIS ELEMANLARI");        
        System.err.println("**********************************");
        
        for (int i = 0; i < diziBoyutu; i++) 
        {
            System.out.print("    "+siralamaDizisi[i]+" ");            
        }
        
        siralama siralamaNesnesi=new siralama(siralamaDizisi);
        
        
        System.out.println("");
        System.out.println("SIRALAMA ALGORITMASI SECINIZ\n");
        System.out.println("1-Bubble sort\n2-Insertion Sort\n3-Selection Sort");
        System.out.println("              SECIM");
        System.out.println("**********************************");
        System.out.print("               ");
        
        secim=input.nextInt();
        switch(secim){
            case 1:
                siralamaNesnesi.bubbleSort();
                siralamaNesnesi.ekranaYazdir();
                break;
            case 2:
                siralamaNesnesi.insertionSort();
                break;
            case 3:
                siralamaNesnesi.selectionSort();
                siralamaNesnesi.ekranaYazdir();
                break;
        }
        
        //siralamaNesnesi.ekranaYazdir();

    }

}
