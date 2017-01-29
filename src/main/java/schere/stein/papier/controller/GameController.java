package schere.stein.papier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import schere.stein.papier.beans.Item;
import schere.stein.papier.beans.Reply;
import schere.stein.papier.manager.Communicator;
import schere.stein.papier.manager.Counter;
import schere.stein.papier.manager.Generator;
import schere.stein.papier.service.GameService;
import schere.stein.papier.service.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilja on 28.01.17.
 */


@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService gameService;


    @RequestMapping("/layout")
    public String getPartialPage() {
        return "/views/layout.html";
    }

    @RequestMapping("/welcome")
    public @ResponseBody Reply getWelcomeMessage() {
        Reply reply = new Reply();
        reply.setText(gameService.welcome());
        return reply;}

    @RequestMapping("/items.json")
    public @ResponseBody List<Item> fetchItems() {return gameService.getItems();}

    @RequestMapping("/play/{itemName}")
    public @ResponseBody Reply play(@PathVariable("itemName") String itemName){
        Reply reply = gameService.play(itemName);

        System.out.println(reply.getText());

        return reply;
    }

    @RequestMapping("/score")
    public @ResponseBody List<Integer> getScore(){
        List<Integer> scores = new ArrayList<>();
        scores.add(gameService.getCounter().getSuccesses());
        scores.add(gameService.getCounter().getLosts());
        return scores;
    }

    @RequestMapping("/restart")
    public @ResponseBody void restart(){
        gameService.getCounter().setLosts(0);
        gameService.getCounter().setSuccesses(0);
    }
}
