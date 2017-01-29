package schere.stein.papier.manager;

import org.springframework.stereotype.Service;

/**
 * Created by ilja on 29.01.17.
 */
@Service
public class Counter {
    int successes = 0;
    int losts = 0;

    public int addSuccess(){
        successes++;
        return successes;
    }

    public int addLost(){
        losts++;
        return losts;
    }

    /**
     * Getter and Setter
     */

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }

    public int getLosts() {
        return losts;
    }

    public void setLosts(int losts) {
        this.losts = losts;
    }
}
