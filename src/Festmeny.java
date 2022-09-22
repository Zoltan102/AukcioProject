import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.elkelt = false;
    }

    public String getFesto() {
        return this.festo;
    }

    public String getStilus() {
        return this.stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit() {
        if (elkelt = true) {
            System.out.println("A festmény már elkelt");
        } else {
            if (licitekSzama == 0) {
                legmagasabbLicit = 100;
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            } else if (licitekSzama > 0) {
                licit(10);
            }

        }
    }

    public void licit(int mertek) {
        if (elkelt = true) {
            System.out.println("A festmény már elkelt");
        } else {
            if (mertek >= 10 && mertek <= 100) {
                legmagasabbLicit += (legmagasabbLicit / 100) * mertek;
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            } else {
                System.out.println("Hibás adat! Csak 10 és 100 közötti szám fogadtható el.");
            }
        }
    }

    @Override
    public String toString() {
        if (elkelt = true) {
            return String.format("%s: %s (%s)\nelkelt\n%d $ - %t (összesen: %d db)", festo, cim, stilus, legmagasabbLicit, legutolsoLicitIdeje, licitekSzama);
        }
        return String.format("%s: %s (%s)\n%d $ - %t (összesen: %d db)", festo, cim, stilus, legmagasabbLicit, legutolsoLicitIdeje, licitekSzama);
    }
}
