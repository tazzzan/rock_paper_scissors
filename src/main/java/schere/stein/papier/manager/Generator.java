package schere.stein.papier.manager;

import org.springframework.stereotype.Service;
import schere.stein.papier.beans.Item;
import schere.stein.papier.beans.Papier;
import schere.stein.papier.beans.Schere;
import schere.stein.papier.beans.Stein;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilja on 28.01.17.
 */
@Service
public class Generator {
    private List<Item> items;

    Communicator communicator = new Communicator();

    public Generator(){
        items = new ArrayList<Item>();
        createItems();
    }

    public void createItems(){
        addItem(new Stein());
        addItem(new Papier());
        addItem(new Schere());
    }

    public void play(String input){
        Item itemUser = null;

        if(input.equals("0") || input.equals("Stein")){
            itemUser = items.get(0);
        }

        else if(input.equals("1") || input.equals("Papier")){

            itemUser = items.get(1);
        }

        else if(input.equals("2") || input.equals("Schere")){
            itemUser = items.get(2);
        }

        else{
            System.out.println("Sorry, it's not valid what you wrote");
            play(communicator.askToEnter());
        }

        /** The crucial part */
        communicator.showResult(generateRandom(itemUser.getName()));

        play(communicator.askToEnter());
    }

    public void addItem(Item item){
        items.add(item);
    }


    public List<Item> showItems(){
        return items;
    }

    public Item generateRandom(String itemName){
        Item itemPC = null;

        switch ((int) ((Math.random()*3))){
            case 0 : itemPC = new Stein(itemName);break;
            case 1 : itemPC = new Papier(itemName);break;
            case 2 : itemPC = new Schere(itemName);break;
        }

        return itemPC;
    }

    /**
     * Getter and Setter
     */

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
