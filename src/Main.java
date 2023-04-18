import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj a:");
        int a = sc.nextInt();
        System.out.println("Podaj b:");
        int b = sc.nextInt();
        System.out.println("Podaj c:");
        int c = sc.nextInt();
        QuadratPoly qp = new QuadratPoly(a,b,c);
        qp.solutionQIe(Sign.GREATER);
    }
    private static void Description(QuadratPoly qp)
    {
        System.out.println("Opis: ");
        int delta = qp.sgnDelta();
        System.out.println(" 1. Dziedzina: Zbiór liczb rzeczywtistych");
        System.out.println(" 2. Zbiór wartości: "+qp.getCodomain());
        System.out.println(" 3. Monotoniczność: "+(qp.isAPositive() ? ("Funkcja maleje w przedziale: (-∞, "+qp.getP())+"⟩ "
                + "Funkcja rośnie w przedziale: ⟨"+qp.getP()+", +∞)": ("Funkcja rośnie w przedziale: ⟨"+qp.getP()+", +∞)"
                + "Funkcja maleje w przedziale: (-∞, "+qp.getP())+"⟩ "));
        System.out.println(" 4. Ekstremum: "+(qp.isAPositive() ? ("min= "+qp.getQ()) : ("max= "+qp.getQ())));
        System.out.print(" 5. Miejsca zerowe: ");
        if(delta<0) System.out.print("Brak miejsc zerowych.");
        if(delta==0) System.out.print("X: "+qp.getX1());
        if(delta>0) System.out.print("X1: "+qp.getX1()+" X2: "+qp.getX2());
    }
    private static void power4ThEquation(QuadratPoly qp)
    {
        if(qp.sgnDelta()>=0)
        {
            int sgnDelta = qp.sgnDelta();
            if(sgnDelta==0){
                if(qp.getX1()>0) System.out.println(Math.sqrt(qp.getX1())+" "+-Math.sqrt(qp.getX1()));
            } else if (sgnDelta>0) {
                if(qp.getX1()>0) System.out.print(Math.round(Math.sqrt(qp.getX1())*100.0)/100.0+" ∨ "+-Math.round(Math.sqrt(qp.getX1())*100.0)/100.0);
                if(qp.getX2()>0) System.out.print(" ∨ "+Math.round(Math.sqrt(qp.getX2())*100.0)/100.0+" ∨ "+-Math.round(Math.sqrt(qp.getX2())*100.0)/100.0);
            }
        }else{
            System.out.println("Brak rozwiązań");
        }
    }
}
