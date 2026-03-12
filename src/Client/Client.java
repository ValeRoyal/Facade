
package Client;

import Facade.Facade;

/**
 * Cliente:
 * <p>
 * Demuestra el uso del patrón Facade. El cliente debe utilizar <b>exclusivamente</b>
 * la fachada y no interactuar directamente con las clases del subsistema.
 * </p>
 *
 * <h2>Flujo</h2>
 * <ol>
 *   <li>Escribe un archivo en disco con contenido cifrado.</li>
 *   <li>Lee el archivo y recupera el contenido descifrado.</li>
 *   <li><b>Limpia</b> el archivo {@code test.txt} al final de la ejecución (siempre, ocurra o no un error).</li>
 * </ol>
 *
 * @author Valen Aguilar
 */
public class Client {

    /**
     * Punto de entrada del programa.
     *
     * @param args argumentos de línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        String filePath = "test.txt";
        String originalContent = "¡Hola, patrón Facade en Java!";

        Facade facade = Facade.getInstance();

        try {
            facade.writeEncrypted(filePath, originalContent);

            String decryptedContent = facade.readDecrypted(filePath);

            System.out.println("Contenido original:   " + originalContent);
            System.out.println("Contenido descifrado: " + decryptedContent);
            System.out.println("¿Coinciden?: " + originalContent.equals(decryptedContent));
        } catch (Exception e) {
            System.err.println("Error ejecutando el ejemplo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Borrar el archivo siempre, incluso si hubo error
            try {
                java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(filePath));
            } catch (Exception ex) {
            }
        }
    }
}
