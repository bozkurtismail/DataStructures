package lab2calisma;
/**
 *
 * @author İsmail BOZKURT
 */
public class yigit2 {

    public int[] dizi2;
    public int count2;

    public yigit2(int N2) {
        this.dizi2 = new int[N2];
        int count2 = 0;
    }

    public void pop() {
        if (!bosMu()) {
            count2--;
            this.dizi2[count2] = 0;
            print();
        } else {
            System.out.println("yıgıt2 bos");
        }
    }

    public void push(int item) {
        if (!doluMu()) {
            this.dizi2[count2] = item;
            count2++;
            print();

        } else {

            System.out.println("Y2 DOLDU");
        }
    }

    public boolean bosMu() {
        if (count2 <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doluMu() {
        if (count2 >= this.dizi2.length) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("");
        System.out.print("Y2 -->");
        for (int i = 0; i < count2; i++) {
            System.out.println("\t:\t" + this.dizi2[i] + "\t:");
        }
        System.out.println("\t-----------------");
    }

}
