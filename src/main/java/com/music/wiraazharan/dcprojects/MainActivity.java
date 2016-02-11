package com.music.wiraazharan.dcprojects;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.music.wiraazharan.dcprojects.artisttopsong.ArtistTopSong;
import com.music.wiraazharan.dcprojects.toptracks.TopChart;


public class MainActivity extends ActionBarActivity {

    Intent serviceIntent;
    Button playstop;
    TextView one, two, three, four , five , six;
    Boolean boolmusicplay = false;
    String whichsong="";
    Button gototoptracks;
    Button gotoartistinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, Splashscreen.class);
        startActivity(i);

        gotoartistinfo = (Button)findViewById(R.id.gotoartistinfo);
        gotoartistinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wi = new Intent(MainActivity.this,ArtistTopSong.class);
                startActivity(wi);
            }
        });


        gototoptracks = (Button)findViewById(R.id.gototoptracks);
        gototoptracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(MainActivity.this,TopChart.class);
                startActivity(w);
            }
        });

        playstop = (Button) findViewById(R.id.playstop);
        playstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playstopmethod();
            }
        });

        selectsong();

        serviceIntent = new Intent(this, MusicService.class);
        initViews();
    }


    private void playstopmethod() {

        if(whichsong=="")
        {
            Toast.makeText(this,"No songs selected",Toast.LENGTH_SHORT).show();
        }else
        {

        serviceIntent.putExtra("sentaudiolink", whichsong);
        if (!boolmusicplay) {

            playstop.setBackgroundResource(R.drawable.stop);
            playmusic();
            boolmusicplay = true;
        } else {
            playstop.setBackgroundResource(R.drawable.play);
            stopmusic();
            boolmusicplay = false;
        }

        }

    }

    private void initViews() {
        playstop.setBackgroundResource(R.drawable.play);
    }

    private void stopmusic() {

        try {
            stopService(serviceIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void playmusic() {

        try {
            startService(serviceIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void selectsong() {

        one = (TextView) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                one.setTextColor(Color.parseColor("#FFFF4D4A"));
                two.setTextColor(Color.parseColor("#FFFFFFFF"));
                three.setTextColor(Color.parseColor("#FFFFFFFF"));
                four.setTextColor(Color.parseColor("#FFFFFFFF"));
                five.setTextColor(Color.parseColor("#FFFFFFFF"));
                six.setTextColor(Color.parseColor("#FFFFFFFF"));

                whichsong = "Avicii%20-%20Wake-Me-Up.mp3";


            }
        });

        two = (TextView) findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setTextColor(Color.parseColor("#FFFFFFFF"));
                two.setTextColor(Color.parseColor("#FFFF4D4A"));
                three.setTextColor(Color.parseColor("#FFFFFFFF"));
                four.setTextColor(Color.parseColor("#FFFFFFFF"));
                five.setTextColor(Color.parseColor("#FFFFFFFF"));
                six.setTextColor(Color.parseColor("#FFFFFFFF"));

                whichsong = "Eminem%20feat%20Rihanna%20-%20The%20Monster.mp3";
            }
        });

        three = (TextView) findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setTextColor(Color.parseColor("#FFFFFFFF"));
                two.setTextColor(Color.parseColor("#FFFFFFFF"));
                three.setTextColor(Color.parseColor("#FFFF4D4A"));
                four.setTextColor(Color.parseColor("#FFFFFFFF"));
                five.setTextColor(Color.parseColor("#FFFFFFFF"));
                six.setTextColor(Color.parseColor("#FFFFFFFF"));

                whichsong = "Jason%20Derulo%20-%20Trumpets.mp3";

            }
        });

        four = (TextView) findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setTextColor(Color.parseColor("#FFFFFFFF"));
                two.setTextColor(Color.parseColor("#FFFFFFFF"));
                three.setTextColor(Color.parseColor("#FFFFFFFF"));
                four.setTextColor(Color.parseColor("#FFFF4D4A"));
                five.setTextColor(Color.parseColor("#FFFFFFFF"));
                six.setTextColor(Color.parseColor("#FFFFFFFF"));

                whichsong = "Lawson%20feat.%20B.o.B%20-%20Brokenhearted.mp3";

            }
        });

        five = (TextView) findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setTextColor(Color.parseColor("#FFFFFFFF"));
                two.setTextColor(Color.parseColor("#FFFFFFFF"));
                three.setTextColor(Color.parseColor("#FFFFFFFF"));
                four.setTextColor(Color.parseColor("#FFFFFFFF"));
                five.setTextColor(Color.parseColor("#FFFF4D4A"));
                six.setTextColor(Color.parseColor("#FFFFFFFF"));

                whichsong = "Thinking%20Out%20Loud.mp3";

            }
        });

        six = (TextView) findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                one.setTextColor(Color.parseColor("#FFFFFFFF"));
                two.setTextColor(Color.parseColor("#FFFFFFFF"));
                three.setTextColor(Color.parseColor("#FFFFFFFF"));
                four.setTextColor(Color.parseColor("#FFFFFFFF"));
                five.setTextColor(Color.parseColor("#FFFFFFFF"));
                six.setTextColor(Color.parseColor("#FFFF4D4A"));

                whichsong = "Photograph.mp3";

            }
        });


    }

}
//http://main.purplez.pw/music/Avicii%20-%20Wake-Me-Up.mp3
//http://main.purplez.pw/music/Eminem%20feat%20Rihanna%20-%20The%20Monster.mp3
//http://main.purplez.pw/music/Jason%20Derulo%20-%20Trumpets.mp3
//http://main.purplez.pw/music/Lawson%20feat.%20B.o.B%20-%20Brokenhearted.mp3