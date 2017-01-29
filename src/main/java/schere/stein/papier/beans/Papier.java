package schere.stein.papier.beans;

/**
 * Created by ilja on 28.01.17.
 */
public class Papier extends Item {

    public Papier(){
        setName("Papier");
    }

    public Papier(String itemName){
        setName("Papier");

        switch (itemName){
            case "Schere": setScore(0);break;
            case "Stein": setScore(1);break;
            case "Papier": setScore(2);break;
        }
    }
}
