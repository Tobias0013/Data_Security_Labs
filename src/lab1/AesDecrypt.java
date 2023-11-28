package lab1;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.interfaces.RSAPrivateKey;
import java.util.Arrays;

public class AesDecrypt {
    private Cipher dec;
    private SecretKey key;
    private IvParameterSpec iv;
    private byte[] decrypted = null;
    private byte[] ciphertext = null;

    public AesDecrypt(byte[] ciphertext, SecretKey key, IvParameterSpec iv) {
        this.ciphertext = ciphertext;
        this.key = key;
        this.iv = iv;
        createCipher();
    }

    public AesDecrypt(byte[] ciphertext, byte[] byteKey, byte[] byteIv) {
        SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
        IvParameterSpec iv = new IvParameterSpec(byteIv);

        this.ciphertext = ciphertext;
        this.iv = iv;
        this.key = key;
        createCipher();
    }

    public AesDecrypt() {
    }

    public void setValues(byte[] ciphertext, byte[] byteKey, byte[] byteIv){
        SecretKeySpec key = new SecretKeySpec(byteKey, "AES");
        IvParameterSpec iv = new IvParameterSpec(byteIv);

        this.ciphertext = ciphertext;
        this.iv = iv;
        this.key = key;
        createCipher();
    }

    public byte[] getDecrypted() {
        if (decrypted == null){
            decrypt();
        }
        return decrypted;
    }

    public String getDecryptedStr(){
        if (decrypted == null){
            decrypt();
        }
        return new String(decrypted);
    }

    private void createCipher(){
        try{
            dec = Cipher.getInstance("AES/CBC/PKCS5Padding");
            dec.init(Cipher.DECRYPT_MODE, this.key, this.iv);
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private void decrypt(){
        try {
            this.decrypted = dec.doFinal(this.ciphertext);
        }
        catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

}
