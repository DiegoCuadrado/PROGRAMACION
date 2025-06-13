package app;

import gui.AkihabaraGUI;

import javax.swing.SwingUtilities;

public class MainGUIApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AkihabaraGUI());
    }
}

