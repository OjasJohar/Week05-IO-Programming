package com.bridgelabz.advanced_problems.encrypt_and_decrypt_csv_data;

public class Main {
    public static void main(String[] args) {
        System.out.println("Encrypting CSV...");
        CsvEncryptor.writeEncryptedCsv();

        System.out.println("\nDecrypting CSV...");
        CsvDecryptor.readDecryptedCsv();
    }
}