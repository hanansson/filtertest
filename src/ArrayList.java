import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;

import java.io.*;
import java.util.Collection;


public class ArrayList {

    java.util.ArrayList<String> gesamtEinträge = new java.util.ArrayList<String>();

    public static void main(String []args) throws IOException {
        new ArrayList();

    }

    public ArrayList() throws IOException {

        String zeile = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("filmdaten.txt"));

            while (br.ready()) {
                if ((zeile = br.readLine()) != null)
                    //System.out.println(zeile);
                    gesamtEinträge.add(zeile);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br1 = new BufferedReader(isr);
        System.out.print("Name: ");
        String eingabe = br1.readLine();

        Collection<String> suchergebnis1 = Collections2.filter(gesamtEinträge,
                Predicates.containsPattern(eingabe));
        System.out.println(suchergebnis1);
    }
}