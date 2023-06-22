package com.amrita.jpl.mp.u4cys21051;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Java Swing Simple Text Editor
 *
 * Usage:
 *   A simple text editor that have a text box to enter texts and save and load buttons
 *   that will save the text file and load it when the text file is there.
 *
 * @author Nithin S
 */

public class texteditor extends JFrame {
    private JTextArea textbox;

    public texteditor() {
        setTitle("Java Swing Simple Text Editor");
        setSize(450, 330);

        textbox = new JTextArea();

        JButton savefilebutton = new JButton("Save File");
        savefilebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        JButton loadfilebutton = new JButton("Load File");
        loadfilebutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadFromFile();
            }
        });

        JPanel button = new JPanel();
        button.add(savefilebutton);
        button.add(loadfilebutton);

        getContentPane().add(new JScrollPane(textbox), BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    private void saveToFile() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name:", "Input", JOptionPane.PLAIN_MESSAGE);
        if (fileName != null && !fileName.isEmpty()) {
            if (!fileName.endsWith(".txt")) {
                JOptionPane.showMessageDialog(this, "Invalid file format. Use .txt extension.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            File file = new File(fileName);
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(textbox.getText());
                JOptionPane.showMessageDialog(this, "File saved successfully.", "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadFromFile() {
        String fileName = JOptionPane.showInputDialog(this, "Enter file name:", "Input", JOptionPane.PLAIN_MESSAGE);
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(fileName);
            if (file.exists()) {
                try (BufferedReader r = new BufferedReader(new FileReader(file))) {
                    StringBuilder s = new StringBuilder();
                    String l;
                    while ((l = r.readLine()) != null) {
                        s.append(l);
                        s.append("\n");
                    }
                    textbox.setText(s.toString());
                    JOptionPane.showMessageDialog(this, "File loaded successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error loading file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "File not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                texteditor te = new texteditor();
                te.setVisible(true);
            }
        });
    }
}
