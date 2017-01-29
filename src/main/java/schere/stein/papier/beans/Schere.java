package schere.stein.papier.beans;

/**
 * Created by ilja on 28.01.17.
 */
public class Schere extends Item{

    public Schere(){
        setName("Schere");
    }
    public Schere(String itemName){
        setName("Schere");

        switch (itemName){
            case "Stein": setScore(0);break;
            case "Papier": setScore(1);break;
            case "Schere": setScore(2);break;
        }
    }
}
