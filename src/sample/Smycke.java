package sample;

public class Smycke extends Värdesak{

    private int antalÄdelstenar;
    private boolean avGuld;

    Smycke(String namn, int antalÄdelstenar, boolean avGuld){
        super(namn);
        this.antalÄdelstenar = antalÄdelstenar;
        this.avGuld = avGuld;
    }

    public double getValue(){
        value = avGuld ? 2000 : 700;
        value += 500*antalÄdelstenar;
        return super.getValue();
    }

    @Override
    public String toString(){
        return super.toString() + " antalÄdelstenar: " + antalÄdelstenar + " ärGuld: " + avGuld;
    }



}
