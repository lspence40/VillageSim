package net.villageSim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Building> map;

    public static void main(String[] args) throws Exception {
        Person jeff = new Person("jeff", true, false);
        Person bob = new Person("bob", false, true);

        map = new ArrayList<>();
//        List<Person> occupantsOfBobsHouse = new ArrayList<>();
//        occupantsOfBobsHouse.add(bob);
//        House h = new House("Bobs bobHouse", occupantsOfBobsHouse);
//        map.add(h);


        Village theShire = new Village(map);

        theShire.arrive(jeff);
        theShire.arrive(bob);

        for(int i = 0; i < theShire.people.size(); i ++) {
            askPlayer(theShire.people.get(i).name);
        }

//        theShire.getsRaided(10);

        theShire.print();

    }

    private static void askPlayer(String name) {
        Scanner input = new Scanner(System.in);

        System.out.println("what would you like " + name + " to do?");
        String answer = input.nextLine();
        Command command = new Command(answer);

        if("build".equals(command.action)) {
            if("house".equals(command.noun)) {
                map.add(new House("house" + map.size(), new ArrayList<>()));
            } else if("blacksmith".equals(command.noun)) {
                map.add(new BlackSmith("new blacksmith"));
            }

        } else if("equip".equals(command.action)) {

        }
    }
}
