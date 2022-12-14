import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static List<Festmeny> festmenyek;

    public static void main(String[] args) {
        //System.out.println(felhasznaloBevitel());
        try {
            readInFile();
        } catch (FileNotFoundException e) {
            System.err.println("Nem található a fájl!");
        } catch (IOException e) {
            System.err.println("Hiba történt a fájl beolvasása közben!");
        }
        randomLicit();
        felhasznaloLicit();
        osszesElkelt();
        for (Festmeny f : festmenyek) {
            System.out.println(f);
        }
    }

    public static List<Festmeny> felhasznaloBevitel() {
        List<Festmeny> festmenyek = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Hány darab festményt szeretne hozzáadni?");
        int festmenyekSzama = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < festmenyekSzama; i++) {
            System.out.print("\nAdja meg a festmények adatait (cim,festo,stilus)");
            String tmp = sc.nextLine();
            String[] splited = tmp.split(",");
            Festmeny f = new Festmeny(splited[0], splited[1], splited[2]);
            festmenyek.add(f);
        }
        return festmenyek;
    }

    public static void readInFile() throws IOException {
        FileReader fr = new FileReader("festmenyek.csv");
        festmenyek = new ArrayList<>();
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null) {
            String[] splitted = sor.split(";");
            Festmeny f = new Festmeny(splitted[1], splitted[0], splitted[2]);
            festmenyek.add(f);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    public static void randomLicit() {
        Random rnd = new Random();
        for (int i = 0; i < 20; i++) {
            festmenyek.get(rnd.nextInt(festmenyek.size())).licit();
        }
    }

    public static void felhasznaloLicit() {
        boolean wantToQuit = false;
        while (!wantToQuit) {
            System.out.println("Adja meg a festmény sorszámát: ");
            Scanner sc = new Scanner(System.in);
            int index = 0;
            try {
                index = (Integer.parseInt(sc.nextLine()) - 1);
            } catch (NumberFormatException e) {
                System.out.println("Nem számot írt be.");
                System.exit(0);
            }
            //festmenyek.get(index).eladva();
            if (index == -1) {
                wantToQuit = true;
            } else if (index >= festmenyek.size()) {
                System.out.println("Nem létező festmény sorszámot adtál meg. Festmények összege: " + festmenyek.size());
            } else if (festmenyek.get(index).getElkelt()) {
                System.out.println("A festmény már elkelt válasszon másikat!");
            } else {
                int licit = 0;
                try {
                    licit = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Nem számot írt be.");
                    System.exit(0);
                }
                if (licit == 0) {
                    festmenyek.get(index).licit();
                } else {
                    festmenyek.get(index).licit(licit);
                }
            }
        }
    }

    public static void osszesElkelt() {
        for (Festmeny f : festmenyek) {
            if (f.getLegmagasabbLicit() > 0) {
                f.setElkelt(true);
            }
        }
    }
}