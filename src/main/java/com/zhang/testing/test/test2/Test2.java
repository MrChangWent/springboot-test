package com.zhang.testing.test.test2;

public class Test2{
    private String name;
    private byte age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("dog1", 12);
        dog.eat();
        dog.introduction();
        dog.sleep();
        dog.color("black");

    }
}
class  Dog extends Animals {

    public Dog(String myname, int myid) {
        super(myname, myid);
    }

    public void color(String color) {
        System.out.println(color);
    }
}