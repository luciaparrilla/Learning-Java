package abstractclass;

public class Zoo {
    public static void main(String[] args) {
        Cat c = new Cat ("Cat");
        c.makeSound();
        Fox f = new Fox ("Fox");
        f.makeSound();
        AngoraCat ac = new AngoraCat("Angora Cat");
        ac.makeSound();

        c.sleep();
        f.sleep();
        ac.sleep();

        c.wakeUp();
        f.wakeUp();
        ac.wakeUp();

        c.climbing();
        ac.climbing();
    }
}
