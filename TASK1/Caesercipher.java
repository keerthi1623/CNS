import java.io.*;

public class Caesercipher {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String encrypt(String plaintext, int caesarKey) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int plainIndex = ALPHABET.indexOf(currentChar);
                int cipherIndex = (plainIndex + caesarKey) % 52;
                char cipherChar = ALPHABET.charAt(cipherIndex);
                ciphertext.append(cipherChar);
            } else {
                ciphertext.append(currentChar);
            }
        }
        return ciphertext.toString();
    }

    public static String decrypt(String ciphertext, int caesarKey) {
        StringBuilder plaintext = new StringBuilder();
        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            if (Character.isLetter(currentChar)) {
                int cipherIndex = ALPHABET.indexOf(currentChar);
                int plainIndex = (cipherIndex - caesarKey + 52) % 52;
                char plainChar = ALPHABET.charAt(plainIndex);
                plaintext.append(plainChar);
            } else {
                plaintext.append(currentChar);
            }
        }
        return plaintext.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the PLAIN TEXT for Encryption: ");
        String plaintext = br.readLine();
        System.out.println("Enter the CAESAR KEY between 0 and 25:");
        int caesarKey = Integer.parseInt(br.readLine());

        System.out.println("ENCRYPTION");
        String ciphertext = encrypt(plaintext, caesarKey);
        System.out.println("CIPHER TEXT: " + ciphertext);

        System.out.println("DECRYPTION");
        String decryptedText = decrypt(ciphertext, caesarKey);
        System.out.println("PLAIN TEXT: " + decryptedText);
    }
}
