package userinterface.swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import userinterface.ImageViewer;

public class ApplicationFrame extends JFrame {

    private ImageViewer imageViewer;
    private ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Browser");
        this.factory = factory;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.createComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createComponents() {
        this.add(createImagePanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        imageViewer = panel;
        return panel;
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(factory.create(label));
        return button;
    }

}
