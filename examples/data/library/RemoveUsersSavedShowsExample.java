package data.library;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.library.RemoveUsersSavedShowsRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class RemoveUsersSavedShowsExample {
  private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";
  private static final String[] ids = new String[]{"5AvwZVawapvyhJUIx71pdJ"};

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static final RemoveUsersSavedShowsRequest removeUsersSavedShowsRequest = spotifyApi
    .removeUsersSavedShows(ids)
//          .market(CountryCode.SE)
    .build();

  public static void removeUsersSavedShows_Sync() {
    try {
      final String string = removeUsersSavedShowsRequest.execute();

      System.out.println("Null: " + string);
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void removeUsersSavedShows_Async() {
    try {
      final CompletableFuture<String> stringFuture = removeUsersSavedShowsRequest.executeAsync();

      // Thread free to do other tasks...

      // Example Only. Never block in production code.
      final String string = stringFuture.join();

      System.out.println("Null: " + string);
    } catch (CompletionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    } catch (CancellationException e) {
      System.out.println("Async operation cancelled.");
    }
  }

  public static void main(String[] args) {
    removeUsersSavedShows_Sync();
    removeUsersSavedShows_Async();
  }
}