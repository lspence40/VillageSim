package net.villageSim;

import java.util.List;

public class House extends Building {

    private int sleepHealthGain = 10;
    public String name;
    public List<Person> occupants;

    public House(String name, List<Person> occupants) {
        this.name = name;
        this.occupants = occupants;
    }

    @Override
    public void print() {
        System.out.print("there is a house with ");
        if(occupants.size() > 0){
            for(Person p : occupants) {
                System.out.print(p.name + " ");
            }
        } else {
            System.out.print("nobody ");
        }
        System.out.println("in it.");
    }


//    public void sleep() {
//        for (Person p : occupants) {
//            p.health += sleepHealthGain;
//            if (p.health > 100) {
//                p.health = 100;
//            }
//        }
//    }

//    @Override
//    public void update() {
//        sleep();
//    }
}
