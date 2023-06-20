package com.amrita.jpl.cys21051.endsem;



import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A file management system that handles different types of files such as documents, images, and videos
 *
 * Usage:
 * Add a document by entering the document name, size, and type.
 * Add an image by entering the image name, size, and resolution.
 * Add a video by entering the video name, size, and duration.
 *
 * @author Nithin S
 * @version 0.5
 */

interface FileManager {
    void addFile(File file);
    void deleteFile(String fileName);
    void displayAllFiles();
    void saveToFile(String fileName);
    void loadFromFile(String fileName);
    List<File> getAllFiles(); // Add this method
}

class File {
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void displayFileDetails() {
        System.out.println("File Name: " + fileName);
        System.out.println("File Size: " + fileSize);
    }
}

class Document extends File {
    private String documentType;

    public Document(String fileName, int fileSize, String documentType) {
        super(fileName, fileSize);
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Document Type: " + documentType);
    }
}

class Image extends File {
    private String resolution;

    public Image(String fileName, int fileSize, String resolution) {
        super(fileName, fileSize);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Resolution: " + resolution);
    }
}

class Video extends File {
    private String duration;

    public Video(String fileName, int fileSize, String duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void displayFileDetails() {
        super.displayFileDetails();
        System.out.println("Duration: " + duration);
    }
}

class FileManagerImpl implements FileManager {
    private List<File> files;

    public FileManagerImpl() {
        files = new ArrayList<>();
    }

    public List<File> getAllFiles() {
        return files;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void deleteFile(String fileName) {
        File fileToRemove = null;
        for (File file : files) {
            if (file.getFileName().equals(fileName)) {
                fileToRemove = file;
                break;
            }
        }
        if (fileToRemove != null) {
            files.remove(fileToRemove);
        }
    }

    public void displayAllFiles() {
        for (File file : files) {
            file.displayFileDetails();
        }
    }

    public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(files);
            System.out.println("File details saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            files = (List<File>) ois.readObject();
            System.out.println("File details loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileManagementSystemUI extends JFrame {
    private FileManager fileManager;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField nameTextField;
    private JTextField sizeTextField;
    private JTextField typeTextField;
    private JComboBox<String> typeComboBox;

    private JTextField resolutionTextField;
    private JTextField durationTextField;


    public FileManagementSystemUI() {
        setTitle("21UCYS End Semester Assignment File Manager");
        fileManager = new FileManagerImpl();

        JLabel nameLabel = new JLabel("File Name:");
        JLabel sizeLabel = new JLabel("File Size:");
        JLabel typeLabel = new JLabel("File Type: ");
        JPanel fileTypePanel = new JPanel();
        JLabel fileTypeLabel = new JLabel("File Type:");
        String[] fileTypes = {"Document", "Image", "Video"};
        typeComboBox = new JComboBox<>(fileTypes);
        fileTypePanel.add(fileTypeLabel);
        fileTypePanel.add(typeComboBox);



        nameTextField = new JTextField(10);
        sizeTextField = new JTextField(10);
        typeTextField = new JTextField(10);


        JButton addButton = new JButton("Add File");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int size = Integer.parseInt(sizeTextField.getText());
                String selectedType = (String) typeComboBox.getSelectedItem();

                if (!name.isEmpty() && !sizeTextField.getText().isEmpty()) {
                    if (selectedType.equals("Documents")) {
                        JFrame documentFrame = new JFrame("Enter Document Type");
                        JLabel documentLabel = new JLabel("Document Type:");
                        JTextField documentTextField = new JTextField(20);
                        JButton submitButton = new JButton("Submit");

                        JPanel documentPanel = new JPanel(new FlowLayout());
                        documentPanel.add(documentLabel);
                        documentPanel.add(documentTextField);
                        documentPanel.add(submitButton);

                        submitButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String documentType = documentTextField.getText();
                                fileManager.addFile(new Document(name, size, documentType));
                                documentFrame.dispose();
                                displayFiles();
                                clearInputFields();
                            }
                        });

                        documentFrame.getContentPane().add(documentPanel);
                        documentFrame.pack();
                        documentFrame.setVisible(true);
                    } else if (selectedType.equals("Image")) {
                        String resolution = resolutionTextField.getText();
                        fileManager.addFile(new Image(name, size, resolution));
                        displayFiles();
                        clearInputFields();
                    } else if (selectedType.equals("Video")) {
                        String duration = durationTextField.getText();
                        fileManager.addFile(new Video(name, size, duration));
                        displayFiles();
                        clearInputFields();
                    }
                }
            }
        });


        JButton deleteButton = new JButton("Delete File");
        JButton refreshButton = new JButton("Refresh");


        tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");
        tableModel.addColumn("File Size");
        tableModel.addColumn("File Type");


        table = new JTable(tableModel);

        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(1, 6));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeTextField);
        inputPanel.add(typeComboBox);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int size = Integer.parseInt(sizeTextField.getText());

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String fileName = (String) tableModel.getValueAt(selectedRow, 0);
                    fileManager.deleteFile(fileName);
                    displayFiles();
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileManager.displayAllFiles();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void displayFiles() {
        tableModel.setRowCount(0);
        for (File file : fileManager.getAllFiles()) {
            tableModel.addRow(new Object[]{file.getFileName(), file.getFileSize()});
        }
    }

    private void clearInputFields() {
        nameTextField.setText("");
        sizeTextField.setText("");
        resolutionTextField.setText("");
        durationTextField.setText("");
    }

    private File findFileByName(String fileName) {
        for (File file : fileManager.getAllFiles()) {
            if (file.getFileName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FileManagementSystemUI();
            }
        });
    }
}

