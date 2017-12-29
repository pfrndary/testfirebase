package gdrive;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Articleservice {

    private final Map<Integer, String> allArticles = new ConcurrentHashMap<>();

    private final Map<String, Integer> buy = new ConcurrentHashMap<>();

    public Map<Integer, String> getAllArticles() {
        // TODO unmodifiable
        return allArticles;
    }

    public void addArticle(String article, Integer count) {
        Integer integer = buy.putIfAbsent(article, 0);
        buy.put(article, integer + count);
    }


}
