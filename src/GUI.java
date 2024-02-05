import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JCheckBox checkBox;
    private JPanel panelMain;
    private JButton btnPrevious;
    private JButton btnSave;
    private JButton btnNext;
    private JTextField textField1;
    private JRadioButton radioBtn1;
    private JRadioButton radionBtn2;
    private JRadioButton radionBtn3;
    private int indexAktualniDeskovky = 0;
    private final SpravceDeskovek spravceDeskovek;

    public GUI(SpravceDeskovek spravceDeskovek) {
        this.spravceDeskovek = spravceDeskovek;
        initComponents();
        ukazDeskovku();
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPrevious.setEnabled(true);
                if (indexAktualniDeskovky < spravceDeskovek.getPocetDeskovek() - 1) {
                    indexAktualniDeskovky++;
                    ukazDeskovku();
                }else{
                    btnNext.setEnabled(false);
                }
            }
        });
        btnPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNext.setEnabled(true);
                if (indexAktualniDeskovky > 0) {
                    indexAktualniDeskovky--;
                    ukazDeskovku();
                }else{
                    btnPrevious.setEnabled(false);
                }
            }
        });
        btnSave.addActionListener(e -> ulozDeskovku());
    }

    private void initComponents() {
        setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Deskovky");
        pack();
    }

    private void ulozDeskovku() {
        String nazevHry = textField1.getText();
        boolean zakoupeno = checkBox.isSelected();
        int oblibenost = 1;
        if (radionBtn2.isSelected()) {
            oblibenost = 2;
        } else if (radionBtn3.isSelected()) {
            oblibenost = 3;
        }
        Deskovka aktualniDeskovka = spravceDeskovek.getDeskovka(indexAktualniDeskovky);
        aktualniDeskovka.setNazevHry(nazevHry);
        aktualniDeskovka.setZakoupeno(zakoupeno);
        aktualniDeskovka.setOblibenost(oblibenost);
    }

    private void ukazDeskovku() {
        if (spravceDeskovek.getPocetDeskovek() == 0) {
            textField1.setText("");
            checkBox.setSelected(false);
            radioBtn1.setSelected(true);
        }else {
            Deskovka aktualniDeskovka = spravceDeskovek.getDeskovka(indexAktualniDeskovky);
            textField1.setText(aktualniDeskovka.getNazevHry());
            checkBox.setSelected(aktualniDeskovka.isZakoupeno());
            switch (aktualniDeskovka.getOblibenost()) {
                case 1:
                    radioBtn1.setSelected(true);
                    break;
                case 2:
                    radionBtn2.setSelected(true);
                    break;
                case 3:
                    radionBtn3.setSelected(true);
                    break;
            }
        }
    }
}