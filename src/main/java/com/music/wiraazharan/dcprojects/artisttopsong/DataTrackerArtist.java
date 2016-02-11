package com.music.wiraazharan.dcprojects.artisttopsong;

/**
 * Created by wiraazharan on 7/21/15.
 */
public class DataTrackerArtist {

    String trackname;
    String trackplaycount;
    String rank;

    public DataTrackerArtist(String name , String playcount ,String  artist)
    {
        this.trackname = name;
        this.trackplaycount = playcount;
        this.rank = artist;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    public void setTrackplaycount(String trackplaycount) {
        this.trackplaycount = trackplaycount;
    }

    public void setArtistname(String artistname) {
        this.rank = artistname;
    }

    public String getTrackname() {
        return trackname;
    }

    public String getTrackplaycount() {
        return trackplaycount;
    }

    public String getArtistname() {
        return rank;
    }
}
