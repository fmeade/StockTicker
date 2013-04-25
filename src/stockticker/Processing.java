package stockticker;

import java.util.logging.*;

/**
 * Builds array of Stock objects and their String of data
 *
 * @author forrest_meade
 */
public class Processing {

    private String stockData = new String();
    private Stock stock;
    protected final String[] stockID = {"GOOG", "MSFT", "AAPL", "RAX", "YHOO", "FB", "HPQ", "DELL", "CSCO"};

    public Processing(int i) throws Exception {
            stock = new Stock(stockID[i]);
    }

    public String process(int i) {
        try {
                stock.readStock(i);
                stockData = stock.getresult();
                
        } catch (Exception ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stockData;
    }
}
