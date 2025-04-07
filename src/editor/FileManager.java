package editor;

import javax.swing.*;

public class FileManager {
    public static void openFile(JFrame parent, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            //File file = fileChooser.getSelectedFile();
            //TODO
        }
    }

    public static void saveFile(JFrame parent, JTextArea textArea) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
            //File file = fileChooser.getSelectedFile();
            //TODO
        }
    }

    public static void newFile(TextEditor textEditor, JTextArea textArea) {
        //TODO
    }
}
