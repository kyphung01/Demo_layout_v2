package vn.thai.demolayout.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vn.thai.demolayout.DetailActivity;
import vn.thai.demolayout.R;
import vn.thai.demolayout.model.Data;

/**
 * Created by ngoquan on 4/24/2016.
 */
public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<Data> arrData;
    LayoutInflater layoutInflater;
    public GridAdapter(Context context, ArrayList<Data> arrData) {
        this.context = context;
        this.arrData = arrData;
        layoutInflater = LayoutInflater.from(this.context);
    }


    @Override
    public int getCount() {
        return arrData.size();
    }

    @Override
    public Object getItem(int position) {
        return arrData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_grid_layout, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
        final Data currentData =(Data) getItem(position);
        mViewHolder.img_display.setImageResource(currentData.getImage());
        mViewHolder.txt_name.setText(currentData.getName());
        mViewHolder.txt_author.setText(currentData.getAuthor());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image", currentData.getImage());
                bundle.putString("name", currentData.getName());
                bundle.putString("author", currentData.getAuthor());
                intent.putExtra("data", bundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    private class MyViewHolder {
        ImageView img_display;
        TextView txt_name, txt_author;
        public MyViewHolder(View item) {
            img_display = (ImageView) item.findViewById(R.id.img_display);
            txt_name = (TextView) item.findViewById(R.id.txt_name);
            txt_author = (TextView) item.findViewById(R.id.txt_author);
        }
    }
}
