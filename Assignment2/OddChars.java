public class OddChars {
    public static void main(String[] args) {
        String t = "type here to search";
        printOddChars(t);
    }

    public static void printOddChars(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0 && s.charAt(i) != ' ') {
                System.out.print(s.charAt(i) + " ");
            }
        }
    }
}
