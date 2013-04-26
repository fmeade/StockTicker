package stockticker;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import static javax.swing.JFrame.*;

/**
 * GUI for Stick Ticker Tape
 *
 * @author forrest_meade
 */
public class Platform {

    // Instance variables - frame, panel, and stock label
    protected JFrame mainFrame;
    private JPanel stockPanel;
    private JLabel stockInfo;
    // Instance variables - Processing object
    private Processing process;
    // Instance variables - Holds stock string
    private String stockData;
    // Instance variables - Activates loop
    private Boolean update = true;
    // Instance variables - Index for stock
    private int stockNum;
    // Instance variables - Size for the screen and window
    private Dimension screenSize;
    private Dimension windowSize;

    /**
     * Builds the window and updates the stock every 3 seconds
     * 
     * @throws Exception from calling the stockInfo method
     */
    public Platform() throws Exception {

        /* Instantiates the window instance variables */
        mainFrame = new JFrame();
        stockPanel = new JPanel();
        stockData = new String();
        stockInfo = new JLabel();
        stockNum = 8;

        /* loops and updates the stock */
        while (update) {
            if (stockNum == 8) {
                stockNum = 0;
            } else {
                stockNum++;
            }
            
            
            stockInfo();

            mainFrame.setTitle("Live Stock Data for IT Companies");
            mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            mainFrame.setLayout(new BorderLayout());
            mainFrame.setSize(new Dimension(350, 50));
            mainFrame.setBackground(new Color(0, 0, 0));
            mainFrame.setResizable(false);
            mainFrame.setAlwaysOnTop(true);
            
            screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            windowSize = mainFrame.size();
            
            mainFrame.setLocation((int)screenSize.getWidth()-mainFrame.getWidth(),
                                  (int)screenSize.getHeight()-mainFrame.getHeight());

            stockPanel.setBackground(new Color(0, 0, 0));
            mainFrame.add(stockPanel, BorderLayout.CENTER);

            mainFrame.setVisible(true);

            /* Sleeps the update */
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Platform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Calls the process class and adds the stock string to the panel
     * 
     * @throws Exception from calling the process method in the Processing method
     */
    public void stockInfo() throws Exception 
    {
        process = new Processing(stockNum);
        stockData = process.process(stockNum);

        stockInfo.setText(stockData);
        stockInfo.setForeground(Color.white);

        stockPanel.add(stockInfo);
    }// end stockInfo method
    
}// end Platform class
