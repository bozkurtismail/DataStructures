/**
 *
 * @author İsmail BOZKURT
 */
public class kuyruk {

    int[] dizi;
    int count;

    kuyruk(int N) {
        this.dizi = new int[N];
        int count = 0;
    }

    public int pop() {
        if (!bosMu()) {
            
            int tmp = this.dizi[0];
            
            for (int i = 0; i < count-1; i++) {
                this.dizi[i] = this.dizi[i + 1];
            }
            count--;
            print();
            return tmp;

        } else {
            return 0;
        }

    }

    public void push(int item) {
        if (!doluMu()) {
            this.dizi[count++] = item;
            print();
        } else {
            System.out.println("KUYRUK DOLDU");
        }
    }

    public boolean bosMu() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doluMu() {
        if (count >= this.dizi.length) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("");
        System.out.println("KUYRUK -->");
        for (int i = 0; i < count; i++) {
            System.out.println("\t:\t" + this.dizi[i] + "\t:");
        }
        System.out.println("\t-----------------");
    }

    public void menuListele() {
        System.out.println("");
        System.out.println("\t\t\t\t--------------------");
        System.out.println("\t\t\t\t|       MENU       |");
        System.out.println("\t\t\t\t|1.Ekleme          |");
        System.out.println("\t\t\t\t|2.Silme           |");
        System.out.println("\t\t\t\t|3.Listeleme       |");
        System.out.println("\t\t\t\t|4.Çıkış           |");
        System.out.println("\t\t\t\t--------------------");
        System.out.print("\t\t\t\tSECIM YAPINIZ :  ");
    }

    public void menuAraListele() {
        System.out.println("\t\t\t\t--------------------");
        System.out.println("\t\t\t\t|       MENU       |");
        System.out.println("\t\t\t\t|1.Basa Ekleme     |");
        System.out.println("\t\t\t\t|2.Araya Ekleme    |");
        System.out.println("\t\t\t\t|3.Sona Ekleme    |");
        System.out.println("\t\t\t\t|4.Vazgeçme        |");
        System.out.println("\t\t\t\t--------------------");
        System.out.print("\t\t\t\tSECIM YAPINIZ :  ");

    }

    public void menuSilme() {
        System.out.println("");
        System.out.println("\t\t\t\t--------------------");
        System.out.println("\t\t\t\t|       MENU       |");
        System.out.println("\t\t\t\t|1.Bastan Sil      |");
        System.out.println("\t\t\t\t|2.Aradan Sil      |");
        System.out.println("\t\t\t\t|3.Sondan Sil      |");
        System.out.println("\t\t\t\t|4.Vazgeçme        |");
        System.out.println("\t\t\t\t--------------------");
        System.out.print("\t\t\t\tSECIM YAPINIZ :  ");
    }

}
