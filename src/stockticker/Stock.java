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

    private String stockTag;
    private String name;
    private String price;
    protected String time;
    private String pricechg;
    private String percentchg;
    private String result;
    private String stockURL;
    private String stockString;
    private JSONObject stockData;

    public Stock(String stock) throws Exception {
        stockTag = stock;
    }

    public void readStock(int arrayIndex) throws Exception {
        try{
        stockURL = readURL(stockTag);
        stockString = stockURL.substring(4, stockURL.length() - 1);
        stockData = JSONObject.fromObject(stockString);
        
        result = "";
        
        time = stockData.get("lt") + "   ";
        
        name = "" + stockData.get("t") + ":  ";
        price = "" + stockData.get("l_cur");
        percentchg = " (" + stockData.get("cp") + "%)";

        result = time + name + price + percentchg;
        
        } catch (IOException ex){
            result = time + stockData.get("t") + ":  " + "No Data";
        }
    }

    public String getresult() {
        return result;
    }

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
    }
}
