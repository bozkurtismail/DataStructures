package lab2calisma;
/**
 *
 * @author İsmail BOZKURT
 */
public class yigit1 {

    public int[] dizi;
    public int count;

    public yigit1(int N) {
        this.dizi = new int[N];
        int count = 0;
    }

    public void pop() {
        if (!bosMu()) {
            count--;
            this.dizi[count] = 0;
            print();
        } else {
            System.out.println("yıgıt1 bos");
        }
    }

    public void push(int item) {
        if (!doluMu()) {
            this.dizi[count] = item;
            count++;
            print();

        } else {
            System.out.println("Y1 DOLDU");

        }
    }

    public boolean bosMu() {
        if (count <= 0) {
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
        System.out.print("Y1 -->");
        for (int i = 0; i < count; i++) {
            System.out.println("\t:\t" + this.dizi[i] + "\t:");
        }
        System.out.println("\t-----------------");
    }

}
