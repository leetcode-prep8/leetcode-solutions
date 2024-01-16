class Solution {
    private double pow(double x, int n) {
        if (n == 0)
            return 1.0;
        else if (n == 1)
            return x;
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        } else {
            return x * pow(x * x, n / 2);
        }
    }

    public double myPow(double x, int n) {
        if (x == 0.0)
            return x;
        double absVal = pow(x, n);
        if (n >= 0) {
            return absVal;
        } else {
            return 1.0 / absVal;
        }
    }
}