
import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class bellMain {
    public static void main(String[] args) 
    { 
        Scanner input=new Scanner(System.in);
        int dugum;
        int kenar;
        int secim;
  
        System.out.println("KOSE NOKTA SAYISINI GIRINIZ");
        System.out.println("===========================");
        dugum=input.nextInt();// graftaki düğüm sayısı
        
        System.out.println("KENAR SAYISINI GIRINIZ");
        System.out.println("======================");
        kenar=input.nextInt();// graftaki kenar sayısı
        
        Graf graf = new Graf(dugum, kenar); 
        
        System.out.println("");
        for(int i=0; i<kenar; i++){//düğüm ve koşuları ayrıca aralarındaki ağırlıklar kullanıcıdan alınıyor
            System.out.println("=========================");
            System.out.println("            "+(i));
            System.out.println((i)+".dugumu giriniz:");
            graf.kenar[i].dugum=input.nextInt();
            System.out.println((i)+".komsusunu giriniz:");
            graf.kenar[i].komsu=input.nextInt();
            System.out.println(graf.kenar[i].dugum+"-"+graf.kenar[i].komsu+".arasindaki kenar agirligini giriniz:");
            graf.kenar[i].agirlik=input.nextInt();           
        }
        //oluşturulan graf içindeki komşuluklar ve ağırlıklar listelendi
        System.out.println("DUGUM         KOMSU         AGIRLIK");
        System.out.println("======================================");
        for(int i=0; i<kenar; i++){           
            System.out.println(graf.kenar[i].dugum+"\t\t"+graf.kenar[i].komsu+"\t\t"+graf.kenar[i].agirlik);
            System.out.println("");
                    
        }
        System.out.println("DUGUMLER LISTESI");
        System.out.println("=================");
        for(int i=0; i<dugum; i++){
            System.out.println("--"+i);
        }
        System.out.println("BASLANILMAK ISTENEN DUGUMU SECINIZ:");
        secim=input.nextInt();       
        graf.bellmanFord(graf, secim);       
    } 
    
}
