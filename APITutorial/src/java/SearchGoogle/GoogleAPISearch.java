/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchGoogle;

import org.netbeans.saas.RestResponse;
import org.netbeans.saas.RestConnection;
//import org.codehaus.jettison.json.JSONArray; 
//import org.codehaus.jettison.json.JSONObject;  

/**
 *
 * @author Richard
 */
public class GoogleAPISearch {

    public GoogleAPISearch() {
    }

    public String searchGoogleAPI(String keyword) {
        String API_key = "AIzaSyAABKsQey-XPjwR-wtUdWPtf7VqS-MXS7k";
        String SEARCH_ID_cx = "000982308662190301302:sb29kalgdhs";
        keyword = keyword.replace(" ", "+");
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{};
        String strResponse = "";
        RestConnection conn = new RestConnection("https://www.googleapis.com/customsearch/v1?key=" + API_key + "&cx=" + SEARCH_ID_cx + "&q=" + keyword + "&num=5", pathParams, queryParams);
        try {
            RestResponse response = conn.get();
            strResponse = response.getDataAsString();
//            JSONObject json = new JSONObject(strResponse);
//            JSONArray jsonarray = json.getJSONArray("items");
//            if (jsonarray != null && jsonarray.length() > 0) {
//                snippet = jsonarray.getJSONObject(0).getString("snippet");
            }catch (Exception e) {
            System.out.println(e.getMessage());
        }
            return strResponse;
        }
    
    

    public static void main(String[] args) {
        GoogleAPISearch g = new GoogleAPISearch();
        System.out.println(g.searchGoogleAPI("Monash University"));
    }
}
