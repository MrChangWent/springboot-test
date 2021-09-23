package learning.day05;

public class Animal {

    static char ch;
    public Animal (String name) {
        System.out.println("name is " + name);
    }
    public Animal(){}

    public static void main(String[] args) throws InterruptedException {
        Animal animal = new Animal("tommy");

        byte bt = 100;
        String bt_1 = String.valueOf(bt);
        int b = (byte) bt;
        Byte array[] = {1,2,3,4};

        System.out.println(bt_1);

    }
}