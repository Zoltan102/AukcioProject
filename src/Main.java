import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(felhasznaloBevitel());
    }
    public static List<Festmeny> felhasznaloBevitel(){
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
    public
}