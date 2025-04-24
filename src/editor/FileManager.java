package editor;

import javax.swing.*;
import java.io.*;

public class FileManager {
    public static void openFile(TextEditor textEditor, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(textEditor) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textEditor.currentFile = file;
                textArea.setText("");
                String temp;
                do {
                    temp = reader.readLine();
                    textArea.append(temp + "\n");
                }while (temp != null);
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("error opening file");
            } catch (IOException e) {
                throw new RuntimeException("error reading file");
            }
        }
    }

    public static void saveFile(TextEditor textEditor, JTextArea textArea) {
        if (textEditor.currentFile == null){
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(textEditor) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                    textEditor.currentFile = file;
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException("error saving the file");
                }
            }
        }
        else{
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(textEditor.currentFile));
                writer.write(textArea.getText());
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException("error saving the file");
            }
        }
    }

    public static void newFile(TextEditor textEditor, JTextArea textArea) {
        textEditor.currentFile = null;
        textArea.setText("");
    }
}
