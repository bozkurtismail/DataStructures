
import java.util.Comparator;
/**
 *
 * @author İsmail BOZKURT
 */
public class HuffmanNode {

    int deger;
    char karakter;

    HuffmanNode sol;
    HuffmanNode sag;
}

class Karsilastirmam implements Comparator<HuffmanNode> {

    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.deger - y.deger;
    }
}
