package schere.stein.papier.manager;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import schere.stein.papier.beans.Item;

import java.util.List;
import java.util.Scanner;

/**
 * Created by ilja on 28.01.17.
 */
@Service
public class Communicator {

    private String welcome;
    private String resultPositive;
    private String resultNegative;
    private String resultDraw;


    public Communicator(){
        setWelcome("Welcome, please make your choice!");
        setResultPositive("You scored!");
        setResultNegative("You will succeed the next time!");
        setResultDraw("Draw! At least not lost!");
    }

    public void welcomeUser(){
        System.out.println(getWelcome());
    }

    public void showItems(List<Item> items){
        for(int i=0; i<items.size(); i++){
            System.out.println("item #"+i+" | "+items.get(i).getName());
        }
    }

    public String askToEnter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Your choice [number] or [Name]: ");
        String input = sc.next();
        System.out.println("");
        System.out.println("You decided for: " + input);

        return input;
    }

    public void showResult(Item item){

        System.out.println("PC decided for: "+ item.getName());
        System.out.println("________________________________________");

        switch (item.getScore()){
            case 0 : System.out.println(getResultPositive()); break;
            case 1 : System.out.println(getResultNegative()); break;
            case 2 : System.out.println(getResultDraw()); break;
        }

        System.out.println("________________________________________");

    }

    /**
     * Getter and Setter
     */

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }


    public String getResultPositive() {
        return resultPositive;
    }

    public void setResultPositive(String resultPositive) {
        this.resultPositive = resultPositive;
    }

    public String getResultNegative() {
        return resultNegative;
    }

    public void setResultNegative(String resultNegative) {
        this.resultNegative = resultNegative;
    }

    public String getResultDraw() {
        return resultDraw;
    }

    public void setResultDraw(String resultDraw) {
        this.resultDraw = resultDraw;
    }
}
