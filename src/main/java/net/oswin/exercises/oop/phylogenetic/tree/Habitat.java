package net.oswin.exercises.oop.phylogenetic.tree;

import java.util.Arrays;
import java.util.Random;

/**
 * Среда обитания всех животных.
 * Каждую итерацию цикла животные ищут пищу и партнеров. Едят, плодятся и умирают.
 * После N итераций выживает сильнейший!
 */
public class Habitat {
    public static void main(String[] args) {
        Animal[] habitat = new Animal[25];
        for (int i = 0; i < 10; i++) {
            habitat[i] = new Bird();
        }
        for (int i = 10; i < 20; i++) {
            habitat[i] = new Fish();
        }
        for (int i = 20; i < 25; i++) {
            habitat[i] = new Human();
        }

        int N = 20;
        for (int i = 0; i < N; i++) {
            Animal[] children = new Animal[0];
            for (Animal animal : habitat) {
                if (animal.power > 0) {
                    Animal found = animal.find(habitat);
                    if (found == null) {
                        continue;
                    }
                    if (found.getClass().equals(animal.getClass())) {
                        children = growth(children, animal.spawn(found));
                    } else {
                        if (animal.power > found.power) {
                            animal.eat(found);
                            found.power = 0;
                        } else {
                            //Ничего не делаем.
                        }
                    }
                }
            }
            habitat = growth(habitat, children);
        }
        int f = 0;
        int h = 0;
        int b = 0;
        for (int i = 0; i < habitat.length; i++) {
            if (habitat[i].power > 0) {
                if (habitat[i].getClass().equals(Bird.class)) {
                    b++;
                }
                if (habitat[i].getClass().equals(Fish.class)) {
                    f++;
                }
                if (habitat[i].getClass().equals(Human.class)) {
                    h++;
                }
            }
        }
        System.out.println("Birds: " + b);
        System.out.println("Fishes: " + f);
        System.out.println("Humans: " + h);
//        System.out.println(Arrays.asList(habitat));
    }

    public static Animal[] growth(Animal[] habitat, Animal[] children) {
        if (children == null) {
            return habitat;
        }
        int habitatL = habitat.length;
        habitat = Arrays.copyOf(habitat, habitat.length + children.length);
        for (int a = habitatL; a < habitat.length; a++) {
            habitat[a] = children[a - habitatL];
        }
        return habitat;
    }

    public static Animal[] decline(Animal[] habitat, Animal[] defuncts) {
        Animal[] result = new Animal[habitat.length - defuncts.length];
        //!!! изменение массива.
        return result;
    }
}
