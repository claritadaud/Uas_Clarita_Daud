import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DiaryFrame extends JFrame {
    private ArrayList<Diary> diaryList;
    private DefaultTableModel tableModel;
    private JTable diaryTable;
    private JTextArea detailTextArea;

    public DiaryFrame() {
        // Pengaturan JFrame
        setTitle("Diary Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        diaryList = new ArrayList<>();

        // Kolom untuk JTable
        String[] columns = {"Tanggal"};
        tableModel = new DefaultTableModel(columns, 0);
        diaryTable = new JTable(tableModel);

        // Panel untuk tombol dan detail
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Diary");
        JButton editButton = new JButton("Edit Diary");
        JButton deleteButton = new JButton("Delete Diary");
        detailTextArea = new JTextArea(10, 30);
        detailTextArea.setEditable(false);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiaryForm diaryForm = new DiaryForm(DiaryFrame.this, null, -1);
                diaryForm.setVisible(true);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = diaryTable.getSelectedRow();
                if (selectedRow != -1) {
                    Diary selectedDiary = diaryList.get(selectedRow);
                    DiaryForm diaryForm = new DiaryForm(DiaryFrame.this, selectedDiary, selectedRow);
                    diaryForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(DiaryFrame.this, "Select a diary to edit");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = diaryTable.getSelectedRow();
                if (selectedRow != -1) {
                    diaryList.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                    detailTextArea.setText(""); // Clear detail area after delete
                } else {
                    JOptionPane.showMessageDialog(DiaryFrame.this, "Select a diary to delete");
                }
            }
        });

        // Menambahkan listener untuk menampilkan detail saat baris dipilih
        diaryTable.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = diaryTable.getSelectedRow();
            if (selectedRow != -1) {
                Diary selectedDiary = diaryList.get(selectedRow);
                detailTextArea.setText(selectedDiary.getCatatan());
            }
        });

        JScrollPane detailScrollPane = new JScrollPane(detailTextArea);

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Menambahkan JTable ke JScrollPane
        JScrollPane tableScrollPane = new JScrollPane(diaryTable);

        // Menambahkan komponen ke JFrame
        add(tableScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
        add(detailScrollPane, BorderLayout.SOUTH);
    }

    public void addDiary(Diary diary) {
        diaryList.add(diary);
        Object[] row = {diary.getTanggal()};
        tableModel.addRow(row);
    }

    public void updateDiary(Diary diary, int rowIndex) {
        diaryList.set(rowIndex, diary);
        tableModel.setValueAt(diary.getTanggal(), rowIndex, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DiaryFrame().setVisible(true);
            }
        });
    }
}
