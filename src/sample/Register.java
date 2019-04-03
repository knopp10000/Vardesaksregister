package sample;

import java.util.ArrayList;

public class Register {
    static ArrayList<Värdesak> värdesaker = new ArrayList<>();


    static public void registerVärdesak(Värdesak värdesak){
        värdesaker.add(värdesak);
    }

    static public ArrayList<Värdesak> getVärdesaker() {
        return new ArrayList<Värdesak>(värdesaker);
    }
}
