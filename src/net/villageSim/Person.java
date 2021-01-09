package net.villageSim;

public class Person {
    String name;
    int health;
    boolean isDead;
    boolean hasSword;
    boolean hasShield;
    boolean turnTaken;

    public Person(String name, boolean hasSword, boolean hasShield) {
        this.name = name;
        this.isDead = false;
        this.health = 100;
        this.hasSword = hasSword;
        this.hasShield = hasShield;
        this.turnTaken = false;
    }

    public void print() {
        System.out.print(name + " has " + health + " health");
        if(hasSword) {
            System.out.print(" and a sword");
        }
        if(hasShield) {
            System.out.print(" and a shield");
        }
        if(isDead) {
            System.out.println(" and is dead.");
        } else {
            System.out.println();
        }
    }

    public void stab() {
        int damage = (int)(Math.random() * 40);

        if(hasShield) {
            damage /= 3;
        }

        health -= damage;
        System.out.println(name + " has been stabbed for " + damage + " damage.");

        if(health <= 0) {
            health = 0;
            isDead = true;
        }
    }


}
