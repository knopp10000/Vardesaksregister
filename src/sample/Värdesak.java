package sample;

public class Värdesak {

    private final Double MOMS = 1.25;
    private String namn;
    protected int value;

    Värdesak(String namn){
        this.namn = namn;
    }

    double getValue(){
        return value*MOMS;
    }

    public String getName(){
        return namn;
    }

    public String toString(){
        return (namn + " värde: " + getValue());
    }
}
