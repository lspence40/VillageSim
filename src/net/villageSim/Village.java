package net.villageSim;

import java.util.ArrayList;
import java.util.List;

public class Village {
    List<Person> people;
    List<Building> map;

    int food;

    public Village(List<Building> map) {
        this.people = new ArrayList<>();
        this.map = map;
        this.food = 100;
    }

    public void arrive(Person person) {
        people.add(person);
    }

    public void print() {
        System.out.println();
        for(Building building : map) {
            building.print();
        }
        System.out.println();
        for(Person person : people) {
            person.print();
        }
    }

    public void getsRaided(int attackStrength) {

        for(int i = 0; i < attackStrength; i++) {
            int target = getTarget();

            if (people.get(target).hasSword) {
                target = getTarget();
            }

            people.get(target).stab();
        }
        System.out.println();
    }

    private int getTarget() {
        return (int) (Math.random() * people.size());
    }

// public void update() {
//     for (Building b : map) {
//         b.update();
//     }
// }

}
