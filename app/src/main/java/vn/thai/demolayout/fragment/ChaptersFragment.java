package vn.thai.demolayout.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vn.thai.demolayout.R;
import vn.thai.demolayout.adapter.ListviewAdapter;

/**
 * Created by ngoquan on 4/24/2016.
 */
public class ChaptersFragment extends Fragment {
    ListView lv_chapters;
    ArrayList<String> arrData = new ArrayList<>();
    ListviewAdapter adapter;
    public ChaptersFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chapters, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lv_chapters = (ListView) getView().findViewById(R.id.lv_chapters);
        String[] name = getResources().getStringArray(R.array.list_item);
        for (int i = 0; i < name.length; i++) {
            arrData.add(name[i]);
        }
        adapter = new ListviewAdapter(getActivity(), R.layout.item_listview_layout, arrData);
        lv_chapters.setAdapter(adapter);
    }
}
