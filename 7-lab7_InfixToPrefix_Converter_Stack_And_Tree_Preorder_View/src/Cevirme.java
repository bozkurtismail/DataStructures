/**
 *
 * @author İsmail BOZKURT
 */
public class Cevirme {

    public Stack stack;
    public String giris;
    public String cikis = "";
    public int boyut;

    public Cevirme(String giris) {
        this.giris = giris;
        this.boyut = giris.length();
        stack = new Stack(boyut);
//      System.out.println("gelen giris:"+this.giris);
//      System.out.println("giris boyutu:"+this.boyut);

    }

    public String infixiCevirPrefixe() {
        for (int i = boyut - 1; i >= 0; i--) {
            char sembol = giris.charAt(i);
//            System.out.println("sembol degeri:"+sembol);
            switch (sembol) {
                case '+':
                case '-':
                    operator(sembol, 1, ')');
                    break;
                case '*':
                case '/':
                    operator(sembol, 2, ')');
                    break;
                case ')':
                    stack.push(sembol);
                    break;
                case '(':
                    parantez(')');
                    break;
                default:
                    cikis = sembol + cikis;
//                    System.out.println("CIKIS:" + cikis);
            }
        }
        while (!stack.isEmpty()) {
            cikis = stack.pop() + cikis;
        }
        return cikis;
    }

    private void operator(char sembol, int oncelik, char parantez) {
        while (!stack.isEmpty()) {
            char stackEnUstu = stack.pop();
//            System.out.println("stack son giren eleman:"+stackEnUstu);

            if (stackEnUstu == parantez) {
                stack.push(stackEnUstu);
                break;
            } else {
                int oncelik2;
                if (stackEnUstu == '+' || stackEnUstu == '-') {
                    oncelik2 = 1;
                } else {
                    oncelik2 = 2;
                }
                if (oncelik2 < oncelik && parantez == '(') {
                    stack.push(stackEnUstu);
                    break;
                } else if (oncelik2 <= oncelik && parantez == ')') {
                    stack.push(stackEnUstu);
                    break;
                } else {
                    if (parantez == ')') {
                        cikis = stackEnUstu + cikis;
                    } else {
                        cikis = cikis + stackEnUstu;
                    }
                }
            }
        }
        stack.push(sembol);
    }

    private void parantez(char deger) {
        while (!stack.isEmpty()) {
            char karakter = stack.pop();
//            System.out.println("karakter degeri:"+karakter);
            if (karakter == deger) {
                break;
            } else {
                if (deger == ')') {
                    cikis = karakter + cikis;
                } else {
                    cikis = cikis + karakter;
                }
            }
//            System.out.println("CIKIS:"+cikis);
        }
    }
}
