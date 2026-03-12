
package Facade;

import Subsystem.FileEncryptor;
import Subsystem.FileReader;
import Subsystem.FileWriter;

/**
 * Fachada (Facade / FileFacade):
 * <p>
 * Simplifica las operaciones complejas del subsistema ofreciendo métodos directos para:
 * </p>
 * <ul>
 *   <li>Escribir un archivo cifrado.</li>
 *   <li>Leer un archivo y devolver el contenido descifrado.</li>
 * </ul>
 *
 * <h2>Patrones aplicados</h2>
 * <ul>
 *   <li><b>Facade</b>: oculta la coordinación entre {@link FileWriter}, {@link FileReader} y {@link FileEncryptor}.</li>
 *   <li><b>Singleton</b>: garantiza una única instancia global de la fachada.</li>
 * </ul>
 *
 * <h2>Uso esperado</h2>
 * <p>
 * El cliente debe interactuar <b>exclusivamente</b> con esta clase, sin acceder directamente al subsistema.
 * </p>
 *
 * @author Valen Aguilar
 */

public class Facade {

    private static Facade instance;

    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FileEncryptor fileEncryptor;

    /**
     * Constructor privado para forzar el patrón Singleton.
     */
    private Facade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileEncryptor = new FileEncryptor();
    }

    /**
     * Obtiene la instancia única de la fachada.
     * <p>
     * Implementación con inicialización perezosa (lazy initialization).
     * </p>
     *
     * @return instancia única de {@link Facade}.
     */
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    /**
     * Escribe en un archivo el contenido cifrado.
     *
     * @param filePath ruta del archivo destino.
     * @param plainContent contenido en claro a cifrar y escribir.
     * @throws java.io.IOException si ocurre un error de E/S.
     */
    public void writeEncrypted(String filePath, String plainContent) throws java.io.IOException {
        String encrypted = fileEncryptor.encrypt(plainContent);
        fileWriter.writeToFile(filePath, encrypted);
    }

    /**
     * Lee un archivo que contiene texto cifrado (Base64) y devuelve el texto descifrado.
     *
     * @param filePath ruta del archivo a leer.
     * @return contenido descifrado (texto plano).
     * @throws java.io.IOException si ocurre un error de E/S.
     * @throws IllegalArgumentException si el contenido leído no es Base64 válido.
     */
    public String readDecrypted(String filePath) throws java.io.IOException {
        String encrypted = fileReader.readFromFile(filePath);
        return fileEncryptor.decrypt(encrypted);
    }
}
