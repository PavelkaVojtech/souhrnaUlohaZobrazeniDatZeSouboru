import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpravceDeskovek {
    private final ArrayList<Deskovka> seznamDeskovek = new ArrayList<>();
    public SpravceDeskovek() {
        cteniZeSouboru();
    }
    private void cteniZeSouboru() {
        try (
                FileReader fileReader = new FileReader("Deskovky.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                Scanner scanner = new Scanner(bufferedReader);
        )

        {
            while (scanner.hasNextLine()) {
                String radek = scanner.nextLine();
                String[] pole = radek.split(";");
                String nazev = pole[0];
                boolean zakoupeno = false;
                if (pole[1].equals("ano")){
                    zakoupeno = true;
                }
                int oblibenost = Integer.parseInt(pole[2]);
                seznamDeskovek.add(new Deskovka(nazev, zakoupeno, oblibenost));
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void pridejDeskovku(Deskovka deskovka) {
        seznamDeskovek.add(deskovka);
    }
    public Deskovka getDeskovka(int index) {
        return seznamDeskovek.get(index);
    }

    public int getPocetDeskovek() {
        return seznamDeskovek.size();
    }
}