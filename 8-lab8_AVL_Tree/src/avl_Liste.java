
/**
 *
 * @author İsmail BOZKURT
 */
public class avl_Liste {

    dugum_avl kok;

    public avl_Liste() {
        this.kok = null;
    }

    public dugum_avl araRecursive(dugum_avl kok, int deger) {
        if (kok == null) {
            return null;
        }
        if (kok.deger == deger) {
            return kok;
        } else if (kok.deger > deger) {
            return araRecursive(kok.sol, deger);
        } else {
            return araRecursive(kok.sag, deger);
        }
    }

    public void degerEkle(int deger) {
        this.kok = ekleRecursive(this.kok, deger);
    }

    public dugum_avl ekleRecursive(dugum_avl kok, int deger) {
        if (kok == null) {
            kok = new dugum_avl(deger);
        } else if (kok.deger > deger) {
            kok.sol = ekleRecursive(kok.sol, deger);
        } else if (kok.deger < deger) {
            kok.sag = ekleRecursive(kok.sag, deger);
        }

        /*
        1- yukseklik hesapla
        2- dengelimi?
        3-dengeli degilse rotasyon yap
        4-dugum yuksekligini guncelle
         */
        kok.yukseklik = max(yukseklikBul(kok.sol), yukseklikBul(kok.sag)) + 1;

        //dugum dengesini hesaplayacagız
        int denge = dengeBul(kok);

        //sol dengesizlik
        if (denge > 1 && deger < kok.sol.deger) {
            return sagaDondur(kok);
        }

        //sag dengesizlik
        if (denge < -1 && deger > kok.sag.deger) {

            return solaDondur(kok);
        }

        //sol-sag
        if (denge > 1 && deger > kok.sol.deger) {
            kok.sol = solaDondur(kok.sol);
            return sagaDondur(kok);
        }

        //sag-sol
        if (denge < -1 && deger < kok.sag.deger) {
            kok.sag = sagaDondur(kok.sag);
            return solaDondur(kok);
        }

        return kok;
    }

    public dugum_avl solaDondur(dugum_avl dugum) {
        dugum_avl n = dugum.sag;
        dugum_avl temp = n.sol;
        n.sol = dugum;
        dugum.sag = temp;
        dugum.yukseklik = max(yukseklikBul(dugum.sol), yukseklikBul(dugum.sag)) + 1;
        n.yukseklik = max(yukseklikBul(n.sol), yukseklikBul(n.sag)) + 1;
        return n;
    }

    public dugum_avl sagaDondur(dugum_avl dugum) {
        dugum_avl n = dugum.sol;
        dugum_avl temp = n.sag;
        n.sag = dugum;
        dugum.sol = temp;
        dugum.yukseklik = max(yukseklikBul(dugum.sol), yukseklikBul(dugum.sag)) + 1;
        n.yukseklik = max(yukseklikBul(n.sol), yukseklikBul(n.sag)) + 1;
        return n;

    }

    public int yukseklikBul(dugum_avl dugum) {
        if (dugum == null) {
            return 0;
        } else {
            return dugum.yukseklik;
        }
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public int dengeBul(dugum_avl dugum) {
        if (dugum == null) {
            return 0;
        } else {
            int denge = yukseklikBul(dugum.sol) - yukseklikBul(dugum.sag);
            return denge;
        }
    }

    public dugum_avl sil(dugum_avl kok, int deger) {
        if (kok == null) {
            return null;
        }
        if (kok.deger > deger) {
            kok.sol = sil(kok.sol, deger);
        } else if (kok.deger < deger) {
            kok.sag = sil(kok.sag, deger);
        } else {
            if (kok.sol != null && kok.sag != null) {
                dugum_avl enb = enBuyukBul(kok.sol);
                kok.deger = enb.deger;
                kok.sol = sil(kok.sol, kok.deger);
            } else if (kok.sol != null) {
                kok = kok.sol;
            } else {
                kok = kok.sag;
            }
        }
        return kok;
    }

    public dugum_avl enBuyukBul(dugum_avl kok) {
        if (kok.sag == null) {
            return kok;
        } else {
            return enBuyukBul(kok.sag);
        }
    }

    public dugum_avl enKucukBul(dugum_avl kok) {
        if (kok.sol == null) {
            return kok;
        } else {
            return enKucukBul(kok.sol);
        }
    }

     public void yazdir() {
        dugum_avl deger1 = kok;
        if (deger1 == null) {
            System.out.println("AGAC YOK");
        } else {
            System.out.println("KOK :" + kok.deger);
            yazdirmaislemi(deger1);
        }
    }

    public void yazdirmaislemi(dugum_avl gelen) {
        if (gelen.sol != null) {
            System.out.println("SOLA :" + gelen.sol.deger);
            yazdirmaislemi(gelen.sol);
        }
        if (gelen.sag != null) {
            System.out.println("SAGA :" + gelen.sag.deger);
            yazdirmaislemi(gelen.sag);
        }
    }
    
    public void menuListele() {
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("|       MENU       |");
        System.out.println("|1.Ekleme          |");
        System.out.println("|2.Listeleme       |");
        System.out.println("|3.Silme           |");
        System.out.println("|4.Arama           |");
        System.out.println("|5.Çıkış           |");
        System.out.println("--------------------");
        System.out.print("SECIM YAPINIZ :  ");
    }

}
