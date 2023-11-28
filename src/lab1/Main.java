package lab1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Lab1 prog = new Lab1();

        prog.decryptCiphertext();


        /*
        String pathCiphertext = "src/lab1/files/ciphertext.enc";
        String pathKeyStore = "src/lab1/files/lab1Store";

        ReadKeyStore keyStore = new ReadKeyStore();
        System.out.println(keyStore.getKey().toString());

        ReadCiphertext ciphertext = new ReadCiphertext();

        RsaDecrypt decryptKey1 = new RsaDecrypt(ciphertext.getEncKey1(), keyStore.getKey());
        RsaDecrypt decryptIv = new RsaDecrypt(ciphertext.getEncIv(), keyStore.getKey());
        RsaDecrypt decryptKey2 = new RsaDecrypt(ciphertext.getEncKey2(), keyStore.getKey());

        byte[] key1 = decryptKey1.getDecrypted();
        byte[] iv = decryptIv.getDecrypted();
        byte[] key2 = decryptKey2.getDecrypted();

        System.out.println(Arrays.toString(key1));
        System.out.println(Arrays.toString(iv));
        System.out.println(Arrays.toString(key2));

        AesDecrypt aesDecrypt = new AesDecrypt(ciphertext.getCiphertext(), key1, iv);

        byte[] msg = aesDecrypt.getDecrypted();

        System.out.println(Arrays.toString(ciphertext.getCiphertext()));
        System.out.println(Arrays.toString(msg));

        String message = new String(msg);
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println();

        System.out.println(message);

         */
    }
}
