package lab2calisma;
/**
 *
 * @author İsmail BOZKURT
 */
public class kuyruk {

    public int[] dizi3;
    public int count3;

    public kuyruk(int N3) {
        this.dizi3 = new int[N3];
        int count3 = 0;
    }

    public int pop() {
        if (!bosMu()) {
            int tmp = this.dizi3[0];
            for (int i = 0; i < count3 - 1; i++) {
                this.dizi3[i] = dizi3[i + 1];

            }
            count3--;
            print();
            return tmp;

        } else {
            return 0;
        }

    }

    public void push(int item) {
        if (!doluMu()) {
            this.dizi3[count3++] = item;
            print();

        } else {
            System.out.println("KUYRUK DOLDU");

        }
    }

    public boolean bosMu() {
        if (count3 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean doluMu() {
        if (count3 >= this.dizi3.length) {
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        System.out.println("");
        System.out.print("KUYRUK -->");
        for (int i = 0; i < count3; i++) {
            System.out.println("\t:\t" + this.dizi3[i] + "\t:");
        }
        System.out.println("\t-----------------");
    }

}
