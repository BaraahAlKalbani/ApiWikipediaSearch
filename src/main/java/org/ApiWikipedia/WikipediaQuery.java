package org.ApiWikipedia;

import java.util.List;

public class WikipediaQuery {
    private final List<WikipediaPage> search;

    /**
     * Create a new WikipediaQuery with the given list of search results.
     * @param search the list of search results
     */
    public WikipediaQuery(List<WikipediaPage> search) {
        this.search = search;
    }

    /**
     * Get the list of search results.
     * @return the list of search results
     */
    public List<WikipediaPage> getSearch() {
        return search;
    }
}
