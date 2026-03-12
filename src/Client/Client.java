
package Client;

import Facade.Facade;

public class Client {

    public static void main(String[] args) {
        String filePath = "test.txt";
        String originalContent = "¡Hola, patrón Facade en Java!";

        Facade facade = Facade.getInstance();

        facade.writeEncryptedFile(filePath, originalContent);

        String decryptedContent = facade.readDecryptedFile(filePath);

        System.out.println("Contenido original:   " + originalContent);
        System.out.println("Contenido descifrado: " + decryptedContent);
        System.out.println("Coinciden: " + originalContent.equals(decryptedContent));
    }
}
