package lab4calisma;
/**
 *
 * @author İsmail BOZKURT
 */
public class Stack {

    char[] a;
    int count, boyut ;

    public Stack(int max) {
        this.boyut = max;
        this.a = new char[boyut];
        this.count = -1;
    }

    public void push(char deger) {
        a[++count] = deger;
    }

    public char pop() {
        return (a[count--]);
    }

    public char diziyeBak() {
        return (a[count]);
    }

    public boolean bosMu() {
        return (count == -1);
    }

}
