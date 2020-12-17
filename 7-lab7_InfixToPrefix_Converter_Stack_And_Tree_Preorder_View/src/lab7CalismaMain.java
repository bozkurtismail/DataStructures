
import java.util.Scanner;

/**
 *
 * @author İsmail BOZKURT
 */
public class lab7CalismaMain {

    public static void main(String[] args) {
        String ifade;
        String cikti;

        Scanner input = new Scanner(System.in);

        System.out.print("Matematiksel ifadenizi infix seklinde giriniz:");
        ifade = input.next();
        //String ifade = "A+B*(C^D-E)";
        Cevirme cevirme = new Cevirme(ifade);

        System.out.println("          INFIX IFADENIZ");
        System.out.println("===================================");
        System.out.println("           " + ifade);

        cikti = cevirme.infixiCevirPrefixe();
        System.out.println("");
        System.out.println("          PREFIX IFADENIZ");
        System.out.println("===================================");
        System.out.println("             " + cikti);

        System.out.println("\n");
        System.out.println(" AGAC YERLESTIRME ISLEMI BASLIYOR.........");

        System.out.println("\n\n");
        System.out.println("     AGAC PREORDER GOSTERIM");
        System.out.println("===================================");
        Tree agac = new Tree(cikti);
        System.out.println("");

    }
}
