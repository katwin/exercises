package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Птицы
 */
public class Bird extends Animal {

    public Bird() {
        super();
    }

    public Bird(Bird mother, Bird father) {
        this.power = (mother.power + father.power) / 2;
        this.fecundity = (mother.fecundity + father.fecundity) / 2;
    }

    /**
     * Птица в
     * @param habitat
     * @return
     */
    @Override
    public Animal find(Animal[] habitat) {
        power -= 5;
        for (int i = 0; i < habitat.length; i++) {
            Animal animal = habitat[i];
            if (animal == this)
                continue;
            if (animal.getClass().equals(Bird.class)) {
                return animal;
            } else if (animal.power < this.power) {
                return animal;
            }
        }
        return null;
    }

    @Override
    protected Animal born(Animal partner) {
        return new Bird(this, (Bird) partner);
    }
}
