import java.util.Scanner;

public class Alchohol {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double  pricewiskey = Double.parseDouble(console.nextLine());
        double  beer = Double.parseDouble(console.nextLine());
        double  wine = Double.parseDouble(console.nextLine());
        double  rakia = Double.parseDouble(console.nextLine());
        double  wiskey = Double.parseDouble(console.nextLine());
        double pricebeer = pricewiskey*0.8;
        double pricewine = pricewiskey*0.4;
        double pricerakia = pricewiskey*0.5;
        double finalbeer = beer * pricebeer;
        double finalwine = wine * pricewine;
        double finalrakia = rakia * pricerakia;
        double finalwiskey = pricewiskey * wiskey;
        double totallPrice = finalwiskey + finalbeer + finalwine + finalrakia;
        System.out.println(totallPrice);
    }
}