package vn.thai.demolayout.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vn.thai.demolayout.R;

/**
 * Created by ngoquan on 4/24/2016.
 */
public class ListviewAdapter extends ArrayAdapter<String> {
    private Activity activity;
    private int layout;
    private ArrayList<String> arrData;
    public ListviewAdapter(Activity activity, int layout, ArrayList<String> arrData) {
        super(activity, layout, arrData);
        this.activity = activity;
        this.layout = layout;
        this.arrData = arrData;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_listview_layout, parent, false);
        }
        TextView txt_item = (TextView) convertView.findViewById(R.id.txt_item);
        txt_item.setText(arrData.get(position));
        return convertView;
    }
}
