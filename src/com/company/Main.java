package com.company;
import java.io.File;
import java.io.IOException;

import static com.company.inference.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file_cnf = new File("test1.cnf");
        int literrale =3;
        int n= updateFile(file_cnf);
        System.out.println("n= "+n);
        File file2_cnf = new File("test2.cnf");
        addClause(file2_cnf, literrale,n);
        testerSat(file_cnf);
            }
        }



