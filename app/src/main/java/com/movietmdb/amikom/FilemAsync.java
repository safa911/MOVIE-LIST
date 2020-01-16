package com.movietmdb.amikom;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FilemAsync extends AsyncTaskLoader<ArrayList<Filem>> {

    private String URL;
    private String filems = null;

    public FilemAsync(Context context, String URL) {
        super(context);
        this.URL = URL;
    }

    @Override
    public ArrayList<Filem> loadInBackground() {
        final ArrayList<Filem> list = new ArrayList<>();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .build();
        try {
            Response response = client.newCall(request).execute();

            filems = response.body().string();

            try{
                JSONObject objData = new JSONObject(filems);
                final JSONArray arrayResults = objData.getJSONArray("results");
                if(arrayResults != null) {
                    for (int i = 0; i < arrayResults.length(); i++) {
                        JSONObject objFilem = new JSONObject(arrayResults.get(i).toString());
                        String title = objFilem.getString("title");
                        String overview = objFilem.getString("overview");
                        String releaseDate = objFilem.getString("release_date");
                        String imgPoster = "https://image.tmdb.org/t/p/w500" + objFilem.getString("poster_path");
                        String rating = objFilem.getString("vote_average");
                        list.add(new Filem(title, overview, releaseDate, imgPoster, rating));
                    }
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
