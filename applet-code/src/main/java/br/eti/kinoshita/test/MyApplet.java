package br.eti.kinoshita.test;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JApplet;
import javax.swing.JButton;

public class MyApplet extends JApplet {

    private static final long serialVersionUID = 7108887568514132420L;

    // --- Applet methods

    @Override
    public void init() {
        // Execute a job on the event-dispatching thread:
        // creating this applet's GUI.
        try {
            javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    createGUI();
                }
            });
        } catch (Exception e) {
            System.err.println("createGUI didn't successfully complete");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    // --- Swing methods

    public void createGUI() {
        JButton myButton = new JButton(new ButtonListener());
        getContentPane().add(myButton);
    }
    
    public static class ButtonListener extends AbstractAction {

        private static final long serialVersionUID = 9131870239786626138L;

        public ButtonListener() {
            putValue(Action.NAME, "Test");
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Button..");
        }
        
    }

}
