import java.util.Scanner;

public class CharacterReplacement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input string
        System.out.print("Enter the original string: ");
        String originalString = scanner.nextLine();

        // Index of character to replace
        System.out.print("Enter the index of the character to replace: ");
        int indexToReplace = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Character for replacement
        System.out.print("Enter the character for replacement: ");
        char replacementChar = scanner.nextLine().charAt(0);

        String modifiedString = replaceCharAtIndex(originalString, indexToReplace, replacementChar);
        System.out.println("Modified string: " + modifiedString);

        scanner.close();
    }

    public static String replaceCharAtIndex(String str, int index, char replacement) {
        if (index < 0 || index >= str.length()) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }

        char[] chars = str.toCharArray();
        chars[index] = replacement;
        return new String(chars);
    }
}
