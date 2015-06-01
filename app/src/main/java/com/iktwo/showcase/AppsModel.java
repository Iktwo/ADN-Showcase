package com.iktwo.showcase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class AppsModel extends BaseAdapter {
    private ArrayList<AppInfo> arrayListApps;
    private LayoutInflater inflater;

    public AppsModel(Context context, ArrayList<AppInfo> arrayListApps) {
        this.arrayListApps = arrayListApps;

        if (context != null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayListApps.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListApps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        ViewHolder holder;
        final AppInfo appInfo = (AppInfo) getItem(i);

        if (view == null && inflater != null) {
            view = inflater.inflate(R.layout.app_info_delegate, viewGroup, false);
            holder = new ViewHolder();

            holder.button = (Button) view.findViewById(R.id.button);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.button.setText(appInfo.getTitle());

        holder.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(viewGroup.getContext(), appInfo.getPackageName(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    static class ViewHolder {
        public Button button;
    }
}
