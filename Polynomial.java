public class Polynomial extends Function{
    final private double[] coefficients;
    Function function;
    public Polynomial(double... coefficients){
        this.coefficients= coefficients;
    }

    @Override
    public double valueAt(double Xpoint) {
        double counter=0;
        double[] coefficients = this.coefficients;
        for (int i=0; i<coefficients.length; i++){
            counter = counter + coefficients[i]*Math.pow(Xpoint,i);
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("(");
        boolean isFirstCoefficient = true;
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] == 0) {
                continue; // Skip if the coefficient is zero
            }
            double absCoefficient = Math.abs(coefficients[i]);
            int wholeNumber = (int) absCoefficient;
            double decimalNumber = absCoefficient - wholeNumber;

            if (isFirstCoefficient) {
                if (wholeNumber == 1 && coefficients[0]!=0){
                    str.append(wholeNumber);
                }
                isFirstCoefficient=false;
            } else {
                if (coefficients[i] > 0) {
                    str.append(" + ");
                } else {
                    str.append(" - ");
                }
            }

            if (decimalNumber == 0) {
                if (wholeNumber != 1) {
                    str.append(wholeNumber);
                }
            } else {
                str.append(absCoefficient);
            }

            if (i > 0) {
                str.append("x");
            }

            if (i > 1) {
                str.append("^").append(i);
            }
        }
        str.append(")");
        return str.toString();
    }


    @Override
    public Function derivative() {
        if (this.coefficients.length<=1){
            return new Constant(0);
        }
        double[] coefficientsForDeri = new double[(this.coefficients.length)-1];
        for (int i=0; i<coefficients.length-1; i++){
            coefficientsForDeri[i] = coefficients[i+1]*(i+1);
        }
        Function derivative = new Polynomial(coefficientsForDeri);
        return derivative;
    }

    @Override
    public double bisectionMethod(double a, double b, double epsilon) {
        double left= a;
        double right= b;
        while (right-left>epsilon){
            double mid = (left+right)/2;
            if (valueAt(left)*valueAt(mid)>0){
                left = mid;
            } else {
                right = mid;
            }
        }
        return ((left+right)/2);
    }
}

