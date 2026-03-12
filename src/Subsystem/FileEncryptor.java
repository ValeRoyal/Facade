
package Subsystem;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Subsistema: Realiza cifrado y descifrado simple utilizando codificación.
 * <p>
 * Para cumplir con el requerimiento de "cifrado y descifrado simple utilizando codificación",
 * esta implementación usa Base64 (codificación reversible).
 * </p>
 *
 * <h2>Responsabilidad</h2>
 * <ul>
 *   <li>Cifrar: convertir texto plano a Base64.</li>
 *   <li>Descifrar: convertir Base64 a texto plano.</li>
 * </ul>
 *
 * <h2>Advertencia</h2>
 * <p>
 * Base64 <strong>no es criptografía fuerte</strong>; es una codificación. Se usa aquí
 * por simplicidad académica para demostrar el patrón Facade.
 * </p>
 *
 * @author Valen Aguilar
 */

public class FileEncryptor {

    public String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(String encodedText) {
        byte[] decoded = Base64.getDecoder().decode(encodedText);
        return new String(decoded, StandardCharsets.UTF_8);
    }
}
