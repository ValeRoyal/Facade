
package Subsystem;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FileEncryptor {

    public String encrypt(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public String decrypt(String encodedText) {
        byte[] decoded = Base64.getDecoder().decode(encodedText);
        return new String(decoded, StandardCharsets.UTF_8);
    }
}
