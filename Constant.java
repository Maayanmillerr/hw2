public class Constant extends Function{
    private double c;
    public Constant(double c){
        this.c = c;
    }

    @Override
    public double valueAt(double Xpoint) {
        return this.c;
    }

    public boolean isWholeNumber(double number) {
        // Compare the double value with its integer representation
        return number == (int) number;
    }

    @Override
    public String toString() {
        if (isWholeNumber(c)) {
            return "(" + String.valueOf((int) c) + ")";
        } else {
            return "(" + String.valueOf(c) + ")";
        }
    }

    @Override
    public Function derivative() {
        return new Constant(0);
    }


}
