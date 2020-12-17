
import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class lab8CalismasiMain {
    
    public static void main(String[] args) {
        int secim;        
        int deger;
        Scanner input = new Scanner(System.in);
        avl_Liste avl=new avl_Liste();

        do {
            avl.menuListele();
            secim = input.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("DEGER GIRINIZ:");
                    deger=input.nextInt();
                    avl.degerEkle(deger);
                    break;
                case 2:
                   avl.yazdir();
                    break;
                case 3:
                    System.out.print("SILMEK ISTEDIGINIZ DEGERI GIRINIZ:");
                    deger=input.nextInt();
                    avl.sil(avl.kok, deger);
                    break;
                case 4:
                    System.out.print("ARAMAK ISTEDIGINIZ SAYIYI GIRIN:");
                    deger=input.nextInt();
                    dugum_avl temp=avl.araRecursive(avl.kok, deger);
                    if(temp==null){
                        System.out.println("DEGER AGACTA BULUNAMADI");                        
                    }
                    else{
                        System.out.println(temp.deger+" AGACTA BULUNDU");
                    }
                    
                    break;
                case 5:
                    System.out.println("SISTEMDEN CIKIS YAPILIYOR...");
                    break;
                default:
                    System.out.println("YANLIS SECIM YAPTINIZ TEKRAR DENEYIN!!");

            }
        } while (secim != 5);
        
        
        
        
    }
    
}
