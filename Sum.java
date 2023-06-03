public class Sum extends Function {
    private Function function1;
    private Function function2;

    public Sum(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public String toString() {
        return "(" + function1.toString() + " + " + function2.toString() + ")";
    }

    @Override
    public double valueAt(double x) {
        return function1.valueAt(x) + function2.valueAt(x);
    }

    @Override
    public Function derivative() {
        Function derivative1 = function1.derivative();
        Function derivative2 = function2.derivative();
        Function derivative = new Sum(derivative1, derivative2);
        return derivative;
    }
}
