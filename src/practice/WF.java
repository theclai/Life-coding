package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WF {


    public static String getCountriesInfo(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url;
        url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }


    public static void main(String[] args) throws IOException {

        try {
            System.out.println(getCountriesInfo("https://jsonmock.hackerrank.com/api/countries/search?name=\"+un"+"page="+10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

