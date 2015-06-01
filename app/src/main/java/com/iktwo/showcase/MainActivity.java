package com.iktwo.showcase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listView);

        ArrayList<AppInfo> apps = new ArrayList<AppInfo>();
        apps.add(new AppInfo("Spotify Streamer", "Streamer", "com.iktwo.spotify_streamer"));
        apps.add(new AppInfo("Super Duo", "Football Scores App", "com.iktwo.super_duo"));
        apps.add(new AppInfo("Build It Bigger", "", "com.iktwo.bbigger"));
        apps.add(new AppInfo("XYZ Reader", "", "com.iktwo.xyz_reader"));
        apps.add(new AppInfo("Capstone", "", "com.iktwo.capstone"));
        apps.add(new AppInfo("El Pulso", "", "com.iktwo.elpulso"));

        AppsModel model = new AppsModel(getApplicationContext(), apps);

        listview.setAdapter(model);
    }
}
