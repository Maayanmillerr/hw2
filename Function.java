abstract class Function {
    public abstract double valueAt(double Xpoint);
    public abstract String toString();
    public abstract Function derivative();
    public double bisectionMethod(double a, double b, double epsilon) {
        double left= a;
        double right= b;
        while (right-left>epsilon){
            double mid = (left+right)/2;
            if (this.valueAt(left)*this.valueAt(mid)>0){
                left = mid;
            } else {
                right = mid;
            }
        }
        return ((left+right)/2);
    }
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a,b,Math.pow(10,-5));
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        Function currentFunction = this;
        double Xk = a;
        double XkPlusOne = 0;
        for (int k = 1; Math.abs(currentFunction.valueAt(k)) < epsilon; k++) {
            XkPlusOne = Xk - (currentFunction.valueAt(k) / currentFunction.derivative().valueAt(k));
        }
        return XkPlusOne;
    }

    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10, -5));
    }

    public double factorial(int k){
        double counter = 1;
        for (int i=1; i<=k; i++){
            counter = counter * i;
        }
        return counter;
    }

    public Function taylorPolynomial(int n) {
        double[] coeffs = new double[n + 1];
        if (this instanceof Constant) {
            return this;
        }
        Function function1 = this;
        for (int i = 0; i < n + 1; i++) {
            double coeff = function1.valueAt(0) * (1 / factorial(i));
            if (i % 2 != 0) {
                coeff *= -1; // Multiply by -1 for odd powers
            }
            coeffs[i] = coeff;
            function1 = function1.derivative();
        }
        Polynomial taylorPolynom = new Polynomial(coeffs);
        return taylorPolynom;
    }//  check this

}
