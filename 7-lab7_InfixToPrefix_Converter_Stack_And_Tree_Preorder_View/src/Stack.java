
/**
 *
 * @author İsmail BOZKURT
 */
public class Stack {

    private char[] dizi;
    private int top;
    private int boyut;

    public Stack() {
    }

    public Stack(int boyut) {
        this.top = -1;
        this.boyut = boyut;
        this.dizi = new char[this.boyut];
    }

    public void push(char deger) {
        dizi[++top] = deger;
    }

    public char pop() {
        return (dizi[top--]);
    }

    public char sonEleman() {
        return (dizi[top]);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == boyut);
    }

}
