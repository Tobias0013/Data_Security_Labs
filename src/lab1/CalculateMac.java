package lab1;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CalculateMac {

    private byte[] plaintext;
    private SecretKeySpec key;
    private Mac mac;
    private byte[] hash = null;
    String macHex = null;

    public CalculateMac(byte[] plaintext, SecretKeySpec key) {
        this.plaintext = plaintext;
        this.key = key;
        createMac();
    }

    public CalculateMac(byte[] plaintext, byte[] byteKey) {
        this.plaintext = plaintext;
        this.key = new SecretKeySpec(byteKey, "HmacMD5");
        createMac();
    }

    public String getMacHex() {
        if (macHex == null){
            calculateMac();
        }
        return macHex;
    }

    private void calculateMac(){
        try {
            mac.init(key);
            mac.update(plaintext);
            macHex = hex(mac.doFinal());
        }
        catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte aByte : bytes) {
            result.append(String.format("%02x", aByte));
        }
        return result.toString();
    }

    private void createMac() {
        try {
            mac = Mac.getInstance("HmacMD5");
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return macHex;
    }
}
