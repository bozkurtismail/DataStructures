
import java.util.Scanner;
/**
 *
 * @author İsmail BOZKURT
 */
public class mainBolumu {

    public static void main(String[] arg) {
        int k1;
        int secim = 0, secim2 = 0, secim3 = 0, secim4 = 0, no;
        int girilenSayi;
        boolean tekMiciftMi = false;
        int tekCiftTahmin;
        Scanner input = new Scanner(System.in);
        bagliListeCift cift = new bagliListeCift();
        bagliListeTek tek = new bagliListeTek();

        System.out.println("----------------------------");
        System.out.println("KUYRUGUN  BOYUTUNU GİRİNİZ");
        System.out.println("----------------------------");
        System.out.print("             ");
        k1 = input.nextInt();
        kuyruk kuyruk1 = new kuyruk(k1);

        do {
            System.out.println("\n\t\t\t\t  KUYRUK ISLEMLERI");
            kuyruk1.menuListele();
            secim = input.nextInt();

            switch (secim) {
                case 1:// secim
                    System.out.println("===================");
                    System.out.println("= SAYIYI GIRINIZ =");
                    System.out.print("         ");
                    girilenSayi = input.nextInt();

                    if (!kuyruk1.doluMu()) {
                        kuyruk1.push(girilenSayi);
                    } else {
                        System.out.println("KUYRUK DOLDU \nLINKED LISTE DEVAM EDECEK");
                        if (girilenSayi % 2 == 1) {
                            tekMiciftMi = false; //tek sayi;
                            System.out.println("===================");
                            System.out.println("= SAYINIZ TEK SAYI =");
                        } else {
                            tekMiciftMi = true;//çift sayi
                            System.out.println("===================");
                            System.out.println("= SAYINIZ CIFT SAYI =");
                        }
                        System.out.println("");
                        System.out.println("\t\t\t\tLINKED LIST ISLEMLERI");

                        kuyruk1.menuListele();
                        secim2 = input.nextInt();

                        switch (secim2) {
                            case 1://secim 2
                                if (tekMiciftMi) {
                                    System.out.println("\n\n\t\t\t\tCIFT EKLEME BOLUMU");
                                    kuyruk1.menuAraListele();
                                    secim3 = input.nextInt();
                                    dugum node = new dugum(girilenSayi);
                                    switch (secim3) {
                                        case 1://secim 3
                                            //basa ekleme                                            
                                            cift.basaEkle(node);
                                            System.out.println("\t\t\t\t=============================");
                                            System.out.println("\t\t\t\t=  KAYIT BASARIYLA EKLENDI  =");
                                            System.out.println("\t\t\t\t=============================");
                                            cift.listele();
                                            break;
                                        case 2://secim 3
                                            //araya ekleme;
                                            cift.arayaEkle(node);
                                            System.out.println("\t\t\t\t=============================");
                                            System.out.println("\t\t\t\t=  KAYIT BASARIYLA EKLENDI  =");
                                            System.out.println("\t\t\t\t=============================");
                                            cift.listele();
                                            break;
                                        case 3://secim 3
                                            cift.sonaEkle(node);
                                            System.out.println("\t\t\t\t=============================");
                                            System.out.println("\t\t\t\t=  KAYIT BASARIYLA EKLENDI  =");
                                            System.out.println("\t\t\t\t=============================");
                                            cift.listele();
                                            break;
                                        case 4://secim 3
                                            //ekleme işleminden vazgeçti
                                            break;
                                    }

                                } else {
                                    System.out.println("\n\n\t\t\t\tTEK EKLEME BOLUMU");
                                    kuyruk1.menuAraListele();
                                    secim3 = input.nextInt();
                                    dugum node = new dugum(girilenSayi);
                                    switch (secim3) {
                                        case 1://secim 3
                                            //basa ekleme                                            
                                            tek.basaEkle(node);
                                            System.out.println("\t\t\t\t=============================");
                                            System.out.println("\t\t\t\t=  KAYIT BASARIYLA EKLENDI  =");
                                            System.out.println("\t\t\t\t=============================");
                                            tek.listele();
                                            break;
                                        case 2://secim 3
                                            //araya ekleme;
                                            tek.arayaEkle(node);
                                            System.out.println("\t\t\t\t=============================");
                                            System.out.println("\t\t\t\t=  KAYIT BASARIYLA EKLENDI  =");
                                            System.out.println("\t\t\t\t=============================");
                                            tek.listele();
                                            break;
                                        case 3://secim 3
                                            tek.sonaEkle(node);
                                            System.out.println("\t\t\t\t=============================");
                                            System.out.println("\t\t\t\t=  KAYIT BASARIYLA EKLENDI  =");
                                            System.out.println("\t\t\t\t=============================");
                                            tek.listele();
                                            break;
                                        case 4://secim 3
                                            //ekleme işleminden vazgeçti
                                            break;
                                    }
                                }
                                break;
                            case 2://secim 2 //linked listen silme bölümü
                                System.out.println("1-TEK MI\n2-CIFT MI \nSILMEK ISTIYORSUNUZ?");
                                tekCiftTahmin = input.nextInt();

                                if (tekCiftTahmin == 1) {// kullanıcı tek sayıyı silmek istedi ise
                                    System.out.println("\n\n\t\t\t\tTEK SILME BOLUMU");
                                    kuyruk1.menuSilme();
                                    secim4 = input.nextInt();
                                    dugum gecici;
                                    switch (secim4) {
                                        case 1://secim 4 //bastan sil
                                            if ((gecici = tek.bastanSil()) != null) {
                                                System.out.println("\t\t\t\t=============================");
                                                System.out.println("\t\t\t\t=  KAYIT BASARIYLA SILINDI  =");
                                                System.out.println("\t\t\t\t=             " + gecici.sayi + "             =");
                                                System.out.println("\t\t\t\t=============================");
                                                tek.listele();
                                            } else {
                                                System.out.println("\t\t\t\t====================================");
                                                System.out.println("\t\t\t\t= TEK LISTEDE SILINECEK ELEMAN YOK =");
                                                System.out.println("\t\t\t\t====================================");
                                            }
                                            break;
                                        case 2://secim 4 // aradan sil
                                            tek.listele();
                                            System.out.println("================================================");
                                            System.out.println("= SILMEK ISTEDIGINIZ KAYDIN NUMARASINI GIRINIZ =");
                                            System.out.print("                           ");
                                            no = input.nextInt();
                                            dugum yeni = new dugum(no);

                                            if ((gecici = tek.aradanSil(yeni)) != null) {
                                                System.out.println("\t\t\t\t=============================");
                                                System.out.println("\t\t\t\t=  KAYIT BASARIYLA SILINDI  =");
                                                System.out.println("\t\t\t\t=             " + gecici.sayi + "             =");
                                                System.out.println("\t\t\t\t=============================");
                                                tek.listele();
                                            } else {
                                                System.out.println("\t\t\t\t====================================");
                                                System.out.println("\t\t\t\t= TEK LISTEDE SILINECEK ELEMAN YOK =");
                                                System.out.println("\t\t\t\t====================================");
                                            }
                                            break;
                                        case 3://secim 4 //sondan sil
                                            if ((gecici = tek.sondanSil()) != null) {
                                                System.out.println("\t\t\t\t=============================");
                                                System.out.println("\t\t\t\t=  KAYIT BASARIYLA SILINDI  =");
                                                System.out.println("\t\t\t\t=             " + gecici.sayi + "             =");
                                                System.out.println("\t\t\t\t=============================");
                                                tek.listele();
                                            } else {
                                                System.out.println("\t\t\t\t====================================");
                                                System.out.println("\t\t\t\t= TEK LISTEDE SILINECEK ELEMAN YOK =");
                                                System.out.println("\t\t\t\t====================================");
                                            }
                                            break;
                                        case 4://secim 4 
                                            // silmekten vazgeçti
                                            break;
                                    }

                                } else if (tekCiftTahmin == 2) {//kullanıcı çift sayı silmek istedi ise
                                    System.out.println("\n\n\t\t\t\tCIFT SILME BOLUMU");
                                    kuyruk1.menuSilme();
                                    secim4 = input.nextInt();
                                    dugum gecici;

                                    switch (secim4) {
                                        case 1://secim 4 //bastan sil
                                            if ((gecici = cift.bastanSil()) != null) {
                                                System.out.println("\t\t\t\t=============================");
                                                System.out.println("\t\t\t\t=  KAYIT BASARIYLA SILINDI  =");
                                                System.out.println("\t\t\t\t=             " + gecici.sayi + "             =");
                                                System.out.println("\t\t\t\t=============================");
                                                cift.listele();
                                            } else {
                                                System.out.println("\t\t\t\t=====================================");
                                                System.out.println("\t\t\t\t= CIFT LISTEDE SILINECEK ELEMAN YOK =");
                                                System.out.println("\t\t\t\t=====================================");;
                                            }
                                            break;
                                        case 2://secim 4 // aradan sil
                                            cift.listele();
                                            System.out.println("================================================");
                                            System.out.println("= SILMEK ISTEDIGINIZ KAYDIN NUMARASINI GIRINIZ =");
                                            System.out.print("                           ");
                                            no = input.nextInt();
                                            dugum yeni = new dugum(no);

                                            if ((gecici = cift.aradanSil(yeni)) != null) {
                                                System.out.println("\t\t\t\t=============================");
                                                System.out.println("\t\t\t\t=  KAYIT BASARIYLA SILINDI  =");
                                                System.out.println("\t\t\t\t=             " + gecici.sayi + "             =");
                                                System.out.println("\t\t\t\t=============================");
                                                cift.listele();
                                            } else {
                                                System.out.println("\t\t\t\t=====================================");
                                                System.out.println("\t\t\t\t= CIFT LISTEDE SILINECEK ELEMAN YOK =");
                                                System.out.println("\t\t\t\t=====================================");
                                            }
                                            break;
                                        case 3://secim 4 //sondan sil
                                            if ((gecici = cift.sondanSil()) != null) {
                                                System.out.println("\t\t\t\t=============================");
                                                System.out.println("\t\t\t\t=  KAYIT BASARIYLA SILINDI  =");
                                                System.out.println("\t\t\t\t=             " + gecici.sayi + "             =");
                                                System.out.println("\t\t\t\t=============================");
                                                cift.listele();
                                            } else {
                                                System.out.println("\t\t\t\t=====================================");
                                                System.out.println("\t\t\t\t= CIFT LISTEDE SILINECEK ELEMAN YOK =");
                                                System.out.println("\t\t\t\t=====================================");
                                            }
                                            break;
                                        case 4://secim 4 
                                            // silmekten vazgeçti
                                            break;
                                    }

                                } else {
                                    System.out.println("YANLIS SECIM YAPTINIZ!!!!!!");
                                }
                                break;
                            case 3://secim 2
                                tek.listele();
                                cift.listele();
                                break;
                            case 4://secim 2
                                //linked list islemlerine devam etmedi
                                break;
                        }
                    }
                    break;
                case 2:// secim
                    int sayi = kuyruk1.pop();
                    if (sayi == 0) {
                        System.out.println("KUYRUKTA ELEMAN KALMADI");
                    } else {
                        System.out.println("KUYRUKTAN SILINEN ELEMAN:" + sayi);
                    }
                    break;
                case 3:// secim
                    kuyruk1.print();
                    tek.listele();
                    cift.listele();
                    break;
                case 4:// secim
                    System.out.println("PROGRAMDAN ÇIKIŞ YAPILIYOR...");
                    break;
            }

        } while (secim != 4);

    }

}
