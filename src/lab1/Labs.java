package lab1;

public class Labs {
    private AesDecrypt message;
    private RsaDecrypt key1;
    private RsaDecrypt iv;
    private RsaDecrypt key2;

    public Labs() {
        this.message = new AesDecrypt();
    }

    public String getPlaintext() {
        return message.getDecryptedStr();
    }

    public void decryptCiphertext(){ // Lab1, Task1/Task2
        ReadKeyStore readKeyStore = ReadKeyStore.setDefaultValues();
        ReadCiphertext ciphertext = ReadCiphertext.setDefaultValue();

        this.key1 = new RsaDecrypt(ciphertext.getEncKey1(), readKeyStore.getKey());
        this.iv = new RsaDecrypt(ciphertext.getEncIv(), readKeyStore.getKey());
        this.key2 = new RsaDecrypt(ciphertext.getEncKey2(), readKeyStore.getKey());

        this.message = new AesDecrypt(ciphertext.getCiphertext(),
                key1.getDecrypted(), iv.getDecrypted());

        System.out.println("-----------Message in plaintext-----------");
        System.out.println();
        System.out.println(getPlaintext());
        System.out.println();
    }

    public void compareMac(){ // Lab2, Task3
        ReadMac mac1 = ReadMac.setValueMac1();
        ReadMac mac2 = ReadMac.setValueMac2();

        CalculateMac mac = new CalculateMac(message.getDecrypted(), key2.getDecrypted());

        System.out.println("MAC comparing result: ");
        if (mac.getMacHex().equals(mac1.getMacStr())) {
            System.out.println("MAC matches that of ciphertext.mac1.txt");
        }
        else if (mac.getMacHex().equals(mac2.getMacStr())) {
            System.out.println("MAC matches that of ciphertext.mac2.txt");
        }
        else {
            System.out.println("MAC does not match with any MACs");
        }
        System.out.println();
    }

    public void compareSignature(){ // Lab2, Task4
        ReadPublicKey publicKey = ReadPublicKey.setDefaultValue();
        ReadSign cert1 = ReadSign.setValue1();
        ReadSign cert2 = ReadSign.setValue2();
        VerifySign verify = new VerifySign(message.getDecrypted(), publicKey.getKey());

        System.out.println("Signature comparing result: ");
        if (verify.verify(cert1.getSignature())){
            System.out.println("Signature match with that of ciphertext.enc.sig1");
        }
        else if (verify.verify(cert2.getSignature())){
            System.out.println("Signature match with that of ciphertext.enc.sig2");
        }
        else {
            System.out.println("Signature does not match with any signatures");
        }
        System.out.println();
    }

}
