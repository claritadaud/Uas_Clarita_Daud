import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiaryForm extends JDialog {
    private JTextField tanggalField;
    private JTextArea catatanArea;
    private JButton saveButton;
    private DiaryFrame diaryFrame;
    private Diary diary;
    private int rowIndex;

    public DiaryForm(DiaryFrame diaryFrame, Diary diary, int rowIndex) {
        this.diaryFrame = diaryFrame;
        this.diary = diary;
        this.rowIndex = rowIndex;

        setTitle(diary == null ? "Add Diary Entry" : "Edit Diary Entry");
        setSize(300, 300);
        setLocationRelativeTo(diaryFrame);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Tanggal:"));
        tanggalField = new JTextField(diary == null ? "" : diary.getTanggal());
        panel.add(tanggalField);

        panel.add(new JLabel("Catatan:"));
        catatanArea = new JTextArea(diary == null ? "" : diary.getCatatan(), 10, 20);
        JScrollPane scrollPane = new JScrollPane(catatanArea);
        panel.add(scrollPane);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tanggal = tanggalField.getText();
                String catatan = catatanArea.getText();

                if (diary == null) {
                    Diary newDiary = new Diary(tanggal, catatan);
                    diaryFrame.addDiary(newDiary);
                } else {
                    diary.setTanggal(tanggal);
                    diary.setCatatan(catatan);
                    diaryFrame.updateDiary(diary, rowIndex);
                }
                dispose();
            }
        });

        panel.add(saveButton);

        add(panel);
    }
}
