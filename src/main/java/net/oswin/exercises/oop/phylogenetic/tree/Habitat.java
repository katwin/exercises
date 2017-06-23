package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Random;

/**
 * Среда обитания всех животных
 */
public class Habitat {
    public static void main(String[] args) {
        Bird eagle = new Bird();
        Human steverogers = new Human();
        Human blackwidow = new Human();

        steverogers.spawn(blackwidow);
    }
}
