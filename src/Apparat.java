//Karl Gustafsson 19990507-1313
public class Apparat extends Värdesak {

    private int inköpspris, slitage;

    Apparat(String namn, int inköpspris, int slitage) {
        super(namn);
        this.inköpspris = inköpspris;
        this.slitage = slitage;
    }

    public double getValue() {
        value = (inköpspris/10)*slitage;
        return super.getValue();
    }

    @Override
    public String toString(){
        return super.toString() + " inköpspris: " + inköpspris + " slitage: " + slitage;
    }
}
