package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Птицы
 */
public class Bird extends Animal {

    public Bird() {
        super();
    }

    @Override
    public Animal find(Animal[] habitat) {

        power -= 5;
        return null;
    }

    @Override
    protected Animal born() {
        return new Bird();
    }
}
