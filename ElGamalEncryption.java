import java.math.BigInteger;
import java.util.Scanner;
public class ElGamalEncryption {
public static void main(String[] args) {
	// Declare required parameters as BigInteger objects
		BigInteger m; // Input Message
		BigInteger p; // 1st public parameter of Bob
		BigInteger g; // 2nd public parameter of Bob
		BigInteger x; // Bob's Private Key
		BigInteger y;
		BigInteger r; // Chosen Random Number
		BigInteger k,k_bob;
		BigInteger k_Inv; // k^-1 mod p
		BigInteger C1; // 1st Ciphertext C1
		BigInteger C2; // 2nd Ciphertext C2
		BigInteger M; // Decrypted Message
		// Take required parameter as Input
		Scanner input = new Scanner(System.in); // initialize Scanner object for taking input
		System.out.println("Welcome to ElGamal Encryption Program !!!");
		System.out.println("BOB generates Public and Private Key.");
		System.out.println("Please provide the following information as Integer !!!");
		System.out.print("Enter the value of 'p' (as Integer): ");
		String p_str = input.next();
		System.out.print("Enter the value of 'g' (as Integer): ");
		String g_str = input.next();
		System.out.print("Enter the value of 'x' (as Integer): ");
		String x_str = input.next();
		// assign values to bi1, bi2
		p = new BigInteger(p_str);
		g = new BigInteger(g_str);
		x = new BigInteger(x_str);
		System.out.println();
		//System.out.println("Here is the detail Solution: ");
		y = g.modPow(x, p);
		System.out.println("The value of 'y' is: "+y);
		System.out.println("The Private-Key x := "+x);
		System.out.println("The Public-Key (p,y,g) := ("+p+", "+y+", "+g+") is sent to ALICE.");
		System.out.println("ALICE Encrypts the Message, m ");

		System.out.print("Enter the message (as Integer) to encrypt, m := ");
		String m_str = input.next();
		m = new BigInteger(m_str);
		System.out.print("Enter the value of 'r' (as Integer): ");
		String r_str = input.next();
		r = new BigInteger(r_str);
		k = y.modPow(r, p);
		System.out.println("The value of 'k' is: "+k);
		C1 = g.modPow(r, p);
		C2 = (m.multiply(k)).mod(p);
		System.out.println("Ciphertexts, C1 := "+C1);
		System.out.println("Ciphertexts, C2 := "+C2);
		System.out.println("\n(C1, C2)=("+C1+", "+C2+") are sent to BOB.");
		System.out.println("BOB decrypts the Original Message.");
		k_bob = C1.modPow(x, p);
		System.out.println("The value of 'k' @BOB is: "+k_bob);
		k_Inv = k.modInverse(p);
		System.out.println("The value of 'k^-1' is: "+k_Inv);
		M = (k_Inv.multiply(C2)).mod(p);
		System.out.println("Extracted Message, M := "+M);
	}
}
