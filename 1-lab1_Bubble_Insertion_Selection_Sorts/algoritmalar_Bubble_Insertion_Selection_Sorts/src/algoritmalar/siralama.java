package algoritmalar;

import java.util.Random;

public class siralama {

    public int[] siralamaDizisi;

    public siralama(int[] siralamaDizisi) {
        this.siralamaDizisi = siralamaDizisi;
    }

    public void bubbleSort() {
        int gecici;

        for (int i = 0; i < siralamaDizisi.length - 1; i++) {
            for (int j = 0; j < siralamaDizisi.length - 1; j++) {
                if (siralamaDizisi[j] > siralamaDizisi[j + 1]) {
                    gecici = siralamaDizisi[j];
                    siralamaDizisi[j] = siralamaDizisi[j + 1];
                    siralamaDizisi[j + 1] = gecici;
                }
            }
        }
    }

    public void insertionSort() {
        int i, j;
        int key;
        Random r = new Random();
        System.out.println("SIRALANMAMIS RANDOM YENI DIZI");        
        System.out.println("**********************************");
        for (i = 0; i < siralamaDizisi.length; i++) {
            siralamaDizisi[i] = r.nextInt(30);
            System.out.print("    "+siralamaDizisi[i] + " ");
        }

        for (i = 1; i < siralamaDizisi.length; i++) {
            key = siralamaDizisi[i];
            j = i;
            while ((j > 0) && (siralamaDizisi[j - 1] < key)) {
                siralamaDizisi[j] = siralamaDizisi[j - 1];
                j = j - 1;
            }
            siralamaDizisi[j] = key;
        }
        ekranaYazdir();
    }

    public void selectionSort() {
        int i, j;
        int minimum;
        int gecici;

        for (i = 0; i < siralamaDizisi.length; i++) {
            minimum = i;
            for (j = (i + 1); j < (siralamaDizisi.length); j++) {
                if (siralamaDizisi[minimum] > siralamaDizisi[j]) {
                    minimum = j;
                }
            }
            gecici = siralamaDizisi[i];
            siralamaDizisi[i] = siralamaDizisi[minimum];
            siralamaDizisi[minimum] = gecici;
        }

    }

    public void ekranaYazdir() {
        System.out.println("");
        System.out.println("     DIZININ SIRALANMIS HALI");
        System.out.println("**********************************");

        for (int i = 0; i < siralamaDizisi.length; i++) {
            System.out.print("     "+siralamaDizisi[i] + " ");
        }
        System.out.println("");
    }

}
