package schere.stein.papier.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schere.stein.papier.beans.Item;
import schere.stein.papier.beans.Reply;
import schere.stein.papier.manager.Communicator;
import schere.stein.papier.manager.Counter;
import schere.stein.papier.manager.Generator;

import java.util.List;

/**
 * Created by ilja on 28.01.17.
 */

@Service("GameService")
public class GameServiceImpl implements GameService {

    @Autowired
    Generator generator = new Generator();

    @Autowired
    Communicator communicator = new Communicator();

    @Autowired
    Counter counter = new Counter();


    @Override
    public Reply play(String itemName){
        Reply reply =  new Reply();

        Item itemPC = generator.generateRandom(itemName);

        switch (itemPC.getScore()){
            case 0 : counter.addSuccess(); reply.setText(communicator.getResultPositive());break;
            case 1 : counter.addLost(); reply.setText(communicator.getResultNegative());break;
            case 2 : reply.setText(communicator.getResultDraw());break;
        }

        reply.setItemPC(itemPC.getName());

        return reply;
    }

    @Override
    public String welcome(){
        communicator.welcomeUser();
        return communicator.getWelcome();
    }

    @Override
    public List<Item> getItems(){
        return generator.getItems();
    }

    @Override
    public void addSuccess(){
        counter.addSuccess();
    }

    @Override
    public void addLost(){
        counter.addLost();
    }

    /**
     * Getter and Setter
     */

    @Override
    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    @Override
    public Communicator getCommunicator() {
        return communicator;
    }

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }
}
