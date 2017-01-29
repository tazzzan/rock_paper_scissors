package schere.stein.papier.service;

import schere.stein.papier.beans.Item;
import schere.stein.papier.beans.Reply;
import schere.stein.papier.manager.Communicator;
import schere.stein.papier.manager.Counter;
import schere.stein.papier.manager.Generator;

import java.util.List;

/**
 * Created by ilja on 28.01.17.
 */
public interface GameService{
    Reply play(String itemName);
    String welcome();
    List<Item> getItems();
    void addSuccess();
    void addLost();
    Generator getGenerator();
    Communicator getCommunicator();
    Counter getCounter();
}
