package org.ApiWikipedia;

public class WikipediaPage {
    private final String title;
    private String snippet;

    /**
     * Create a new WikipediaPage with the given title and snippet.
     * @param title the title of the page
     * @param snippet a brief summary of the page's content
     */
    public WikipediaPage(String title, String snippet) {
        this.title = title;
        this.snippet = snippet;
    }

    /**
     * Get the title of the Wikipedia page.
     * @return the title of the page
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get a shortened, cleaned up version of the snippet.
     * The snippet is stripped of HTML tags and truncated to a maximum of 150 characters.
     * @return a shortened version of the page's content
     */
    public String getSnippet() {
        // Remove any HTML tags from the snippet
        snippet = snippet.replaceAll("\\<.*?\\>","");
        // Truncate the snippet to a maximum of 150 characters
        if (snippet.length() > 150) {
            return snippet.substring(0, 150) + "...";
        } else {
            return snippet+"...";
        }
    }
}
