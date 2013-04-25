package stockticker;

import java.util.logging.*;

/**
 * Builds array of Stock objects and their String of data
 *
 * @author forrest_meade
 */
public class Processing {

    private String[] stockData = new String[9];
    private Stock[] stock = new Stock[9];
    protected final String[] stockID = {"GOOG", "MSFT", "AAPL", "RAX", "YHOO", "FB", "HPQ", "DELL", "CSCO"};

    public Processing() throws Exception {
        for (int i = 0; i < stock.length; i++) {
            stock[i] = new Stock(stockID[i]);
        }
    }

    public String[] process() {
        try {
            for (int i = 0; i < stock.length; i++) {

                stock[i].readStock(i);
                stockData[i] = stock[i].getresult();
            }
        } catch (Exception ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stockData;
    }
}
