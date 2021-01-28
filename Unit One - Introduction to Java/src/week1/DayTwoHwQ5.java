package week1;

public class DayTwoHwQ5 {
    public static void main(String[] args) {
      double pennie = 0.01;
      double nickle = 0.05;
      double dime = 0.10;
      double quarter = 0.25;
       int loonie = 1;
       int toonie = 2;

        double cents = pennie*5 + nickle*3 + dime*6 + quarter*2;
        double money = cents + loonie*1 + toonie*2;

        System.out.println("Money:"+money);

    }
}
