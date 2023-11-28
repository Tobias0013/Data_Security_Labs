package lab1;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;

public class ReadKeyStore {
    private RSAPrivateKey key = null;
    private String path;
    private char[] storePassword;
    private String alias;
    private char[] keyPassword;

    public ReadKeyStore(String path, char[] storePasswrod, String alias, char[] keyPassword) {
        this.path = path;
        this.storePassword = storePasswrod;
        this.alias = alias;
        this.keyPassword = keyPassword;
    }

    public ReadKeyStore() {
    }

    public ReadKeyStore setDefaultValues(){
        return new ReadKeyStore("src/lab1/files/lab1Store", "lab1StorePass".toCharArray(),
                "lab1EncKeys", "lab1KeyPass".toCharArray());
        // TODO: 2023-11-28 TA BORT
        // this.path = "src/lab1/files/lab1Store";
        // this.storePassword = "lab1StorePass".toCharArray();
        // this.alias = "lab1EncKeys";
        // this.keyPassword = "lab1KeyPass".toCharArray();
    }

    public RSAPrivateKey getKey() {
        if (this.key == null){
            loadKey();
        }
        return key;
    }

    private void loadKey(){
        try {
            //start by loading keystore
            KeyStore myStore = KeyStore.getInstance("JCEKS");
            FileInputStream loadFile = new FileInputStream(this.path);
            //filename and password that protects the keystore
            myStore.load(loadFile, this.storePassword);
            loadFile.close();
            //load key
            this.key = (RSAPrivateKey) myStore.getKey(this.alias, this.keyPassword);

        }
        catch (UnrecoverableKeyException | CertificateException | KeyStoreException | IOException |
               NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


}
