package org.ApiWikipedia;

import java.util.List;

public class WikipediaResponse {
    private final WikipediaQuery query;

    /**
     * Create a new WikipediaResponse with the given WikipediaQuery.
     * @param query the WikipediaQuery containing the search results
     */
    public WikipediaResponse(WikipediaQuery query) {
        this.query = query;
    }

    /**
     * Get the WikipediaQuery containing the search results.
     * @return the WikipediaQuery containing the search results
     */
    public WikipediaQuery getQuery() {
        return query;
    }
}
