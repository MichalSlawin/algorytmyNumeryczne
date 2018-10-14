//Michał Sławiński 246803
//zad1- sumowanie szeregów potęgowych

package zad01;

import java.util.ArrayList;
import java.util.List;

import static zad01.Tests.*;
public class Main {

    public static void main(String[] args) {
        taylorTest("output1.csv", 1, 30);
        taylorTest("output2.csv", 2, 30);
        taylorTest("output3.csv", 3, 50);
        taylorTest("output4.csv", 4, 50);

        taylorTest("output1_15.csv", 1, 15);
        taylorTest("output2_15.csv", 2, 15);
        taylorTest("output3_15.csv", 3, 25);
        taylorTest("output4_15.csv", 4, 25);
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

    //obliczając kolejny wyraz z poprzedniego, od początku
    protected static double taylorSeries3(double x, int sumElems) {
        double lnResult = x;
        double sinResult = x;
        double lnTemp = x;
        double sinTemp = x;

        for(int n=1; n<=sumElems; n++) {
            lnTemp *= (((-x)*n)/(n+1));
            sinTemp *= (((-1)*power(x,2))/((2*n)*((2*n)+1)));
            lnResult += lnTemp;
            sinResult += sinTemp;
        }
        return lnResult*sinResult;
    }

    //obliczając kolejny wyraz z poprzedniego, od końca
    protected static double taylorSeries4(double x, int sumElems) {
        List<Double> lnResultList = new ArrayList<Double>();
        List<Double> sinResultList = new ArrayList<Double>();

        double lnResult = x;
        double sinResult = x;
        double lnTemp = x;
        double sinTemp = x;

        for(int n=1; n<=sumElems; n++) {
            lnTemp *= (((-x)*n)/(n+1));
            sinTemp *= (((-1)*power(x,2))/((2*n)*((2*n)+1)));

            lnResultList.add(lnTemp);
            sinResultList.add(sinTemp);
        }
        for(int n=sumElems; n>=1; n--) {
            lnResult += lnResultList.get(lnResultList.size()-1);
            lnResultList.remove(lnResultList.size()-1);

            sinResult += sinResultList.get(sinResultList.size()-1);
            sinResultList.remove(sinResultList.size()-1);
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
