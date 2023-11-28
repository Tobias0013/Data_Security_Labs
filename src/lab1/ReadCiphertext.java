package lab1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ReadCiphertext {
    private Path path;
    private byte[] data = null;
    private byte[] encKey1 = null;
    private byte[] encIv = null;
    private byte[] encKey2 = null;
    private byte[] ciphertext = null;

    public ReadCiphertext(String path) {
        this.path = Paths.get(path);
    }

    public ReadCiphertext(Path path) {
        this.path = path;
    }

    public ReadCiphertext() {
    }

    public ReadCiphertext setDefaultValue(){
        return new ReadCiphertext("src/lab1/files/ciphertext.enc");
    }

    public byte[] getData() {
        if (data == null){
            run();
        }
        return data;
    }

    public byte[] getEncKey1() {
        if (encKey1 == null){
            run();
        }
        return encKey1;
    }

    public byte[] getEncIv() {
        if (encIv == null){
            run();
        }
        return encIv;
    }

    public byte[] getEncKey2() {
        if (encKey2 == null){
            run();
        }
        return encKey2;
    }

    public byte[] getCiphertext() {
        if (ciphertext == null){
            run();
        }
        return ciphertext;
    }

    public void run(){
        try {
            readBytes();
        } catch (IOException e) {
            System.out.println("error in ReadCiphertext run()"); // TODO: 2023-11-28 Error message?
            throw new RuntimeException(e);
        }
        readEncKey1();
        readEncIv();
        readEncKey2();
        readCiphertext();
    }

    private void readBytes() throws IOException {
        this.data = Files.readAllBytes(path);
    }

    private void readEncKey1(){
        this.encKey1 = Arrays.copyOfRange(data, 0, 128);
    }

    private void readEncIv(){
        this.encIv = Arrays.copyOfRange(data, 128, 256);
    }

    private void readEncKey2(){
        this.encKey2 = Arrays.copyOfRange(data, 256, 384);
    }

    private void readCiphertext(){
        this.ciphertext = Arrays.copyOfRange(data, 384, data.length);
    }

}
