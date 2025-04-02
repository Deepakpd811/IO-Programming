package com.bridgelab.csv_filehandling.advanced_problems.encryption_decryption_csv;

// xor locic
// A^B = C
// C^B = A  where is the key

public class EncryptionDecryption {

    // Encrypt data with xor
    public static String encrypt(String data, String key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            char keyCh = key.charAt(i % key.length());
            encrypted.append((char) (ch ^ keyCh));
        }
        return encrypted.toString();
    }

    // Decrypt data with xor
    public static String decrypt(String encryptedData, String key) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedData.length(); i++) {
            char ch = encryptedData.charAt(i);
            char keyCh = key.charAt(i % key.length());
            decrypted.append((char) (ch ^ keyCh));
        }
        return decrypted.toString();
    }

}
