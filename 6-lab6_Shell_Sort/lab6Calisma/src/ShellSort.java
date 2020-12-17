/**
 *
 * @author İsmail BOZKURT
 */
public class ShellSort {

    int boyut;
    int[] dizi;
    int count;

    public ShellSort(int n) {
        this.boyut = n;
        this.dizi = new int[n];
        this.count = 0;
    }

    public void listeleme() {
        if (count == 0) {
            System.out.println("===================================");
            System.out.println("DIZIDE HIC ELEMAN YOK");
        } else {
            System.out.println("===================================");
            System.out.println("DIZIDEKI ELEMANLAR");
            for (int i = 0; i < boyut; ++i) {
                System.out.print(dizi[i] + " ");
            }
            System.out.println();
        }

    }

    public void menuListele() {
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("|       MENU       |");
        System.out.println("|1.Ekleme          |");
        System.out.println("|2.Listeleme       |");
        System.out.println("|3.Siralama Yap    |");
        System.out.println("|4.Çıkış           |");
        System.out.println("--------------------");
        System.out.print("SECIM YAPINIZ :  ");
    }

    public void shellSort() {        
        
        for (int pivot = boyut/2; pivot > 0; pivot /= 2) 
        {  
            for (int i = pivot; i < boyut; i += 1) 
            {                
                int gecici = dizi[i];
                
                int j; 
                for (j = i; j >= pivot && dizi[j - pivot] > gecici; j -= pivot){
                    dizi[j] = dizi[j - pivot]; 
                } 
                    
                
                dizi[j] = gecici; 
            } 
        

        }        

    }

}
