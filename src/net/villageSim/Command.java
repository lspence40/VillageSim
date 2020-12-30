package net.villageSim;

public class Command {

    public String action;
    public String noun;
    public String noun2;

    public Command(String input) {
       String[] tokens = input.split(" ");
       this.action = tokens[0];
       this.noun = tokens[1];
       if (tokens.length > 2 ) {
           this.noun2 = tokens[2];
       }
    }
}
