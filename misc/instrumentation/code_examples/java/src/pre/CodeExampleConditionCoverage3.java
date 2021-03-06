package pre;
///////////////////////////////////////////////////////////////////////////////
//
// $Id$
// 
// created by: Christoph Müller
// created at: 20.03.2007 09:48:50
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This is a code example to show how gbt² will instrument the source code. This
 * soure code files will be instrumented by hand.
 * 
 * @author Christoph Müller
 * @version 1.0 - 20.03.2007
 * 
 */
public class CodeExampleConditionCoverage3 {

    private static final double ALLOWED_MISTAKE = 1E-10;

    private int intervalCount = 10;

    private double left;

    private double right;

    private double exactIntegral;

    private IFunction function;

    public static void main(String[] args) {
        try {
            CodeExampleConditionCoverage3 cE = new CodeExampleConditionCoverage3();
            System.out.printf("Integral of sin function -"
                    + "approximated with trapezium rule%n%n");

            EApproxMode[] approxModes = EApproxMode.values();
            for (EApproxMode mode : approxModes) {
                cE.approx(mode);

                if (mode.ordinal() >= approxModes.length - 1)
                    continue;

                byte seperatorCount = 0;
                while (seperatorCount < 20) {
                    seperatorCount++;

                    if (seperatorCount < 20)
                        System.out.printf("#");
                    else
                        System.out.printf("%n");
                }
            }

        } catch (RuntimeException e) {
            System.out.printf("RuntimeException occured.");
        } catch (Exception e) {
            System.out.printf("Exception occured.");
        }
    }

    public CodeExampleConditionCoverage3() throws Exception {
        this.left = 0.0;
        this.right = Math.PI;
        this.intervalCount = ((this.right - this.left) > Math.PI ? 20 : 12);
        this.function = new SinFunction();

        if (!this.function.canBeUsed()) {
            throw new Exception("function not useable");
        }

        final long BIT00 = Long.parseLong("1", 2);
        final long BIT01 = Long.parseLong("10", 2);
        final long BIT02 = Long.parseLong("100", 2);
        final long BIT03 = Long.parseLong("1000", 2);
        final long BIT04 = Long.parseLong("10000", 2);
        final long BIT05 = Long.parseLong("100000", 2);

        long terms0001 = 0L;

        this.left = 0.0;

        boolean termResult0001 = ((((terms0001 |= BIT00) >= Long.MIN_VALUE) & this.left == 0.0) && ((terms0001 |= BIT01) >= Long.MIN_VALUE))
                && ((((terms0001 |= BIT02) >= Long.MIN_VALUE) & this.right == Math.PI) && ((terms0001 |= BIT03) >= Long.MIN_VALUE))
                || ((((terms0001 |= BIT04) >= Long.MIN_VALUE) & this.function instanceof SinFunction) && ((terms0001 |= BIT05) >= Long.MIN_VALUE));

        if (termResult0001) {
            this.exactIntegral = 2.0;
        } else if (((this.left == 0.0 & this.right == Math.PI / 2)
                | (this.left == 2 * Math.PI & this.right == Math.PI) || true)
                & this.function instanceof SinFunction) {
            this.exactIntegral = 1.0;
        } else {
            throw new Exception("unknown correct integral");
        }
    }

    public void approx(EApproxMode mode) {
        double approxIntegral;
        approxIntegral = 0.0;

        switch (mode.ordinal()) {
        case 0:
            System.out.printf("> fixed interval count:%n");
            break;
        case 1:
            System.out.printf("> with given precision%n");
            break;
        default:
            System.out.printf("> exact result%n");
            break;
        }

        switch (mode) {
        case FIXED_COUNT:
            System.out.printf("  %d intervals%n", new Integer(
                    this.intervalCount));
            approxIntegral = calcIntegral(this.left, this.right,
                    this.intervalCount, this.function);
            break;
        case PRECISION:
            int intervals = 1;
            double mistake;
            do {
                approxIntegral = calcIntegral(this.left, this.right, intervals,
                        this.function);
                mistake = Math.abs(this.exactIntegral - approxIntegral);

                System.out.printf("   %d intervals%n", new Integer(intervals));
                System.out.printf("   result %14.10f%n", new Double(
                        approxIntegral));
                System.out.printf("   mistake  %13.10G%n", new Double(mistake));

                intervals <<= 1;
            } while (mistake > ALLOWED_MISTAKE);
            break;
        case EXACT:
            approxIntegral = this.exactIntegral;
            break;
        }

        System.out.printf("  result: %14.10f%n%n", new Double(approxIntegral));
    }

    private static double calcIntegral(double left, double right,
            int intervalCount, IFunction function) {
        double result = 0.0;
        double h = (right - left) / intervalCount;

        result += function.getValue(left) / 2.0;
        for (int i = 1; i < intervalCount; i++) {
            result += function.getValue(left + i * h);
        }
        result += function.getValue(right) / 2.0;
        result *= h;

        return result;
    }

    private static class SinFunction implements IFunction {
        private boolean canBeUsed = true;

        public double getValue(double argument) {
            return Math.sin(argument);
        }

        public boolean canBeUsed() {
            return canBeUsed;
        }
    }

    public static interface IFunction {
        public double getValue(double argument);

        public boolean canBeUsed();
    }

    public enum EApproxMode {
        FIXED_COUNT, PRECISION, EXACT
    }
}
