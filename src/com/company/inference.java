package com.company;
import java.io.*;
/*
   un fichier  -> add to last clause (literalle )
   modify l'entete or replace nbclause+1
   execute cmd
    */
public class inference {
    static void addClause(File f, int litteral) throws IOException {
       Writer file = new BufferedWriter(new FileWriter(f.getName(), true));
       file.write("\n");
        litteral=litteral*-1;
       String NonBut = String.valueOf(litteral);
       NonBut = NonBut+" 0";
        file.append(NonBut);
       file.close();
    }
    static void updateFile(File f) throws IOException {

        File inputFile = new File("test1.cnf");
        File tempFile = new File("test2.cnf");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        Writer file = new BufferedWriter(new FileWriter("test2.cnf", true));
        //copy all expect toDelete
        String toDelete ="p cnf 5 11";
        file.write("p cnf 5 12\n");
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            // trim newline when comparing with lineToRemove
            String trimmedLine = currentLine.trim(); System.out.println( "trimmedLine ="+trimmedLine);
            if(trimmedLine.equals(toDelete)) continue;
            file.write(currentLine + System.getProperty("line.separator"));
        }
        file.close();
    }
    //tester le nv fichier
    static void testerSat(File file) throws IOException {
        try
        {
            String cmd ="ubcsat -alg saps -i test2.cnf -solve";
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec(cmd);

            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
            // Read the output from the command
            System.out.println("Here is the standard output of the command:");
            String s;
            while ((s = stdInput.readLine()) != null) {
                if(s.equals("# No Solution found for -target 0")) System.out.println("NON SAT");
                if(s.equals("Solution found for -target 0")) System.out.println("SAT");
            }

            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch(IOException e)
        {
            System.err.println("echec de l'execution du script: "+e);
            System.exit(1);
        }
    }
}
