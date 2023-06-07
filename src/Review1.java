public class Review1 {


    public static void main(String[] args) {
        String op = abc();
        System.out.println(op);
    }
    static String abc() {
        boolean use = true;

        String t = "abc:123";

        return t=use?t.replaceAll(":",""):t;
    }
}
