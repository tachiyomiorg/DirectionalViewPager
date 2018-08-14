package com.demo;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.directionalviewpager.demo.R;
import android.support.v4.view.DirectionalViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerActivity extends AppCompatActivity {

    private DirectionalViewPager pager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        pager = findViewById(R.id.pager);

        setSupportActionBar(toolbar);
        pager.setAdapter(new Adapter());

        Resources r = getResources();
        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, r.getDisplayMetrics());
        pager.setPageMargin(margin);
        pager.setPageMarginDrawable(new ColorDrawable(Color.BLACK));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_swap) {
            pager.setHorizontal(!pager.isHorizontal());
            return true;
        }
        return false;
    }

    class Adapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 5;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            TextView text = new TextView(container.getContext());
            text.setGravity(Gravity.CENTER);
            text.setTextSize(64);
            text.setText("" + position);
            container.addView(text);
            return text;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }

}
