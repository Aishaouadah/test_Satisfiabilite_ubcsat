package com.company;
import java.io.File;
import java.io.IOException;

import static com.company.inference.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file_cnf = new File("test1.cnf");
        int literrale =4;
        addClause(file_cnf, literrale);
        updateFile(file_cnf);
        testerSat(file_cnf);
            }
        }



