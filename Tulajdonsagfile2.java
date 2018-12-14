/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2018;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Merry Xmas
 */
public class Tulajdonsagfile2 extends JFrame implements ActionListener {

    private JButton btTalloz = new JButton("Tallóz...");
    private JLabel lbFiletulajdonsag = new JLabel("Nincs kiválasztott fájl.");
    private JFileChooser fc = new JFileChooser();

    public Tulajdonsagfile2() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("File tulajdonságai");
        setSize(300, 300);
        setLocationRelativeTo(this);
        JPanel pn = new JPanel();
        pn.add(btTalloz);
        add(pn, BorderLayout.NORTH);
        btTalloz.addActionListener(this);
        lbFiletulajdonsag.setHorizontalAlignment(SwingConstants.CENTER);
        add(lbFiletulajdonsag);
        
        setVisible(true);

    }

    static String datumido(long utc) {
        DateFormat datumidoformazo = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        return datumidoformazo.format(new Date(utc));
    }

    private void cimkefrissit() {
        File file = fc.getSelectedFile();
        lbFiletulajdonsag.setText("<html>"
                + "útvonal:" + file.getPath() + "<br>"
                + "absz útvonal:" + file.getAbsolutePath() + "<br>"
                + "fájl neve: " + file.getName() + "<br>"
                + "Méret: " + file.length() + " bájt" + "<br>"
                + "Olvasható?" + (file.canWrite() ? "igen" : "nem") + "<br>"
                + "Írható?" + (file.canWrite() ? "igen" : "nem") + "<br>"
                + "Rejtett? " + (file.isHidden() ? "igen" : "nem") + "<br>"
                + "Utolsó Módosítás:" + datumido(file.lastModified()) + "</html>");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fc.setCurrentDirectory(new File("."));
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setDialogTitle("Fájl kiválasztása");
        fc.setMultiSelectionEnabled(true);
        if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            cimkefrissit();
        }
        
    }
    public static void main(String[] args) {
        new Tulajdonsagfile2();
    }

}
