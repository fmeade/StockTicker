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

    protected JFrame mainFrame;
    private JPanel stockPanel;
    private JLabel stockInfo;
    private Processing process;
    private String stockData;
    private Boolean update = true;
    private int stockNum;

    public Platform() throws Exception {

        mainFrame = new JFrame();
        stockPanel = new JPanel();
        stockData = new String();
        stockInfo = new JLabel();
        stockNum = 8;



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

            stockPanel.setBackground(new Color(0, 0, 0));
            mainFrame.add(stockPanel, BorderLayout.CENTER);

            mainFrame.setVisible(true);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Platform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stockInfo() throws Exception 
    {
        process = new Processing(stockNum);
        stockData = process.process(stockNum);

        stockInfo.setText(stockData);
        stockInfo.setForeground(Color.white);

        stockPanel.add(stockInfo);
    }
    
}
