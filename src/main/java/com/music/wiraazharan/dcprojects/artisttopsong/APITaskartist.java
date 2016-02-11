package com.music.wiraazharan.dcprojects.artisttopsong;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.music.wiraazharan.dcprojects.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by wiraazharan on 7/21/15.
 */
public class APITaskartist extends AsyncTask<String,Integer,String> {

    private ProgressDialog progDialog;
    private Context context;
    private ArtistTopSong activity;
    private static final String debugTag = "LastFMWebAPITask";

    /**
     * Construct a task
     * @param activity
     */
    public APITaskartist(ArtistTopSong activity) {
        super();
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDialog = ProgressDialog.show(this.activity, "Search", this.context.getResources().getString(R.string.looking_for_tracks) , true, false);
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Log.d(debugTag, "Background:" + Thread.currentThread().getName());
            String result = HelperClassArtist.downloadFromServer(params);
            return result;
        } catch (Exception e) {
            return new String();
        }
    }

    @Override
    protected void onPostExecute(String result)
    {

        ArrayList<DataTrackerArtist> trackdata = new ArrayList<DataTrackerArtist>();

        progDialog.dismiss();
        if (result.length() == 0) {
            this.activity.alert ("Unable to find track data. Try again later.");
            return;
        }

        try {
            JSONObject respObj = new JSONObject(result);
            JSONObject topTracksObj = respObj.getJSONObject("toptracks");
            JSONArray tracks = topTracksObj.getJSONArray("track");
            for(int i=0; i<tracks.length(); i++) {
                JSONObject track = tracks.getJSONObject(i);
                String trackname = track.getString("name");
                String trackplaycount = track.getString("playcount");
                JSONObject artistObj = track.getJSONObject("@attr");
                String rank = artistObj.getString("rank");



                trackdata.add(new DataTrackerArtist(trackname,trackplaycount, rank));
            }

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.activity.setTracks(trackdata);

    }
}

