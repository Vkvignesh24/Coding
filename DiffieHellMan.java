import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class DiffieHellMan {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input prime number
        System.out.println("Enter prime number:");
        BigInteger p = new BigInteger(br.readLine());

        // Input primitive root
        System.out.print("Enter primitive root of " + p + ":");
        BigInteger g = new BigInteger(br.readLine());

        // Input private key for sender
        System.out.println("Enter private key for sender (value less than " + p + "):");
        BigInteger x = new BigInteger(br.readLine());

        // Calculate R1
        BigInteger R1 = g.modPow(x, p);
        System.out.println("R1=" + R1);

        // Input private key for receiver
        System.out.print("Enter private key for receiver (less than " + p + "):");
        BigInteger y = new BigInteger(br.readLine());

        // Calculate R2
        BigInteger R2 = g.modPow(y, p);
        System.out.println("R2=" + R2);

        // Calculate shared secret key at sender's side
        BigInteger k1 = R2.modPow(x, p);
        System.out.println("Key calculated at Sender's side: " + k1);

        // Calculate shared secret key at receiver's side
        BigInteger k2 = R1.modPow(y, p);
        System.out.println("Key calculated at Receiver's side: " + k2);

        System.out.println("Diffie-Hellman secret key exchange completed.");
    }
}
