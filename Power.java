public class Power extends Function{
    Function function;
    double exp;
    public Power(Function function , double exp){
        this.function=function;
        this.exp = exp;
    }

    @Override
    public double valueAt(double Xpoint) {
        if (exp==0){
            return 1;
        }
        return  Math.pow(function.valueAt(Xpoint) , exp);
    }

    @Override
    public String toString() {
        int intExp = (int) Math.floor(exp);
        return "(" + function.toString() + "^" + intExp + ")";
    }

    @Override
    public Function derivative() {
        if (exp == 0){
            Function derivative = new Constant(0);
            return derivative;
        } else if (exp==1){
            return function.derivative();
        } else {
            Function firstDerivative = new Constant(exp);
            Function powerDerivative = new Power(function, exp-1);
            Function derivativeProduct = new MultiProduct(firstDerivative, powerDerivative, function.derivative());
            return derivativeProduct;
        }
    }

}