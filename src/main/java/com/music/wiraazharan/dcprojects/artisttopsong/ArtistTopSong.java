package com.music.wiraazharan.dcprojects.artisttopsong;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.music.wiraazharan.dcprojects.R;

import java.util.ArrayList;

/**
 * Created by wiraazharan on 7/21/15.
 */
public class ArtistTopSong extends Activity {

    private Button getartisttop;
    private ListView trackllist;
    private EditText artistname;
    private ArrayList<DataTrackerArtist> tracks;
    private LayoutInflater layoutInflator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artisttop_activity);

        artistname = (EditText)findViewById(R.id.artistname);
        getartisttop = (Button)findViewById(R.id.get_artist_track);
        trackllist = (ListView)findViewById(R.id.tracklisst);
        layoutInflator = LayoutInflater.from(this);


        getartisttop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                APITaskartist lfmTask = new APITaskartist(ArtistTopSong.this);
                try {

                    String consolidated = null;
                    String requested = artistname.getText().toString();
                    String[] splited = requested.split("\\s+");

                    StringBuilder builder = new StringBuilder();
                    for(String s : splited) {
                        builder.append(s+"+");
                    }
                    consolidated =  builder.toString();

                    lfmTask.execute(consolidated);
                }
                catch (Exception e)
                {
                    lfmTask.cancel(true);
                    alert (getResources().getString(R.string.no_tracks));
                }


            }
        });





    }







    public void alert(String s) {

        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    public void setTracks(ArrayList<DataTrackerArtist> trackdata) {

        this.tracks = trackdata;
        this.trackllist.setAdapter(new ArtistListviewAdapter(this,this.layoutInflator, this.tracks));
    }


    public static class ViewHolder
    {
        public TextView tname;
        public TextView playcount;
        public TextView rank;
        public DataTrackerArtist t;
    }


}

