package Lectures;

public class Animal {

    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeSound(){
        System.out.println("The animal named "+ this.name + " is making sound.");
    }




    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args){

        Animal a = new Animal("Maria");
        System.out.println(a);

        a.makeSound();

        Cat c = new Cat();

        System.out.println(c);





    }
}
