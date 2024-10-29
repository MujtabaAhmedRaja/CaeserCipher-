package CeasarCipher;


import java.util.Scanner;
public class CaesarCipher {
    public static String encrypt(String input, int shift) {
        return applyShift(input, shift);
    }

    public static String decrypt(String input, int shift) {
        return applyShift(input, -shift);
    }

    private static String applyShift(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) ((c - 'A' + shift + 26) % 26 + 'A'));
            } else if (Character.isLowerCase(c)) {
                result.append((char) ((c - 'a' + shift + 26) % 26 + 'a'));
            }
            else if (Character.isDigit(c)) {
                int initial = c;
                int adjustedShift = ((c - '0' + shift) % 10 + 10) % 10; // Ensure the result is non-negative
                int shifted = adjustedShift + '0';
               // System.out.println("Character: " + c + " | Initial: " + initial + " | Shift: " + shift + " | Adjusted Shift: " + adjustedShift + " | Shifted Value: " + shifted + " | Encrypted/Decrypted: " + (char)shifted);
                result.append((char) shifted);
            } else if (c >= ' ' && c <= '/') {
                int initial = c;
                int adjustedShift = ((c - ' ' + shift) % 16 + 16) % 16; // Ensure the result is non-negative
                int shifted = adjustedShift + ' ';
               // System.out.println("Character: " + c + " | Initial: " + initial + " | Shift: " + shift + " | Adjusted Shift: " + adjustedShift + " | Shifted Value: " + shifted + " | Encrypted/Decrypted: " + (char)shifted);
                result.append((char) shifted);
            }
            else if (c >= ':' && c <= '@') {
                int initial = c;
                int adjustedShift = ((c - ':' + shift) % 7 + 7) % 7; // Ensure the result is non-negative
                int shifted = adjustedShift + ':';
               // System.out.println("Character: " + c + " | Initial: " + initial + " | Shift: " + shift + " | Adjusted Shift: " + adjustedShift + " | Shifted Value: " + shifted + " | Encrypted/Decrypted: " + (char)shifted);
                result.append((char) shifted);
            }
            else if (c >= '[' && c <= '`') {
                int initial = c;
                int adjustedShift = ((c - '[' + shift) % 6 + 6) % 6; // Ensure the result is non-negative
                int shifted = adjustedShift + '[';
              //  System.out.println("Character: " + c + " | Initial: " + initial + " | Shift: " + shift + " | Adjusted Shift: " + adjustedShift + " | Shifted Value: " + shifted + " | Encrypted/Decrypted: " + (char)shifted);
                result.append((char) shifted);
            }else if (c >= '{' && c <= '~') {
                int initial = c;
                int adjustedShift = ((c - '{' + shift) % 4 + 4) % 4; // Ensure the result is non-negative
                int shifted = adjustedShift + '{';
             //   System.out.println("Character: " + c + " | Initial: " + initial + " | Shift: " + shift + " | Adjusted Shift: " + adjustedShift + " | Shifted Value: " + shifted + " | Encrypted/Decrypted: " + (char)shifted);
                result.append((char) shifted);
            }
            else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to be shifted: ");
        String input = sc.nextLine();
        int shift = 13;
        String encrypted = encrypt(input, shift);
        String decrypted = decrypt(encrypted, shift);
        System.out.println("Encrypted Output: " + encrypted);
        System.out.println("Decrypted Output: " + decrypted);
    }
}
