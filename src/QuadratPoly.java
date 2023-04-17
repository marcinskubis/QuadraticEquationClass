public class QuadratPoly {
    private int a;
    private int b;
    private int c;
    private int delta;
    //region Getters
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public int getC() {
        return c;
    }
    public double getX1()
    {
        if(sgnDelta()==0){
            return (double)(-b / 2 * a);
        }
        else{
            return Math.round(((-b-Math.sqrt(getDelta()))/2*a)*100.0)/100.0;
        }
    }
    public double getX2()
    {
        if(sgnDelta()==0){
            return (double)(-b/2*a);
        }
        else{
            return Math.round(((-b+Math.sqrt(getDelta()))/2*a)*100.0)/100.0;
        }
    }
    public int getDelta()
    {
        return delta;
    }
    public double getP()
    {
        return (double)-b/(double)(2*a);
    }
    public double getQ()
    {
        return (double)-getDelta()/(double)(4*a);
    }
    public String getVertex()
    {
        return "("+getP()+", "+getQ()+")";
    }
    public String getCodomain()
    {
        return (isAPositive() ? ("⟨"+getQ()+",+∞)") : ("(-∞, "+getQ()+"⟩"));
    }
    //endregion
    //region Conctructors
    public QuadratPoly(int a, int b, int c)
    {
        if(a!=0)
        {
            this.a=a;
            this.b=b;
            this.c=c;
            this.delta=(int)Math.pow(b,2)-4*a*c;
        }
        else{
            System.out.println("To nie jest trójmian kwadratowy");
        }
    }
    //endregion
    //region Methods
    public double value(int x)
    {
        return (a * Math.pow(x,2))+(b*x)+c;
    }
    public String toString()
    {
        String aa;
        if(a==-1)
        {
            aa="-";
        } else if (a==1) {
            aa="";
        } else {
            aa=String.valueOf(a);
        }
        return aa + "x^2" + (b>0 ? "+": "") + (b==1 ? "" : b) + "x" + (c>0 ? "+":"") + c;
    }
    public int sgnDelta()
    {
        return Integer.compare(delta, 0);
    }
    public QuadratPoly add(QuadratPoly qp)
    {
        return new QuadratPoly(a+qp.getA(),b+qp.getB(),c+qp.getC());
    }
    public QuadratPoly sub(QuadratPoly qp)
    {
        return new QuadratPoly(a-qp.getA(),b-qp.getB(),c-qp.getC());
    }
    public boolean isAPositive()
    {
        return a > 0;
    }
    public QuadratPoly mult(int multiplier)
    {
        if(multiplier!=0) return new QuadratPoly(a*multiplier,b*multiplier,c*multiplier);
        else{
            return null;
        }
    }
    public String solutionOfQE()
    {
        int delta = getDelta();
        if(delta<0) System.out.print("{}");
        if(delta==0) System.out.print("{"+getX1()+"}");
        if(delta>0) System.out.print("{"+getX1()+", "+getX2()+"}");
        return "";
    }
    private String solutionQIe1()
    {
        String result = "";
        int sgnDelta= sgnDelta();
        if(sgnDelta>0){
            if(isAPositive()) result+="x∈(-∞, "+getX1()+") ∪ ("+getX2()+", ∞)";
            else{
                result+="x∈("+getX1()+", "+getX2()+")";
            }
        } else if (sgnDelta==0) {
            if(isAPositive()) result+="x∈R\\{"+getX1()+"}";
            else{
                result+="x∈∅";
            }
        } else{
            if(isAPositive()) result+="x∈R";
            else{
                result+="x∈∅";
            }
        }
        return result;
    }
    private String solutionQIe2()
    {
        String result = "";
        int sgnDelta= sgnDelta();
        if(sgnDelta>0){
            if(isAPositive()) result+="x∈(-∞, "+getX1()+"⟩ ∪ ⟨"+getX2()+", ∞)";
            else{
                result+="x∈⟨"+getX1()+", "+getX2()+"⟩";
            }
        } else if (sgnDelta==0) {
            if(isAPositive()) result+="x∈R";
            else{
                result+="x="+getX1();
            }
        } else{
            if(isAPositive()) result+="x∈R";
            else{
                result+="x∈∅";
            }
        }
        return result;
    }
    public String solutionQIe(Sign s)
    {
        String inSign = s.getBody();
        return switch (inSign) {
            case ">" -> solutionQIe1();
            case ">=" -> solutionQIe2();
            case "<" -> this.mult(-1).solutionQIe1();
            case "<=" -> this.mult(-1).solutionQIe2();
            default -> "Zły operator";
        };
    }
    //endregion

}
