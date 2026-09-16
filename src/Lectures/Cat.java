package Lectures;

public class Cat extends Animal {

    private int legCount;
    private int lives;

    public Cat() {
        this.setName("Maomao");
    }

    public Cat(String name, int legCount, int lives) {
        super(name); //calls the constructor of the super class
        this.legCount = legCount;
        this.lives = lives;
    }


}
