package com.example.blockchainatberkeleyapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ScrollView scrollView;
    String [] titles = {"Transfer", "Transfer", "Transfer", "Transfer", "Transfer"};
    String [] date = {"12/01/2018", "12/01/2018", "12/01/2018", "12/01/2018", "12/01/2018"};
    String [] amount = {"0.000017 BTC", "0.000017 BTC", "0.000017 BTC", "0.000017 BTC", "0.000017 BTC"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView = (ScrollView)findViewById(R.id.scrollView);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return true;
            }
        });

        Button button = (Button)findViewById(R.id.button);
        android.widget.SearchView search_bar = (android.widget.SearchView)findViewById(R.id.search_bar);
        search_bar.setQueryHint("Search recent transactions");

        listView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setFocusable(false);

        android.support.v7.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
            }
        });

    }

    class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);
            TextView textViewTitle = (TextView)convertView.findViewById(R.id.textViewTitle);
            TextView textViewDate = (TextView)convertView.findViewById(R.id.textViewDate);
            TextView textViewAmount = (TextView)convertView.findViewById(R.id.textViewAmount);

            textViewTitle.setText(titles[position]);
            textViewDate.setText(date[position]);
            textViewAmount.setText(amount[position]);

            return convertView;
        }
    }

}
