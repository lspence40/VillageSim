package net.villageSim;

import java.util.List;

public class BlackSmith extends Building {

    public BlackSmith(String name) {
    }

    public void giveShield(Person p) {
        p.hasShield = true;
    }

    public void giveSword(Person p) {
        p.hasSword = true;
    }

    public void print() {
        System.out.println("there is a blacksmith.");
    }

    public void doYourThing() {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.println("who would you like to make a sword or shield for?");
        String answer = input.nextLine();
        String person = answer.split(" ")[0];
        String item = answer.split(" ")[1];
        System.out.println("a " + item + " has been given to " + person + ".");
    }
//    @Override
//    public void update() {
//        makeShield();
//    }
}
