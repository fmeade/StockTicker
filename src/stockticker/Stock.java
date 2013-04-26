package stockticker;

import java.io.*;
import java.net.*;
import net.sf.json.*;

/**
 * Creates a single stock object to represent one tag
 *
 * @author forrest_meade
 */
public class Stock {

    // Instance variable - stock tag
    private String stockTag;
    // Instance variables - stock info
    private String name;
    private String price;
    protected String time;
    private String percentchg;
    // Instance variable - stock string
    private String result;
    // Instance variable - read stock
    private String stockURL;
    private String stockString;
    private JSONObject stockData;

    /**
     * Instantiates the stock tag
     *
     * @param stock stock tag
     */
    public Stock(String stock) {
        stockTag = stock;
    }

    /**
     * Reads the stock into a String
     *
     * @param arrayIndex stock index
     * @throws Exception from the readURL method
     */
    public void readStock(int arrayIndex) throws Exception {
        try {
            /* reads and creates a JSONObject */
            stockURL = readURL(stockTag);
            stockString = stockURL.substring(4, stockURL.length() - 1);
            stockData = JSONObject.fromObject(stockString);

            /* gets the stock data */
            time = stockData.get("lt") + "   ";
            name = "" + stockData.get("t") + ":  ";
            price = "" + stockData.get("l_cur");
            percentchg = " (" + stockData.get("cp") + "%)";

            result = time + name + price + percentchg;

        } catch (IOException ex) {
            result = time + stockTag + ":  " + "No Data";
        }
    }//end readStock method

    /**
     * Returns result
     * 
     * @return result
     */
    public String getresult() {
        return result;
    }// end getresult method

    /**
     * Reads from the URL
     *
     * @param webservice URL
     * @return the data on the URL
     * @throws Exception invalid URL
     */
    public String readURL(String stock) throws Exception {
        String stockURL = "http://finance.google.com/finance/info?client=ig&q=" + stock;
        URL oracle = new URL(stockURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        String result = "";

        while ((inputLine = in.readLine()) != null) {
            result = result + inputLine;
        }

        in.close();
        return result;
    }// end readURL method
}// end Stock class
