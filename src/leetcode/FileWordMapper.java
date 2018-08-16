package leetcode;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FileWordMapper {
    static ConcurrentHashMap<String,Set<String>> elasticSearch;
    public static void main(String[] args){
       // fileProcess();
        search("searchKey");

    }

    private static Set<String> search(String searchKey) {
        return elasticSearch.get(searchKey);
    }
/*
    private static void fileProcess(){
        while(readAllFileOneAfterAnother){
            File file = getTheFile();
            String word = readWordAfterWordFromTheFile(file);
            if(elasticSearch.get(word)==null){
                Set<String> set = new LinkedHashSet<>();
                set.add("file Name");
                elasticSearch.put(word,set);
            }else {
                Set<String> set = elasticSearch.get(word);
                set.add("file name");
            }
        }
    }*/
}
