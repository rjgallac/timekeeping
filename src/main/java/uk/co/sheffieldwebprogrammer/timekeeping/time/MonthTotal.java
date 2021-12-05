package uk.co.sheffieldwebprogrammer.timekeeping.time;

public class MonthTotal {
    private String mth;
    private double expected;
    private double actual;

    public MonthTotal(String mth, double expected, double actual) {
        this.mth = mth;
        this.expected = expected;
        this.actual = actual;
    }

    public double getExpected() {
        return expected;
    }

    public double getActual() {
        return actual;
    }

    public String getMth() {
        return mth;
    }
}
