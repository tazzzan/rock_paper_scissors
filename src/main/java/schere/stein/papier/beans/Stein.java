package schere.stein.papier.beans;

/**
 * Created by ilja on 28.01.17.
 */
public class Stein extends Item {

    public Stein(){
        setName("Stein");
    }

    public Stein(String itemName){
        setName("Stein");

        switch (itemName){
            case "Papier": setScore(0);break;
            case "Schere": setScore(1);break;
            case "Stein": setScore(2);break;
        }
    }
}
