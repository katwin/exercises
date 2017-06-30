package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Царство животных
 */
public abstract class Animal {
    protected int power = 1;
    protected boolean gender;
    protected int fecundity = 1;

    public Animal() {
        this.power = 50 + new Random().nextInt(51);
        this.gender = new Random().nextBoolean();
    }

    public abstract Animal find(Animal[] habitat);

    public final void eat(Animal food) {
        if (food.power > this.power)
            throw new IllegalArgumentException();
        power += food.power;
        food.power = 0;
    }

    public Animal[] spawn(Animal partner) {
        if (gender != partner.gender) {
            Animal[] children = new Animal[1+new Random().nextInt(fecundity)];
            for (int i = 0; i < children.length; i++) {
                children[i] = born(partner);
            }
            return children;
        }
        return null;
    }
    
    protected abstract Animal born(Animal partner);

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "power=" + power +
                ", gender=" + gender +
                "}\n";
    }
}
