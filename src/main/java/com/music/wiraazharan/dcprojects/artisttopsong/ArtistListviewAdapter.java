package com.music.wiraazharan.dcprojects.artisttopsong;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.music.wiraazharan.dcprojects.R;

import java.util.ArrayList;

/**
 * Created by wiraazharan on 7/21/15.
 */
public class ArtistListviewAdapter extends BaseAdapter {

    private static final String debugTag = "TrackDataAdapter";
    private ArtistTopSong activity;

    private LayoutInflater layoutInflater;
    private ArrayList<DataTrackerArtist> tracks;


    public ArtistListviewAdapter(ArtistTopSong a, LayoutInflater l, ArrayList<DataTrackerArtist> data)
    {
        this.activity = a;
        this.layoutInflater = l;
        this.tracks = data;
    }

    @Override
    public int getCount() {
        return this.tracks.size();
    }

    @Override
    public boolean areAllItemsEnabled ()
    {
        return true;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        ArtistTopSong.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate (R.layout.eachrow, parent, false);
            holder = new ArtistTopSong.ViewHolder();
            holder.tname = (TextView) convertView.findViewById(R.id.tracker_name);
            holder.playcount = (TextView) convertView.findViewById(R.id.play_count);
            holder.rank = (TextView) convertView.findViewById(R.id.artister_name);
            convertView.setTag(holder);
        }
        else {
            holder = (ArtistTopSong.ViewHolder) convertView.getTag();
        }

        //convertView.setOnClickListener(this);

        DataTrackerArtist track = tracks.get(pos);
        holder.t = track;
        holder.tname.setText("TRACK NAME : " + track.getTrackname());
        holder.playcount.setText("PLAY COUNT : " + track.getTrackplaycount());
        holder.rank.setText("RANK : " + track.getArtistname());
//            holder.trackButton.setOnClickListener(this);
//            if(track.getImageUrl() != null) {
//                holder.icon.setTag(track.getImageUrl());
//                Drawable dr = imgFetcher.loadImage(this, holder.icon);
//                if(dr != null) {
//                    holder.icon.setImageDrawable(dr);
//                }
//            } else {
//                holder.icon.setImageResource(R.drawable.filler_icon);
//            }

        return convertView;
    }

//        @Override
//        public void onClick(View v) {
//            MyViewHolder holder = (MyViewHolder) v.getTag();
//            if (v instanceof Button) {
//
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse(holder.track.getArtistUrl()));
//                this.activity.startActivity(intent);
//
//            } else if (v instanceof View) {
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse(holder.track.getTrackUrl()));
//                this.activity.startActivity(intent);
//            }
//            Log.d(debugTag, "OnClick pressed.");
//
//        }


}
