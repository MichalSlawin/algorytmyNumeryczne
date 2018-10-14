package zad01;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static zad01.Main.*;

public class Tests {

    protected static void taylorTest(String fileName, int algNumber, int sumElems) {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        double diff, fun, lib;

        for(double x = -0.999999; x <= 1; x += 0.000001) {

            if(algNumber == 1) fun = taylorSeries1(x, sumElems);
            else if(algNumber == 2) fun = taylorSeries2(x, sumElems);
            else if(algNumber == 3) fun = taylorSeries3(x, sumElems);
            else if(algNumber == 4) fun = taylorSeries4(x, sumElems);
            else fun = 0;

            lib = Math.sin(x) * Math.log(1 + x);
            diff = fun - lib;

            if (writer != null) {
                //writer.print(fun + ", ");
                //writer.print(lib + ", ");
                writer.print(x + ",");
                writer.print(Math.abs(diff) + ",");
                writer.println();
            }
        }
        writer.close();
    }

}
