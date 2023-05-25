import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Aufgabe 1 Fehleranalyse
        // int arr[] = { 1 };

        int i = 0;
        // try, weil ich ahne hier könnte was schief gehen
        try {
            // hier passiert der Fehler
            System.out.println(i++);
            System.out.println("Dies hier wird nicht ausgegeben ...");
        } catch (ArithmeticException e) {
            System.out.println("Hier werden Sie behandelt :-)");
        } finally {
            System.out.print("Dies wird immer ausgegeben!");
        }

        try {
            PrintWriter pw = new PrintWriter(new File("srx//hallo.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Problem war: " + e.getMessage());
        }

        // Aufgabe 2 Checked und Unchecked Ausnahmen
        int y = 5, x = 0;
        try {
            if (x == 0) {
                throw new ArithmeticException();
            } else {
                y = 5 / x;
            }
        } catch (ArithmeticException e) {
            System.err.println("Teilen durch Null ist echt nicht ...");
        }

        try {
            throw new SQLException();
        } catch (SQLException e) {
            System.out.println("Auch SQL macht Fehler ...");
        }

        /* Checked vs Unchecked exception example
        try {
            Class.forName("com.mcnz.Example");
        } catch (ClassNotFoundException e) {
            System.out.println("Diese Klasse kann nicht erstellt werden ...");
        }

        String input = null;
        input.length(); // throws an unchecked exception
        */

        // Aufgabe 3 Behandlung von Ausnahmen (1)
        boolean notfinished = true;
        Scanner in = new Scanner(System.in);
        while (notfinished) {
            System.out.println("Geben Sie einen Dateinamen ein: ");
            String dateiname = in.next();
            try {
                Scanner intext = new Scanner(new File(dateiname));
                notfinished = false;
                System.out.println("TEXT IST: " + intext.nextLine());
            } catch (FileNotFoundException e) {
                System.out.println("FEHLER! Bitte gültigen Dateinamen angeben!");
            }
        }

        ElementPrinter ep = new ElementPrinter(new int[] {5,7,11,13});
        AnyPrinter ap = new AnyPrinter(ep);
        try {
            ap.printNextN(6);
        } catch (PrinterException e) {
            // e.printStackTrace();
            System.out.println(e.getClass().getName() + "::" + e.getMessage());
            System.err.println(e.getCause().getClass().getName() + "::" + e.getCause().getMessage());
        }

        /* Mehrfache Exceptions abfragen */
        try {
            boolean b = true;
            if (b) {
                throw new NullPointerException();
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            System.err.println("Dass war eine IOException!");
        } catch (NullPointerException e) {
            System.err.println("Das war eine NullPointerException!");
        }

        /* Mulit-Block-Exceptions */
        try {
            boolean c = true;
            if (c) {
                throw new NullPointerException();
            } else {
                throw new IOException();
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("Dass war eine IOException oder eine NullPointerException!");
        }

        System.out.println("Das hier ist das echte Programmende ...");

    }
}
