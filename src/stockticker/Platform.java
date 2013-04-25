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
    private JLabel[] stockInfo;
    private Processing process;
    private String[] stockData;
    private Boolean update = true;
    
    public Platform() throws Exception {
                
        mainFrame = new JFrame();
        process = new Processing();   
        stockPanel = new JPanel();
        stockData = new String[9];
        stockInfo = new JLabel[9];

        for (int i = 0; i < stockInfo.length; i++) {
            stockData[i] = new String();
            stockInfo[i] = new JLabel();
        }
        
        stockInfo();
        
        mainFrame.setTitle("Live Stock Data for IT Companies");
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(new Dimension(1280, 50));
        mainFrame.setBackground(new Color(0, 0, 0));
        mainFrame.setResizable(false);
        
        stockPanel.setBackground(new Color(0, 0, 0));
        mainFrame.add(stockPanel, BorderLayout.CENTER);
        
        mainFrame.setVisible(true);
        
        try {
            Thread.sleep(60000);
            mainFrame.dispose();
        } catch (InterruptedException ex) {
            Logger.getLogger(Platform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stockInfo() {
        stockData = process.process();

        for (int i = 0; i < stockInfo.length; i++) {
            stockInfo[i].setText(stockData[i] + "     ");
            stockInfo[i].setForeground(Color.white);
        }
        
        for(int i=0;i<stockInfo.length;i++)
        {
            stockPanel.add(stockInfo[i]);
        }
    }
    
}
