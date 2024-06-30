import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainForm mainForm = new MainForm(); // Mengganti dengan MainForm sebagai main frame
                mainForm.setVisible(true);
            }
        });
    }
}
