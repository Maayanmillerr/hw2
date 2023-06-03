public class MultiSum extends Function{
    protected Function[] functions;
    public MultiSum(Function... functions) {
        this.functions= functions;
    }

    @Override
    public double valueAt(double Xpoint) {
        double yPoint = 0;
        for (int i=0; i<functions.length; i++){
            yPoint += functions[i].valueAt(Xpoint);
        }
        return yPoint;
    }

    @Override
    public String toString() {
        StringBuilder multySum = new StringBuilder("(");
        for (int i = 1; i < functions.length; i++) {
            multySum.append(functions[i]);
            if (i < multySum.length() - 1) {
                multySum.append(" + ");
            }
            multySum.append(")");
        }
        return multySum.toString();

    }

    @Override
    public Function derivative() {
        Function[] derivativeMulti = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            derivativeMulti[i] = functions[i].derivative();
        }
        return new MultiSum(derivativeMulti);
    }



}
