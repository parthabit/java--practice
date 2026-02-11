public class overwrite {
    int x = 5;

    public static void main(String[] args) {
        overwrite myobj = new overwrite();
        myobj.x = 40;
        System.out.println(myobj.x);
    }
}
