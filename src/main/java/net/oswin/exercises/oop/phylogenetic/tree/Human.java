package net.oswin.exercises.oop.phylogenetic.tree;


/**
 * Человек
 */
public class Human extends Mammal {

    public Human() {
        super(4);
    }

    @Override
    protected Mammal born(Animal partner) {
        Human child = new Human();
        child.power = (power + partner.power) / 2;
        child.fecundity = (fecundity + partner.fecundity) / 2;
        return child;
    }
}
