package lab1;

import java.security.*;

public class VerifySign {
    private PublicKey key;
    private byte[] plaintext;
    private Signature myVerify;

    public VerifySign(byte[] plaintext, PublicKey key) {
        this.plaintext = plaintext;
        this.key = key;
        createVerify();
    }

    public boolean verify(byte[] sign){
        try {
            return myVerify.verify(sign);
        }
        catch (SignatureException e) {
            throw new RuntimeException(e);
        }
    }

    private void createVerify(){
        try {
            myVerify = Signature.getInstance("SHA1withRSA");
            myVerify.initVerify(key);
            myVerify.update(plaintext);
        }
        catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            throw new RuntimeException(e);
        }
    }
}
