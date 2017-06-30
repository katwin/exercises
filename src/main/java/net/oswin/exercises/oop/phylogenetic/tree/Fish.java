package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Рыбы.
 */
public class Fish extends Animal {

    public Fish() {
        super();
    }

    public Fish(Fish mother, Fish father) {
        this.power = (mother.power + father.power) / 2;
        this.fecundity = (mother.fecundity + father.fecundity) / 2;
    }

    /**
     * Примитивный поиск пищи/партнера - выбор случайного обитателя среды.
     * @param habitat
     * @return
     */
    @Override
    public Animal find(Animal[] habitat) {
        power -= 5;
        return habitat[new Random().nextInt(habitat.length)];
    }

    @Override
    protected Animal born(Animal partner) {
        return new Fish(this, (Fish) partner);
    }
}
