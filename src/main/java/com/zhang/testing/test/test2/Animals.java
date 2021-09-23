package com.zhang.testing.test.test2;

public class Animals {

    private String name;
    private int id;

    public Animals(String myname, int myid) {
        name = myname;
        id = myid;
    }

    public void eat() {
        System.out.println(name + " eating");
    }

    public void sleep() {
        System.out.println(name + " sleeping");
    }

    public void introduction() {
        System.out.println(name + " is me!," + id );
    }
}