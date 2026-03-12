
package Facade;

import Subsystem.FileEncryptor;
import Subsystem.FileReader;
import Subsystem.FileWriter;

public class Facade {

    private static Facade instance;

    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FileEncryptor fileEncryptor;

    private Facade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileEncryptor = new FileEncryptor();
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    // Escribe el contenido cifrado en el archivo
    public void writeEncryptedFile(String filePath, String plainContent) {
        String encrypted = fileEncryptor.encrypt(plainContent);
        fileWriter.writeToFile(filePath, encrypted);
    }

    // Lee el contenido del archivo y lo descifra
    public String readDecryptedFile(String filePath) {
        String encrypted = fileReader.readFromFile(filePath);
        return fileEncryptor.decrypt(encrypted);
    }
}
