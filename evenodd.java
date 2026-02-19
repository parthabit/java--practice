// "Count Even and Odd Numbers in an Array"

public class evenodd {
    public static void main(String[] args) {

        int[] numbers = { 12, 5, 66, 2, 8, 25, 54 };

        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
System.out.println("Total Even Numbers: " + evenCount);
        System.out.println("Total Odd Numbers: " + oddCount);
    

    }
}