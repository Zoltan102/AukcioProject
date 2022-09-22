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

    public String getFesto(){
        return this.festo;
    }
    public String getStilus(){
        return this.stilus;
    }
    public int getLicitekSzama(){
        return licitekSzama;
    }
    public int getLegmagasabbLicit(){
        return legmagasabbLicit;
    }
    public LocalDateTime getLegutolsoLicitIdeje(){
        return legutolsoLicitIdeje;
    }
    public boolean getElkelt(){
        return elkelt;
    }
    public void setElkelt(boolean elkelt){
        this.elkelt = elkelt;
    }

    public void licit(){
        if (elkelt = true){
            System.out.println("A festmény már elkelt");
        }else{
            if (licitekSzama == 0){
                legmagasabbLicit = 100;
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            } else if (licitekSzama > 0) {
                legmagasabbLicit *= 1.1;
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            }

        }
    }
    public void licit(int mertek){
        if (elkelt = true){
            System.out.println("A festmény már elkelt");
        } else {

        }
    }

}
