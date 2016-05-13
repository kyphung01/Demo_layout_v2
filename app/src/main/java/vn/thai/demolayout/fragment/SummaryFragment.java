package vn.thai.demolayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import vn.thai.demolayout.R;

/**
 * Created by ngoquan on 4/24/2016.
 */
public class SummaryFragment extends Fragment {


    public SummaryFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detail, container, false);
        ImageView img_display = (ImageView) view.findViewById(R.id.img_display);
        TextView txt_author = (TextView) view.findViewById(R.id.txt_author);
        int image = getArguments().getInt("image");
        String author = getArguments().getString("author");
        img_display.setImageResource(image);
        txt_author.setText(author);
        return view;
    }
}
