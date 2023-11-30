package lab1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadSign {
    private byte[] signature = null;
    private Path path;

    public ReadSign(Path path) {
        this.path = path;
    }

    public ReadSign(String path) {
        this.path = Paths.get(path);
    }

    public byte[] getSignature() {
        if (signature == null){
            readBytes();
        }
        return signature;
    }

    private void readBytes(){
        try {
            signature = Files.readAllBytes(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ReadSign setValue1(){
        return new ReadSign("src/lab1/files/ciphertext.enc.sig1");
    }

    public static ReadSign setValue2(){
        return new ReadSign("src/lab1/files/ciphertext.enc.sig2");
    }
}
