import java.awt.print.PrinterException;

public class AnyPrinter {

    ElementPrinter ep;

    public AnyPrinter(ElementPrinter ep) {
        this.ep = ep;
    }

    public void printNextN(int n) throws PrinterException {
        try {
            while (n-- != 0)
                ep.printNext();
        } catch (ArrayIndexOutOfBoundsException e) {
            // e.printStackTrace();
            // System.out.println("Array-Problem ...")
            PrinterException pa = new PrinterException("Problem beim Durcken des letzten Zeichen " + (n + 1));
            // Exception-Wrapping
            pa.initCause(e);
            // Exception-Chaining --> Verketten von Exceptions
            throw pa; // Verschiebe die Fehlermeldung auf den Verwender
        }
    }
}
