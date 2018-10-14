package zad01;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static zad01.Main.taylorSeries1;

public class Tests {
    protected static void taylorTest() {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("output1.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        double diff, fun, lib;

        for(double x = -0.999999; x <= 1; x += 0.000001) {

            fun = taylorSeries1(x, 30);
            lib = Math.sin(x) * Math.log(1 + x);
            diff = fun - lib;

            if (writer != null) {
                writer.print("fun: " + fun);
                writer.print(" lib: " + lib);
                writer.print(" diff:" + diff);
                writer.println();
            }
        }
        writer.close();
    }
}
