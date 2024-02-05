public class Main {
    public static void main(String[] args) {
        SpravceDeskovek spravceDeskovek = new SpravceDeskovek();
        Deskovka deskovka = new Deskovka("Člověče nezlob se", false, 1);
        spravceDeskovek.pridejDeskovku(deskovka);
        GUI gui = new GUI(spravceDeskovek);
        gui.setVisible(true);
    }
}