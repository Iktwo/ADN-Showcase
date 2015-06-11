package com.iktwo.showcase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listview = (ListView) findViewById(R.id.listView);

        ArrayList<AppInfo> apps = new ArrayList<AppInfo>();
        apps.add(new AppInfo("Spotify Streamer", "Streamer", "com.iktwo.spotify_streamer", false));
        apps.add(new AppInfo("Super Duo", "Football Scores App", "com.iktwo.super_duo", false));
        apps.add(new AppInfo("Build It Bigger", "", "com.iktwo.bbigger", false));
        apps.add(new AppInfo("XYZ Reader", "", "com.iktwo.xyz_reader", false));
        apps.add(new AppInfo("Capstone", "", "com.iktwo.capstone", false));
        apps.add(new AppInfo("El Pulso", "", "com.iktwo.elpulso", true));

        final AppsModel model = new AppsModel(getApplicationContext(), apps);

        listview.setAdapter(model);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AppInfo app = (AppInfo) model.getItem(i);

                try {
                    Intent activityIntent = getPackageManager().getLaunchIntentForPackage(app.getPackageName());
                    activityIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                    startActivity(activityIntent);
                } catch (final Exception e) {
                    if (app.isInStore()) {
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + app.getPackageName())));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + app.getPackageName())));
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), ((AppInfo) model.getItem(i)).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
