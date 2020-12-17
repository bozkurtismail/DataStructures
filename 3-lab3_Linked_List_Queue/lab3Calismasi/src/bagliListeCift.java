/**
 *
 * @author İsmail BOZKURT
 */
public class bagliListeCift {

    dugum bas;
    dugum son;
    int count;

    bagliListeCift() {
        this.bas = null;
        this.son = null;
        this.count = 0;
    }

    public void basaEkle(dugum yeni) {
        yeni.sonraki = bas; //onceden dugum olup yeni gelen dogumun sonraki pointeri ilk bastakini gösterip 
        bas = yeni;        //bas pointeri ise yeni gelen pointere kaydırıldı.
        if (count == 0) {   // eger listede hiç düğüm yoksa ve ilk defa başa düğüm eklenecekse son pointereda
            son = yeni;  //yeni gelen düğümü işaretleyecek.
            count++;
        }
        
    }

    public void sonaEkle(dugum yeni) {
        if (this.count == 0) {         //eğer hafızada hiç düğüm yoksa ve sona ekle diye gönderiyorsak 
            this.basaEkle(yeni);  //ilk ekleniyormuş gibi başa ekle metodu çağrılır.
        } else {
            son.sonraki = yeni;     //son kaldığımız düğümde yeni gelen düğümle bağlamak için en son düğümümüzün 
            son = yeni;            //sonraki pointeri normalde değeri null ,sonraki pointeri =yeni dersek
            this.count++;        //yeni düğümü listeye bağlamış olup son pointerini bi sıra kaydırarak            
        }                        //en son gelen yeni düğümünü son yapmış oluruz   
    }

    public void arayaEkle(dugum yeni) {
        if (this.count == 0) {          //gelen yeni duğumu ilk elemansa basa ekle metodu çağrıldı
            this.basaEkle(yeni);
        } else if (bas.sayi > yeni.sayi) {//eğer gelen yeni duğumunun içindeki yaş değeri listenin başındaki
            this.basaEkle(yeni);            //düğümün yaş değerinden küçükse gelen yeni düğümü düğümün başına
        } //başa ekle metodu ile yerleştirildi.
        else {
            dugum tmp = bas;              //tmp bastan baslatılıp sonraki pointeri null olanada kadar düğüm içinde dolaşacak
            while (tmp.sonraki != null && tmp.sonraki.sayi < yeni.sayi) {//ayrıca tmpnin göstermiş olduğu düğümden bir sonraki düğümün 
                tmp = tmp.sonraki;                                           // içindeki yaş değişkenin yeni düğümünün yaş değişkeninden küçük mü
            }                                                              //şartı da gerekiyor                     
            if (tmp.sonraki == null) {  //eğer tmp son düğümü gelmişse ve sonraki pointeri nullı gösteriyorsa son pointeri 
                son = yeni;          //yeni isimli düğümü gösterecek
            }
            yeni.sonraki = tmp.sonraki;//yeni düğümünün sonraki pointeri eğer düğümlerin arasına yerleşecekse tmpnin sonraki pointerinin gösterdiği pointere bağlanır
            tmp.sonraki = yeni;        //ama eğer tmp en son düğümüme gelip sonraki pointeri null göstereceği için yeninin sonrakiside nullı gösterecek
            count++;                 //yeni araya yerleştirileceği için tmpnin bağlantısı önündeki düğümden kopartılıp yeniye bağlanacak   
        }
    }

    public dugum bastanSil() {
        if (this.count == 0) {
            return null;
        }
        dugum tmp = bas;
        bas = bas.sonraki;
        count--;
        return tmp;
    }

    public dugum sondanSil() {
        if (this.count == 0) {//eğer düğüm listesinde hiç eleman yoksa null değeri döndürülecek
            return null;
        }
        if (bas == son) {      //eğer düğümde tekbir eleman varsa baştan sil metodu ile tek eleman silinecek
            return bastanSil();
        }
        dugum tmp = bas;      //eğer birden fazla eleman varsa tmpnin sonraki pointeri son u gösterine kadar yürütülecek
        while (tmp.sonraki != son) {   //son u gösterdiği ana geldiğinde gecici pointerina son atılacak
            tmp = tmp.sonraki;       //tmpnin sonraki değeri null yapılacak ve son pointeri artık tmpyi gösterecek
        }
        dugum gecici = son;
        tmp.sonraki = null;
        son = tmp;
        count--;
        return gecici;
    }

    public dugum aradanSil(dugum gelen) {
        if (this.count == 0) {
            return null;
        }
        //if(bas.veri.ad==gelen.veri.ad && bas.veri.yas==gelen.veri.yas){
        if (bas.sayi == gelen.sayi) {
            return bastanSil();
        }
        dugum tmp = bas;
        dugum onceki = bas;
        //while(!(tmp.sonraki.veri.ad==gelen.veri.ad && tmp.veri.yas==tmp.veri.yas)){
        while (!(tmp.sayi == gelen.sayi)) {
            onceki = tmp;
            tmp = tmp.sonraki;
        }
        if (tmp == null) {
            return null;
        }
        onceki.sonraki = tmp.sonraki;
        dugum gecici = tmp;

        count--;
        return gecici;
    }

    public void listele() {
        dugum simdikiLink = bas;
        System.out.println("\t\t    =====================================================");
        System.out.println("\t\t    =              CIFT LISTENDEKI DUGUMLER             =");
        while (simdikiLink != null) {
            System.out.print("\t\t    "+simdikiLink.sayi);
            simdikiLink = simdikiLink.sonraki;
        }
        System.out.println("");
        System.out.println("\t\t    =====================================================");
    }

}
