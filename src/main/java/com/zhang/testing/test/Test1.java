package com.zhang.testing.test;

import learning.day05.Day20210907;

import java.util.Scanner;

public class Test1 {
   Day20210907 day20210907 = new Day20210907();

   public double getpricenum(){
      return day20210907.protectedmethod(10.1);
   }


   public static void main(String[] args) {
      Test1 test1 = new Test1();
      System.out.println(test1.getpricenum());
//      while ( test1 instanceof Test1) {
//
//      }
//
//
//      do {
//         System.out.println(1);
//      } while ( test1 instanceof Test1);
//
      //增强for
      String names[] = {"name1", "name2", "name3", "name4"};

      for (String name: names) {
         System.out.println(name);
      }

      int ages[] = {1, 2, 3, 4, 7, 4};
      Integer count = 0;
      for (Integer age: ages) {
         count += age;
         System.out.println(age + ", " + count);
      }


      //switch

      String flag = "1";
      switch (flag) {

         case "1":
            System.out.println(1);
            break;
         case "2":
            System.out.println(2);
         default:
            System.out.println("default");

      }

      char a = 'c';
      String b = Character.toString(a);
      System.out.println(b);
      String name = "zhang";
      String name1 = name.concat(String.valueOf(a));
      System.out.println(name1);
      String[] strings = new String[10];
      System.out.println(strings.length);
      int[] ages1 = {1,2,5,7,6523,543,23,12,3};
      for (int age: ages1) {
         System.out.println(age);

      }
      Scanner s = new Scanner(System.in);
      if (s.hasNext()){
         String s1 = s.next();
         System.out.println(s1 + ";");
         s.close();
      }
   }
}
