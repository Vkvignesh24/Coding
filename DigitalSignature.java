import java.security.*;
import java.util.Scanner;
public class DigitalSignature {
    public static void main(String args[]) throws Exception {
        System.out.println("Enter the text:");
        String msg = new Scanner(System.in).nextLine();
        
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        Signature sign = Signature.getInstance("SHA256withDSA");
        
        sign.initSign(privKey);
        byte[] bytes = msg.getBytes();
        
        sign.update(bytes);
        byte[] signature = sign.sign();
        System.out.println("Digital signature for given text: " + new String(signature, "UTF8"));
        System.out.println("VALID SIGNATURE");
    }
}
