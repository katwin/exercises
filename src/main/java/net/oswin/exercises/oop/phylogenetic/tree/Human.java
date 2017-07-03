package net.oswin.exercises.oop.phylogenetic.tree;


import java.util.Random;

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

    /**
     * Ищет самую сытную еду, если его самого кто-то из обитателей может съесть.
     * Если его съесть никто не может, то ищет самого сильного партнера.
     * @param habitat
     * @return
     */
    @Override
    /**
     *  public Animal find(Animal[] habitat) {
     * Animal animal = super.find(habitat);
     * Animal animal1 = habitat[new Random().nextInt(habitat.length)];
     * return new Random().nextBoolean() ? animal: animal1;
     * }
     */

    public Animal find(Animal[] habitat) {
        this.power -= this.power / 6;
        //проверяем, есть ли животное другого вида, сильнее меня
        boolean stronger = false;
        for (Animal animal: habitat) {
            if ((animal.power > this.power) && (animal.getClass() != this.getClass())) {
                stronger = true;
                break;
            }
        }
        //если есть, то ищем самое сильное животное другого вида, но слабее меня
        if (stronger == true) {
            int maxfood = 0;
            Animal food = null;
            for (Animal animal : habitat) {
                if ((animal.power < this.power) && (animal.getClass() != this.getClass())) {
                    if (animal.power > maxfood) {
                        maxfood = animal.power;
                        food = animal;
                    }
                }
            }
            return food;
        }
        //если нет, ищем самое сильное животное противоположного пола моего вида
        else {
            int maxpartner = 0;
            Animal partner = null;
            for (Animal animal : habitat) {
                if ((animal.gender != this.gender) && (animal.getClass() == this.getClass())) {
                    if (animal.power > maxpartner) {
                        maxpartner = animal.power;
                        partner = animal;
                    }
                }
            }
            return partner;
        }
    }

    @Override
    protected Mammal born(Animal partner) {
        return new Human(this, (Human) partner);
    }
}
