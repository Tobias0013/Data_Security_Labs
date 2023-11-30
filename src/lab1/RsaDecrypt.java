package lab1;

import javax.crypto.Cipher;
import java.security.interfaces.RSAPrivateKey;

public class RsaDecrypt {
    private byte[] decrypted = null;
    private byte[] ciphertext;
    private RSAPrivateKey privateKey;
    private Cipher dec;

    public RsaDecrypt(byte[] ciphertext, RSAPrivateKey privateKey) {
        this.ciphertext = ciphertext;
        this.privateKey = privateKey;

        createCipher();
    }

    public byte[] getDecrypted() {
        if (decrypted == null){
            decryptText();
        }
        return decrypted;
    }

    private void createCipher(){
        try{
            dec = Cipher.getInstance("RSA");
            dec.init(Cipher.DECRYPT_MODE, this.privateKey);
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    private void decryptText(){
        try{
            this.decrypted = new byte[dec.getOutputSize(ciphertext.length)];
            decrypted = dec.doFinal(ciphertext, 0, ciphertext.length);
        }
        catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
