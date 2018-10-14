//Michał Sławiński 246803
//zad1- sumowanie szeregów potęgowych

package zad01;

import static zad01.Tests.*;
public class Main {

    public static void main(String[] args) {
        taylorTest();
    }

    //funkcja sin(x)*ln(1+x); -1 < x <= 1
    //wzory wziete z http://people.math.sc.edu/girardi/m142/handouts/10sTaylorPolySeries.pdf

    //bezpośrednio ze wzoru Taylora, od początku
    protected static double taylorSeries1(double x, int sumElems) {
        double lnResult = 0;
        double sinResult = 0;

        for(int n=1; n<=sumElems; n++) {
            lnResult += (power(-1, n+1)*power(x, n))/n;
            sinResult += (power(-1, n-1)*power(x, (2*n)-1))/factorial((2*n)-1);
        }
        return lnResult*sinResult;
    }

    //bezpośrednio ze wzoru Taylora, od końca
    protected static double taylorSeries2(double x, int sumElems) {
        double lnResult = 0;
        double sinResult = 0;

        for(int n=sumElems; n>=1; n--) {
            lnResult += (power(-1, n+1)*power(x, n))/n;
            sinResult += (power(-1, n-1)*power(x, (2*n)-1))/factorial((2*n)-1);
        }
        return lnResult*sinResult;
    }


    //funkcje matematyczne:
    private static double power(double base, int index) {
        if(index == 0) return 1;

        double result = base;

        for(int i = 1; i < index; i++) {
            result *= base;
        }
        return result;
    }

    private static long factorial(int num) {
        long result = 1;
        for(int i = num; i > 0; i--) {
            result *= i;
        }
        return result;
    }

}
