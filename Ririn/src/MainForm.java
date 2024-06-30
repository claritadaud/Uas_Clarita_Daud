import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    
    public MainForm() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Welcome to Maria Magdalena Daut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400); // Ukuran frame disesuaikan
        setLocationRelativeTo(null); // Frame muncul di tengah layar

        // Panel utama dengan layout BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE); // Warna background disesuaikan

        // Label untuk menampilkan selamat datang
        JLabel welcomeLabel = new JLabel("Welcome to Mariana Klarita Daud");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Ukuran dan jenis font disesuaikan
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); // Posisi teks di tengah

        // Tambahkan label ke panel utama
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Tombol untuk membuka DiaryFrame
        JButton openDiaryButton = new JButton("Open Diary");
        openDiaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiaryFrame diaryFrame = new DiaryFrame();
                diaryFrame.setVisible(true);
            }
        });

        // Tambahkan tombol ke panel utama
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openDiaryButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Tambahkan panel utama ke frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Jalankan frame dalam Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainForm mainForm = new MainForm();
                mainForm.setVisible(true); // Tampilkan frame utama
            }
        });
    }
}
