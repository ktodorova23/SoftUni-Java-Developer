package jarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> nums = new Jar<>();

        nums.add(5);
        nums.add(2);
        nums.add(1);
        nums.add(3);
        nums.add(4);

        System.out.println(nums.remove());
    }
}
