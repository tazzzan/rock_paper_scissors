package schere.stein.papier.beans;

/**
 * Created by ilja on 28.01.17.
 */
public abstract class Item {

    private int score;
    private String name;

    public Item(){

    }

    /**
     * Getter and Setter
     */

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
