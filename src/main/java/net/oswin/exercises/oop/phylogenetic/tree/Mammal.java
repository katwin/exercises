package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Млекопитающие
 */
public abstract class Mammal extends Animal {

    public Mammal(int fecundity) {
        super();
        this.fecundity = fecundity;
    }
    
    @Override
    public Animal find(Animal[] habitat) {
        return null;
    }
}
