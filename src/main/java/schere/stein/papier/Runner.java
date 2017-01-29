package schere.stein.papier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import schere.stein.papier.manager.Communicator;
import schere.stein.papier.manager.Generator;
import sun.tools.jar.CommandLine;

@SpringBootApplication
public class Runner{

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);

		Communicator communicator = new Communicator();
		Generator generator = new Generator();

		communicator.welcomeUser();
		communicator.showItems(generator.getItems());
		generator.play(communicator.askToEnter());
	}

}
