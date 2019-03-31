package sample;

public class Aktie extends Värdesak{

    private int antal, kurs;

    Aktie(String namn, int antal, int kurs) {
        super(namn);
        this.antal = antal;
        this.kurs = kurs;
    }

    double getValue(){
        value = antal*kurs;
        return super.getValue();
    }

    void setKurs(int kurs){
        this.kurs = kurs;
    }

    @Override
    public String toString() {
        return (super.namn + " värde: " + getValue() + " antal: " + antal + " kurs: " + kurs) ;
    }
}
