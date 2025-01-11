import java.util.*;
/**
 *
 * @author visha
 */
public class Railfence {
    
    public static void main(String[] args) {
 Scanner scanner = new Scanner(System.in);
 System.out.println("Rail Fence Transposition Cipher");
 System.out.println("1. Encrypt");
 System.out.println("2. Decrypt");
 System.out.println("3. Exit");
 int choice = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 if (choice == 1 || choice == 2) {
 System.out.print("Enter plaintext word: ");
 String plainText = scanner.nextLine().toLowerCase();
 if (!plainText.matches("[a-z]+")) {
 System.out.println("Sorry, input must be a word.");
 return;
 }
 System.out.print("Enter key (a number): ");
 if (!scanner.hasNextInt()) {
 System.out.println("Sorry, input must be a positive number.");
 return;
 }
 int key = scanner.nextInt();
 scanner.nextLine(); // Consume newline
 String cipherText = "";
 if (choice == 1) {
 cipherText = encrypt(plainText, key);
 System.out.println("Encrypted text: " + cipherText.toUpperCase());
 } else {
 String decryptedText = decrypt(plainText, key);
 System.out.println("Decrypted text: " + decryptedText);
 }
 } else if (choice == 3) {
 System.out.println("Bye");
 } else {
 System.out.println("Invalid choice. Please select 1, 2, or 3.");
 }
 }
 private static String encrypt(String plainText, int key) {
 char[][] matrix = new char[key][plainText.length()];
 int row = 0;
 int col = 0;
 boolean down = false;
 for (int i = 0; i < plainText.length(); i++) {
 if (row == 0 || row == key - 1)
 down = !down;
 matrix[row][col++] = plainText.charAt(i);
 row += down ? 1 : -1;
 }
 StringBuilder result = new StringBuilder();
 for (int i = 0; i < key; i++) {
 for (int j = 0; j < plainText.length(); j++) {
 if (matrix[i][j] != 0)
 result.append(matrix[i][j]);
 }
 }
 return result.toString();
 }
 private static String decrypt(String cipherText, int key) {
 char[][] matrix = new char[key][cipherText.length()];
 int row = 0;
 int col = 0;
 boolean down = false;
 for (int i = 0; i < cipherText.length(); i++) {
 if (row == 0 || row == key - 1)
 down = !down;
 matrix[row][col++] = '*'; // Placeholder for characters
 row += down ? 1 : -1;
 }
 int index = 0;
 for (int i = 0; i < key; i++) {
 for (int j = 0; j < cipherText.length(); j++) {
 if (matrix[i][j] == '*' && index < cipherText.length()) {
 matrix[i][j] = cipherText.charAt(index++);
 }
 }
 }
 StringBuilder result = new StringBuilder();
 row = 0;
 col = 0;
 down = false;
 for (int i = 0; i < cipherText.length(); i++) {
 if (row == 0 || row == key - 1)
 down = !down;
 result.append(matrix[row][col++]);
 row += down ? 1 : -1;
 }
 return result.toString();
 }
}
