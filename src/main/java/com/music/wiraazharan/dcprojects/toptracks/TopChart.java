package com.music.wiraazharan.dcprojects.toptracks;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.music.wiraazharan.dcprojects.R;

import java.util.ArrayList;


public class TopChart extends Activity {

    private Button gettoptrack;
    private ListView trackllist;
    private ArrayList<DataTracker> tracks;
    private LayoutInflater layoutInflator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_fmtop_chart);


        gettoptrack = (Button)findViewById(R.id.get_top_track);
        trackllist = (ListView)findViewById(R.id.tracklisst);
        layoutInflator = LayoutInflater.from(this);


        gettoptrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                APITask lfmTask = new APITask(TopChart.this);
                try {

                    lfmTask.execute();
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

        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }


    public void setTracks(ArrayList<DataTracker> trackdata) {

        this.tracks = trackdata;
        this.trackllist.setAdapter(new TopChartListviewAdapter(this,this.layoutInflator, this.tracks));
    }


    public static class ViewHolder
    {
        public TextView tname;
        public TextView playcount;
        public TextView artistn;
        public DataTracker t;
    }


}

