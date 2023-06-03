public class MultiProduct extends Function {
    Function[] functions;

    public MultiProduct(Function... functions) {
        this.functions = functions;
    }

    @Override
    public double valueAt(double Xpoint) {
        double yPoint = 1;
        for (int i = 0; i < functions.length; i++) {
            yPoint = yPoint * functions[i].valueAt(Xpoint);
        }
        return yPoint;
    }

    @Override
    public String toString() {
        String str = functions[0] + "";
        for (int i = 1; i < functions.length; i++) {
            str = str + " * " + functions[i].toString();
        }
        return "(" + str + ")";
    }

    @Override
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];

        for (int i = 0; i < functions.length; i++) {
            Function[] otherFunctions = new Function[functions.length - 1];
            int index = 0;
            for (int j = 0; j < functions.length; j++) {
                if (j != i) {
                    otherFunctions[index++] = functions[j];
                }
            }
            MultiProduct product = new MultiProduct(otherFunctions);
            derivatives[i] = new Product(functions[i].derivative(), product);
        }

        return new MultiSum(derivatives);
    }



}