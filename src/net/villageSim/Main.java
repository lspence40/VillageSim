package net.villageSim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Person jeff = new Person("jeff", true, false);
        Person bob = new Person("bob", false, true);

        List<Building> map = new ArrayList<>();
//        List<Person> occupantsOfBobsHouse = new ArrayList<>();
//        occupantsOfBobsHouse.add(bob);
//        House h = new House("Bobs bobHouse", occupantsOfBobsHouse);
//        map.add(h);

        World world = World.getInstance();

        world.theShire = new Village(map);

        world.theShire.arrive(jeff);
        world.theShire.arrive(bob);

        for(int i = 0; i < world.theShire.people.size(); i ++) {
            if(!world.theShire.people.get(i).turnTaken) {
                askPlayer(world.theShire.people.get(i).name);
            }
        }

//        theShire.getsRaided(10);

        world.theShire.print();

    }

    private static void askPlayer(String name) {
        Scanner input = new Scanner(System.in);

        System.out.println("what would you like " + name + " to do?");
        String[] answer = input.nextLine().split(" ");

        List<Building> map = World.getInstance().theShire.map;

        if("build".equals(answer[0])) {
            if("house".equals(answer[1])) {
                map.add(new House("house" + map.size(), new ArrayList<>()));
            } else if("blacksmith".equals(answer[1])) {
                map.add(new BlackSmith());
            }

        } else if("equip".equals(answer[0])) {

            boolean blackSmithAvailable = false;
            for(Building building : map) {
                if(!building.turnTaken && building instanceof BlackSmith) {
                    blackSmithAvailable = true;
                }
            }

            if(!blackSmithAvailable) {
                System.out.println("you have no available blacksmiths");
            } else if("sword".equals(answer[2])) {
                Village theShire = World.getInstance().theShire;
                for(int i = 0; i < theShire.people.size(); i ++) {
                    if(theShire.people.get(i).name.equals(name)) {
                        if(!theShire.people.get(i).hasSword) {
                            theShire.people.get(i).hasSword = true;
                            for(int i = 0; i < map.size(); i ++) {
                                if(!map.get(i).turnTaken && map.get(i) instanceof BlackSmith) {
                                    map.get(i).turnTaken = true;
                                    break;
                                }
                            }
                        } else {
                            System.out.println(name + " already has a sword");
                        }
                    }
                }
            } else if("shield".equals(answer[2])) {
                Village theShire = World.getInstance().theShire;
                for(int i = 0; i < theShire.people.size(); i ++) {
                    if(theShire.people.get(i).name.equals(name)) {
                        if(!theShire.people.get(i).hasShield) {
                            theShire.people.get(i).hasShield = true;
                            for(int i = 0; i < map.size(); i ++) {
                                if(!map.get(i).turnTaken && map.get(i) instanceof BlackSmith) {
                                    map.get(i).turnTaken = true;
                                    break;
                                }
                            }
                        } else {
                            System.out.println(name + " already has a shield");
                        }
                    }
                }
            }
        }
    }
}
