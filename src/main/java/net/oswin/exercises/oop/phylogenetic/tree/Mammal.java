package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Млекопитающие
 */
public abstract class Mammal extends Animal {

    public Mammal() {
        super();
    }

    public Mammal(Mammal mother, Mammal father) {
        this.power = (mother.power + father.power) / 2;
        this.fecundity = (mother.fecundity + father.fecundity) / 2;
    }

    //Алгоритм (для наследников Mammal), рассчитанный на поиск обьекта.
    //Если этот обьект принадлежит тому же классу, то выполняется метод spawn, в противном случае - eat.
    @Override
    public Animal find(Animal[] habitat) {
        return null;
    }
}
