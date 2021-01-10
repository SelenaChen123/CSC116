/** 
 * This program represents a fraction with an integer numerator and denominator with methods to get
 * the denominator, get the numerator, convert to String, check whether one number equals another,
 * and perform operations
 *
 * @author Ayushi Verma
 * @author Selena Chen
 */
public class RationalNumber {
    /** numerator of the rational number */
    private int numerator;
    /** denominator of the rational number */
    private int denominator;

    /**
     * Constructs a new rational number to represent the ratio (numerator/denominator)
     *
     * @param numerator numerator
     * @param denominator denominator
     */
    public RationalNumber(int numerator, int denominator) {
        if(denominator != 0) {
            this.numerator = numerator;
            if(denominator < 0) {
                this.numerator = 0 - numerator;
                this.denominator = 0 - denominator;
            } else {
                this.denominator = denominator;
            }
            int gcd = 1;
            int temp = 0;
            int num = this.numerator;
            int denom = this.denominator;
            if(num < 0) {
                num = 0 - num;
            }
            while(denom != 0) {
                temp = num;
                num = denom;
                denom = temp % num;
            }
            gcd = num;
            this.numerator /= num;
            this.denominator /= num;
        } else {
            throw new IllegalArgumentException("Denominator is 0");
        }
    }
    
    /**
     * Constructs a new rational number to represent the ratio (0/1)
     */
    public RationalNumber() {
        numerator = 0;
        denominator = 1;
    }
    
    /**
     * Returns this rational number’s denominator value
     *
     * @return denominator
     */
    public int getDenominator() {
        return denominator;
    }
    
    /**
     * Returns this rational number’s numerator value
     *
     * @return numerator
     */
    public int getNumerator() {
        return numerator;
    }
    
    /**
     * Returns a String representation of this rational number
     *
     * @return string
     */
    public String toString() {
        String num = "" + numerator;
        String denom = "" + denominator;
        if(denom.equals("1")){ 
            return num;
        } else {
            return num + "/" + denom;
        }
    }

    /**
     * Returns true if this and other are equivalent RationalNumbers
     *
     * @param other object being compared to
     * @return true or false
     */
    public boolean equals(Object other) {
        if(other instanceof RationalNumber) {
            RationalNumber n = (RationalNumber) other;
            return numerator == n.getNumerator()
                    && denominator == n.getDenominator();
        } else {
            return false;
        }
    }

    /**
     * Returns rational number that is this + other
     *
     * @param other rational number being added
     * @return answer added rational numbers
     */
    public RationalNumber add(RationalNumber other) {
        if(this.denominator == 0) {
            throw new IllegalArgumentException("Denominator is 0");
        }
        int num = 0;
        int denom = 1;
        if (this.denominator == other.getDenominator()) {
            num = this.numerator + other.getNumerator();
            denom = this.denominator;
            int gcd = 0;
            int temp = 0;
            int tempNum = num;
            int tempDenom = denom;
            if(tempNum < 0) {
                tempNum = 0 - tempNum;
            }
            while(tempDenom != 0) {
                temp = tempNum;
                tempNum = tempDenom;
                tempDenom = temp % tempNum;
            }
            gcd = tempNum;
            num /= gcd;
            denom /= gcd;
            RationalNumber answer = new RationalNumber(num, denom);
            return answer;
        } else {
            int gcd = 0;
            int temp = 0;
            int tempNum1 = this.numerator * other.getDenominator();
            int tempNum2 = this.denominator * other.getNumerator();
            num = tempNum1 + tempNum2;
            tempNum1 = tempNum1 + tempNum2;
            int tempDenom = this.denominator * other.getDenominator();
            if(tempNum1 < 0) {
                tempNum1 = 0 - tempNum1;
            }
            while(tempDenom != 0) {
                temp = tempNum1;
                tempNum1 = tempDenom;
                tempDenom = temp % tempNum1;
            }
            gcd = tempNum1;
            num /= gcd;
            tempDenom /= gcd;
            denom = tempDenom;
            RationalNumber answer = new RationalNumber(num, denom);
            return answer;
        }
    }

    /**
     * Returns rational number that is this - other
     *
     * @param other rational number being subtracted
     * @return answer subtracted rational numbers
     */
    public RationalNumber subtract(RationalNumber other) {
        if(this.denominator == 0) {
            throw new IllegalArgumentException("Denominator is 0");
        }
        int num = 0;
        int denom = 1;
        if (this.denominator == other.getDenominator()) {
            num = this.numerator - other.getNumerator();
            denom = this.denominator;
            int gcd = 0;
            int temp = 0;
            int tempNum = num;
            int tempDenom = denom;
            if(tempNum < 0) {
                tempNum = 0 - tempNum;
            }
            while(tempDenom != 0) {
                temp = tempNum;
                tempNum = tempDenom;
                tempDenom = temp % tempNum;
            }
            gcd = tempNum;
            num /= gcd;
            denom /= gcd;
            RationalNumber answer = new RationalNumber(num, denom);
            return answer;
        } else {
            int gcd = 0;
            int temp = 0;
            int tempNum1 = this.numerator * other.getDenominator();
            int tempNum2 = this.denominator * other.getNumerator();
            num = tempNum1 - tempNum2;
            tempNum1 = tempNum1 - tempNum2;
            int tempDenom = this.denominator * other.getDenominator();
            if(tempNum1 < 0) {
                tempNum1 = 0 - tempNum1;
            }
            while(tempDenom != 0) {
                temp = tempNum1;
                tempNum1 = tempDenom;
                tempDenom = temp % tempNum1;
            }
            gcd = tempNum1;
            num /= gcd;
            tempDenom /= gcd;
            denom = tempDenom;
            RationalNumber answer = new RationalNumber(num, denom);
            return answer;
        }
    }

    /**
     * Returns rational number that is this * other
     *
     * @param other rational number being multiplied
     * @return answer multiplied rational numbers
     */
    public RationalNumber multiply(RationalNumber other) {
        int denom = this.denominator * other.getDenominator();
        int num = this.numerator * other.getNumerator();
        int c = Math.min(num, denom);
        while (c > 0) {
            if (num % c == 0 && denom % c == 0) {
                num = num / c;
                denom = denom / c;
                c--;
            } else {
                c--;
            }
        }
        RationalNumber answer = new RationalNumber(num, denom);
        return answer;
    }

    /**
     * Returns rational number that is this / other
     *
     * @param other rational number being divided
     * @return answer divided rational numbers
     */
    public RationalNumber divide(RationalNumber other) {
        int denom = this.denominator * other.getNumerator();
        int num = this.numerator * other.getDenominator();
        int c = Math.min(num, denom);
        while (c > 0) {
            if (num % c == 0 && denom % c == 0) {
                num = num / c;
                denom = denom / c;
                c--;
            } else {
                c--;
            }
        }
        RationalNumber answer = new RationalNumber(num, denom);
        return answer;
    }
}
