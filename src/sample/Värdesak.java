package sample;

public class Värdesak {

    private final Double MOMS = 1.25;
    protected String namn;
    protected int value;

    Värdesak(String namn){
        this.namn = namn;
    }

    double getValue(){
        return value*MOMS;
    }

    public String toString(){
        return (namn + " " + getValue());
    }
}
