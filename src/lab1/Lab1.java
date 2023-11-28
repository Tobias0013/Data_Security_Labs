package lab1;

public class Lab1 {
    private ReadKeyStore readKeyStore;
    private ReadCiphertext ciphertext;
    private RsaDecrypt decryptKey1;
    private RsaDecrypt decryptIv;
    private RsaDecrypt decryptKey2;
    private AesDecrypt aesDecrypt;


    public Lab1() {
        this.readKeyStore = new ReadKeyStore().setDefaultValues();
        this.ciphertext = new ReadCiphertext().setDefaultValue();
        this.aesDecrypt = new AesDecrypt();
    }

    public void decryptCiphertext(){
        String pathCiphertext = "src/lab1/files/ciphertext.enc";
        String pathKeyStore = "src/lab1/files/lab1Store";

        this.decryptKey1 = new RsaDecrypt(ciphertext.getEncKey1(), readKeyStore.getKey());
        this.decryptIv = new RsaDecrypt(ciphertext.getEncIv(), readKeyStore.getKey());
        this.decryptKey2 = new RsaDecrypt(ciphertext.getEncKey2(), readKeyStore.getKey());


        this.aesDecrypt = new AesDecrypt(ciphertext.getCiphertext(),
                decryptKey1.getDecrypted(), decryptIv.getDecrypted());

        System.out.println(aesDecrypt.getDecryptedStr());

    }

}
