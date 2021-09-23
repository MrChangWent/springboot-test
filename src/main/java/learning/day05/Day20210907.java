package learning.day05;

public class Day20210907 {
    static int allclicks = 0;
    String str = "hellpo";
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void method(){
        int i = 0;
    }

     public double protectedmethod(double price){
        return price*2;
    }

    public static void main(String[] args) {
        Day20210907 day20210907 = new Day20210907();
        System.out.println(day20210907.str);

        day20210907.setPrice(100.10D);
        System.out.println(day20210907.getPrice());
    }
}
