package lab1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadMac {
    private Path path;
    private byte[] byteMac = null;
    private String macStr = null;

    public ReadMac(Path path) {
        this.path = path;
    }

    public ReadMac(String path) {
        this.path = Paths.get(path);
    }

    public ReadMac() {
    }

    public String getMacStr() {
        if (macStr == null){
            readMac();
        }
        return macStr;
    }

    private void readMac(){
        try {
            byteMac = Files.readAllBytes(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        toMacStr();
    }

    private void toMacStr(){
        macStr = new String(byteMac);
    }

    @Override
    public String toString() {
        return macStr;
    }

    public static ReadMac setValueMac1(){
        return new ReadMac("src/lab1/files/ciphertext.mac1.txt");
    }

    public static ReadMac setValueMac2(){
        return new ReadMac("src/lab1/files/ciphertext.mac2.txt");
    }
}