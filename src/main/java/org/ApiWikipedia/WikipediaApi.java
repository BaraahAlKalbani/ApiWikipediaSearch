package org.ApiWikipedia;
import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class WikipediaApi {
    private static final String WIKIPEDIA_API = "https://en.wikipedia.org/w/api.php";
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static final Gson gson = new Gson();

    /**
     * Search Wikipedia for pages matching the given query.
     * @param query the search query
     * @return a list of WikipediaPage objects matching the query
     * @throws IOException if an error occurs while making the API request
     */
    public List<WikipediaPage> search(String query) throws IOException {
        // Build the URL for the API request
        HttpUrl.Builder urlBuilder = HttpUrl.parse(WIKIPEDIA_API).newBuilder()
                .addQueryParameter("action", "query")
                .addQueryParameter("format", "json")
                .addQueryParameter("list", "search")
                .addQueryParameter("srsearch", query);
        // Build the HTTP request
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .get()
                .build();
        // Execute the HTTP request and process the response
        try (Response response = httpClient.newCall(request).execute()) {
            String responseBody = response.body().string();
            WikipediaResponse wikipediaResponse = gson.fromJson(responseBody, WikipediaResponse.class);
            List<WikipediaPage> pages = wikipediaResponse.getQuery().getSearch();
            return pages;
        }
    }

    /**
     * Get the URL for a Wikipedia page.
     * @param page the WikipediaPage object for which to get the URL
     * @return the URL of the Wikipedia page
     */
    public String getPageUrl(WikipediaPage page) {
        return "https://en.wikipedia.org/wiki/" + page.getTitle().replace(' ', '_');
    }
}
