package Client;

import Facade.Facade;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * Cliente:
 * <p>
 * Demuestra el uso del patrón Facade. El cliente utiliza exclusivamente la fachada
 * y muestra el resultado en una interfaz gráfica.
 * </p>
 *
 * @author Valen Aguilar
 */
public class Client {

    //Profe le puse la ventanita para que se vea más bonito, es rosita 
    public static void main(String[] args) {
        String filePath = "test.txt";
        String originalContent = "¡Hola, patrón Facade en Java!";

        Facade facade = Facade.getInstance();

        String textToShow;
        try {
            facade.writeEncrypted(filePath, originalContent);
            String decryptedContent = facade.readDecrypted(filePath);

            boolean coincide = originalContent.equals(decryptedContent);

            textToShow =
                    "Texto Original:\n" + originalContent + "\n\n" +
                    "Texto Descifrado:\n" + decryptedContent + "\n\n" +
                    "¿El texto original y cifrado coinciden?: " + coincide;

        } catch (Exception e) {
            textToShow = "ERROR\n\n" + e.getClass().getSimpleName() + ":\n" + e.getMessage();
        } finally {
            try {
                java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(filePath));
            } catch (Exception ex) {
            }
        }

        final String finalText = textToShow;
        
        SwingUtilities.invokeLater(() -> {
            // Ventana
            JFrame frame = new JFrame("Facade");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);

            // Panel principal (el “panel rosado” real)
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(new Color(255, 231, 249));
            panel.setPreferredSize(new Dimension(550, 300));

            // Área de texto (mejor que JLabel para multiline y wrap)
            JTextArea textArea = new JTextArea(finalText);
            textArea.setEditable(false);
            textArea.setFocusable(false);
            textArea.setOpaque(false); // para que se vea el rosado del panel
            textArea.setForeground(new Color(60, 63, 65));
            textArea.setFont(new Font("Cooper Black", Font.PLAIN, 24));
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBorder(null);

            // Centrado + márgenes
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(20, 20, 20, 20);

            panel.add(textArea, gbc);

            frame.setContentPane(panel);
            frame.pack();              // asegura 500x300
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
