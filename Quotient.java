public class Quotient extends Function{
    Function function1;
    Function function2;

    public Quotient(Function function1, Function function2){
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double Xpoint) {
        return function1.valueAt(Xpoint) / function2.valueAt(Xpoint);
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " / " + function2.toString() + ")";
    }

    @Override
    public Function derivative() {
        Function numeratorDerivative = new Difference(new Product(function1.derivative(), function2),
                new Product(function1, function2.derivative()));
        Function denominatorDerivative = new Power(function2, 2);
        Function derivative = new Quotient(numeratorDerivative, denominatorDerivative);
        return derivative;
    }

}