package com.abis_creations.android.railfarecanculator.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abis_creations.android.railfarecanculator.R;
import com.abis_creations.android.railfarecanculator.models.Station;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    ArrayList<Station> dataSet;
    LayoutInflater inflter;

    public SpinnerAdapter(Context context, ArrayList<Station> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
        this.inflter = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinner_item_layout, null);
        ImageView ivStationLogo =  view.findViewById(R.id.iv_station_logo);
        TextView tvStationName =  view.findViewById(R.id.tv_station_name);
        ivStationLogo.setImageResource(dataSet.get(i).getStationLogo());
        tvStationName.setText(dataSet.get(i).getStationName());
        return view;
    }
}
