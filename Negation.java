public class Negation extends Function{
    Function function;
    public Negation(Function function){
        this.function = function;
    }

    @Override
    public double valueAt(double Xpoint) {
        return -(function.valueAt(Xpoint));
    }

    @Override
    public String toString() {
        return "(-" + function.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function derivative = new Negation(function.derivative());
        return derivative;
    }

}

