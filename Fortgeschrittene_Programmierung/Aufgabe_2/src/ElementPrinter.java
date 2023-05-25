public class ElementPrinter {

    public void printNext () {
    }

    int [] liste;
    int next;

    public ElementPrinter (int[] liste) {
        // bei Indexüberschreitung tritt HIER der Fehler auf
        System.out.println(liste[next++]);
    }
}
