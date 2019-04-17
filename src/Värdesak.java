//Karl Gustafsson 19990507-1313
public class Värdesak {

    private final Double MOMS = 1.25;
    private String namn;
    protected double value;

    Värdesak(String namn){
        this.namn = namn;
    }

    protected double getValue(){
        return value*MOMS;
    }

    public String getName(){
        return namn;
    }

    public String toString(){
        return (namn + " värde: " + getValue());
    }
}
