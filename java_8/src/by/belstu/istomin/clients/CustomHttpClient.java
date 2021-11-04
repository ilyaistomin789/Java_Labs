package by.belstu.istomin.clients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CustomHttpClient {
    public static HttpResponse<String> doPost(String path, String param1, String param2, String param3, String header1, String header2, String header3) {
        URI uri = URI.create(String.format("%s?param1=%s&param2=%s&param3=%s", path, param1, param2, param3));
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(uri).POST(HttpRequest.BodyPublishers.ofString(""))
                .setHeader("header1", header1)
                .setHeader("header2", header2)
                .setHeader("header3", header3)
                .build();
        try {
            return client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getResponseFromBbb(String path, String param1, String param2, String param3, String header1, String header2, String header3) {
        HttpResponse<String> resp = doPost(path, param1, param2, param3, header1, header2, header3);
        var headers = resp.headers().map();
        return resp.body() + "<br/>" + headers.get("BbbHeader1") + "<br/>" + headers.get("BbbHeader2");
    }
}
