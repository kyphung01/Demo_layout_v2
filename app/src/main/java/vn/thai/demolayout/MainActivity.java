package vn.thai.demolayout;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

import vn.thai.demolayout.adapter.GridAdapter;
import vn.thai.demolayout.model.Data;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data> arrData = new ArrayList<>();
    GridAdapter adapter;
    GridView gridView;
    Toolbar toolbar;
//    Grid items
    private String[] names;
    private String[] authors;
    private TypedArray images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        gridView = (GridView) findViewById(R.id.grid_view);
        names = getResources().getStringArray(R.array.name);
        authors = getResources().getStringArray(R.array.author);
        images = getResources().obtainTypedArray(R.array.image);
        for (int i = 0; i < 20; i++) {
            arrData.add(new Data(images.getResourceId(i, - 1), names[i], authors[i]));
        }
//        Recycle data images
        images.recycle();
        adapter = new GridAdapter(this, arrData);
        gridView.setAdapter(adapter);
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


        return super.onOptionsItemSelected(item);
    }
}
