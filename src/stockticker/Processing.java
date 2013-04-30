package stockticker;

import java.util.logging.*;

/**
 * Builds array of Stock objects and their String of data
 *
 * @author forrest_meade
 */
public class Processing {
    // Instance variable - holds stock string
    private String stockData;
    // Instance variable - Stock object
    private Stock stock;
    // Instance variable - Stock tag
    protected final String[] stockID = {"GOOG", "MSFT", "AAPL", "RAX", "YHOO", "FB", "HPQ", "DELL", "CSCO"};

    /**
     * Instantiates the Instance variables
     * 
     * @param i stock index
     * @throws Exception from calling the Stock class
     */
    public Processing(int i) throws Exception {
        stockData = new String();
        stock = new Stock(stockID[i]);
    }// end Processing constructor

    /**
     * Calls the readStock and getResult methods of Stock
     * 
     * @param i stock index
     * @return the stock string
     */
    public String process(int i) {
        try {
                stock.readStock(i);
                stockData = stock.getresult();
                
        } catch (Exception ex) {
            Logger.getLogger(StockTicker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stockData;
    }// end process method
}// end Processing class
