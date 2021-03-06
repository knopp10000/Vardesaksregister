//Karl Gustafsson 19990507-1313
public class Aktie extends Värdesak{

    private int antal, kurs;

    Aktie(String namn, int antal, int kurs) {
        super(namn);
        this.antal = antal;
        this.kurs = kurs;
    }

    public double getValue(){
        value = antal*kurs;
        return super.getValue();
    }

    public void setKurs(int kurs){
        this.kurs = kurs;
    }

    @Override
    public String toString() {
        return super.toString() + " antal: " + antal + " kurs: " + kurs;
    }
}
