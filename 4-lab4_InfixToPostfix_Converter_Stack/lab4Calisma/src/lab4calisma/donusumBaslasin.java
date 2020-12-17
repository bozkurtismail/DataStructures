package lab4calisma;
/**
 *
 * @author İsmail BOZKURT
 */
public class donusumBaslasin {

    Stack operator;
    String[] dizi;
    String cikis = "";
    int count;

    public donusumBaslasin() {
    }

    public donusumBaslasin(String[] gelenDizi) {
        int boyut = gelenDizi.length;
        dizi = new String[boyut];
        dizi = gelenDizi;
        this.operator = new Stack(boyut);
    }

    public String InfixCevirPostfix() {

        for (int i = 0; i < dizi.length; i++) {
            char karakter = dizi[i].charAt(i);
            switch (karakter) {
                case '+':
                case '-':
                    operatorKontrolu(karakter, 1, '(');
                    break;
                case '*':
                case '/':
                    operatorKontrolu(karakter, 2, '(');
                    break;
                case '(':
                    operator.push(karakter);
                    break;
                case ')':
                    parantezKontrolu('(');
                    break;
                default:
                    cikis = cikis + karakter;
            }
        }
        while (!operator.bosMu()) {
            cikis = cikis + operator.pop();
        }
        return cikis;
    }

    private void operatorKontrolu(char gelen, int deger1, char x) {
        while (!operator.bosMu()) {
            char sondaki = operator.pop();
            if (sondaki == x) {
                operator.push(sondaki);
                break;
            } else {
                int deger;
                if (sondaki == '+' || sondaki == '-') {
                    deger = 1;
                } else {
                    deger = 2;
                }
                if (deger < deger1 && x == '(') {
                    operator.push(sondaki);
                    break;
                } else if (deger <= deger1 && x == ')') {
                    operator.push(sondaki);
                    break;
                } else {
                    if (x == ')') {
                        cikis = sondaki + cikis;
                    } else {
                        cikis = cikis + sondaki;
                    }
                }
            }
        }
        operator.push(gelen);
    }

    public void parantezKontrolu(char x) {
        while (!operator.bosMu()) {
            char karakter = operator.pop();
            if (karakter == x) {
                break;
            } else {
                if (x == ')') {
                    cikis = karakter + cikis;
                } else {
                    cikis = cikis + karakter;
                }
            }
        }
    }

}
