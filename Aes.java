import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class Aes {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Key Text : ");
        String key = sc.nextLine();
        System.out.print("Enter the Aadhar Number : ");
        String plainText = sc.nextLine();
        
        if (isValidInput(key, plainText)) {
            byte[] encryptedBytes = processCipher(plainText.getBytes(), key, Cipher.ENCRYPT_MODE);
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println("Encrypted: " + encryptedText);
            
            byte[] decryptedBytes = processCipher(Base64.getDecoder().decode(encryptedText), key, Cipher.DECRYPT_MODE);
            String decryptedText = new String(decryptedBytes);
            System.out.println("Decrypted: " + decryptedText);
        } else {
            System.out.println("Enter a valid Aadhar Number and 16-bit key size.");
        }
    }

    public static boolean isValidInput(String key, String plainText) {
        return key.length() == 16 && plainText.length() == 12;
    }

    public static byte[] processCipher(byte[] text, String key, int mode) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(mode, secretKey);
        return cipher.doFinal(text);
    }
}
