package es.onoguera.zopa.test.lenders;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CSVLenders {

    private Set<CSVLender> CSVLenders;

    public CSVLenders(String path) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(CSVLender.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        this.CSVLenders = new TreeSet<>(csvToBean.parse());
    }

    public List<CSVLender> getCSVLenders() {
        return new ArrayList<>(CSVLenders);
    }
}
