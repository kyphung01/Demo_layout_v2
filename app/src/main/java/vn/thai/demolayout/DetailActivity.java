package vn.thai.demolayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.thai.demolayout.adapter.ViewPagerAdapter;
import vn.thai.demolayout.fragment.ChaptersFragment;
import vn.thai.demolayout.fragment.DiscoveryFragment;
import vn.thai.demolayout.fragment.SummaryFragment;

public class DetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Bundle bundle;
    SummaryFragment summaryFragment = new SummaryFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("data");
        int image = b.getInt("image");
        String name = b.getString("name");
        String author = b.getString("author");
        toolbar.setTitle(name);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            RelativeLayout relativeLayout = (RelativeLayout)
                    LayoutInflater.from(this).inflate(R.layout.tab_layout, tabLayout, false);

            TextView tabTextView = (TextView) relativeLayout.findViewById(R.id.tab_title);
            tabTextView.setText(tab.getText());
            tab.setCustomView(relativeLayout);
        }

        bundle = new Bundle();
        bundle.putInt("image", image);
        bundle.putString("author", author);
        summaryFragment.setArguments(bundle);
    }


    private void setupViewPager(ViewPager viewPager) {
//        Fragment


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(summaryFragment, "SUMMARY");
        adapter.addFrag(new ChaptersFragment(), "CHAPTERS");
        adapter.addFrag(new DiscoveryFragment(), "DISCOVERY");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
