
/**
 *
 * @author İsmail BOZKURT
 */
public class Tree {

    Node kok;
    String ifade;
    int boyut;

    public Tree(String giris) {
        this.kok = null;
        this.ifade = giris;
        this.boyut = ifade.length();
        ekle();
        listeleme(kok);
    }

    public void ekle() {
        for (int i = 0; i <= boyut - 1; i++) {
            char sembol = ifade.charAt(i);
            Node dugum = new Node(sembol);
            kok = this.ekle(kok, dugum, i);
        }
    }

    private Node ekle(Node kok, Node dugum, int sira) {
        switch (sira) {
            case 0:
                kok = dugum;
                break;
            case 1:
                kok.sol = dugum;
                break;
            case 2:
                kok.sol.sol = dugum;
                break;
            case 3:
                kok.sol.sag = dugum;
                break;
            case 4:
                kok.sag = dugum;
                break;
            case 5:
                kok.sag.sol = dugum;
                break;
            case 6:
                kok.sag.sag = dugum;
                break;
        }
        return kok;
    }

    public void listeleme(Node kok) {
        if (kok != null) {
            System.out.print(kok.deger + " ");
            listeleme(kok.sol);
            listeleme(kok.sag);
        }
        
    }

}
