package org.ApiWikipedia;

import com.google.gson.JsonParseException;

import java.io.IOException;
import java.util.List;

public class Main {
    /**
     * The main method for running a Wikipedia search.
     *
     * @param args an array of arguments, used as the search query
     */
    public static void main(String[] args) {
        try {
            //check if args[] have values in it, if not close the program
            if (args.length < 1) {
                System.out.println("Please provide a search term as an argument.");
                return;
            }
            // Get the search query from the command line arguments
            String query = args[0];

            // Print the query to the console
            System.out.print("Wikipedia Search on '" + query + "':");

            // Create a new WikipediaApi object
            WikipediaApi api = new WikipediaApi();

            // Search for pages matching the query
            List<WikipediaPage> pages = api.search(query);

            // If no pages were found, print a message to the console
            if (pages.isEmpty()) {
                System.out.println("No results found for " + query);
            } else {
                // Print up to 10 pages to the console
                for (int i = 0; i < 10 && i < pages.size(); i++) {
                    WikipediaPage page = pages.get(i);

                    // Print the page title, snippet, and URL to the console
                    System.out.println((i + 1) + ". Title: " + page.getTitle());
                    System.out.println("Snippet: " + page.getSnippet());
                    System.out.println("URL: " + api.getPageUrl(page));
                    System.out.println();
                }
            }
        }
        catch (IOException e) {
            System.err.println("There was an error connecting to Wikipedia. Please check your internet connection and try again.");
            e.printStackTrace();
        }catch (JsonParseException e) {
            System.err.println("There was an error parsing the JSON response from Wikipedia. Please try again later.");
            e.printStackTrace();
        }catch (NullPointerException e) {
            System.err.println("There was an error processing the response from Wikipedia. Please try again later.");
            e.printStackTrace();
        }catch (RuntimeException e) {
            System.err.println("There was an unexpected error while processing your request. Please try again later.");
            e.printStackTrace();
        }
    }
}