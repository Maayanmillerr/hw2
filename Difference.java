public class Difference extends Function{
    Function function1;
    Function function2;
    public Difference(Function function1, Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double Xpoint) {
        return function1.valueAt(Xpoint) - function2.valueAt(Xpoint);
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " - " + function2.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function derivative = new Difference(function1.derivative(), function2.derivative());
        return derivative;
    }

}
