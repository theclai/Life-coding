package leetcode;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecode {
    Map<Integer,String> map=new HashMap<>();
    public String encode(String longUrl) {
        map.put(longUrl.hashCode(),longUrl);
        return "http://tinyurl.com/"+longUrl.hashCode();

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int code= Integer.parseInt(shortUrl.replace("http://tinyurl.com/",""));
        return map.get(code);

    }
}
