package com.zhang.testing.test.test1;

public class Test {

    Students students = new Students() {
        @Override
        public void allInfo() {
           students.setName("name1");
           students.setAge(10);
           students.setAddress("Beijing Chaoyang ");
        }

        @Override
        public void getAllInof() {

        }
    };
}
