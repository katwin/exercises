package net.oswin.exercises.oop.phylogenetic.tree;


/**
 * Человек
 */
public class Human extends Mammal {

    public Human() {
        super();
    }

    public Human(Human mother, Human father) {
        super(mother, father);
    }

    @Override
    protected Mammal born(Animal partner) {
        return new Human(this, (Human) partner);
    }
}
