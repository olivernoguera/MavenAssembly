package es.onoguera.zopa.test;

import es.onoguera.zopa.test.lenders.CSVLender;
import es.onoguera.zopa.test.lenders.CSVLenders;
import es.onoguera.zopa.test.utils.NumberUtils;

import java.io.IOException;

import static java.lang.System.exit;

public class ZopaTest {

    private final static Integer ARGS_SIZE = 2;

    public static void main(String[] args) throws IOException {
        if (args.length != ARGS_SIZE) {
            System.out.println("Args must be lenght " + ARGS_SIZE);
            exit(-1);
        }
        String path = args[0];
        CSVLenders csvLenders = new CSVLenders(path);
        for (CSVLender csvLender : csvLenders.getCSVLenders()) {
            System.out.println(csvLender);
        }

        if (NumberUtils.isPositiveInteger(args[1])) {
            Integer value = Integer.parseInt(args[1]);
            System.out.println(value);
        }
        exit(0);
    }
}