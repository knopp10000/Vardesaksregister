package sample;

public class Apparat extends Värdesak {

    private int inköpspris, slitage;

    Apparat(String namn, int inköpspris, int slitage) {
        super(namn);
    }

    double getValue() {
        value = inköpspris*slitage;
        return super.getValue();
    }
}
