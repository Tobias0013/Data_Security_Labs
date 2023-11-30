package lab1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class ReadPublicKey {
    private PublicKey key = null;
    private byte[] bytes;
    private Path path;

    public ReadPublicKey(Path path) {
        this.path = path;
    }

    public ReadPublicKey(String path) {
        this.path = Paths.get(path);
    }

    public PublicKey getKey() {
        if (key == null){
            readKey();
        }
        return key;
    }

    private void readKey(){
        readBytes();
        InputStream in = new ByteArrayInputStream(bytes);

        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cert = cf.generateCertificate(in);
            key = cert.getPublicKey();
        }
        catch (CertificateException e) {
            throw new RuntimeException(e);
        }
    }

    private void readBytes(){
        try {
            bytes = Files.readAllBytes(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ReadPublicKey setDefaultValue() {
        return new ReadPublicKey("src/lab1/files/lab1Sign.cert");
    }
}
