import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Class only for the automatic change of the variables
 */
public class FrameListener extends WindowAdapter {
    
    /**
     * Method to close the application only
     */
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}

