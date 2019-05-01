package com.smartdroidesign.projectapp_recyclerview2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Adapter mAdapter;

    private ArrayList<Items> mItems = new ArrayList<>();
    private ArrayList<String> mPictures = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mItems.add(new Items("Rocky Mountain National Park", "Author's name"));
        mPictures.add("https://i.redd.it/j6myfqglup501.jpg");
        mItems.add(new Items("Mahahual", "Author's name"));
        mPictures.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mItems.add(new Items("Frozen Lake", "Author's name"));
        mPictures.add("https://i.redd.it/glin0nwndo501.jpg");
        mItems.add(new Items("White Sands Desert", "Author's name"));
        mPictures.add("https://i.redd.it/j6myfqglup501.jpg");
        mItems.add(new Items("Australia", "Author's name"));
        mPictures.add("https://i.redd.it/j6myfqglup501.jpg");
        mItems.add(new Items("Washington", "Author's name"));
        mPictures.add("https://i.redd.it/obx4zydshg601.jpg");
        mItems.add(new Items("Rocky Mountain National Park", "Author's name"));
        mPictures.add("https://i.imgur.com/ZcLLrkY.jpg");
        mItems.add(new Items("Rocky Mountain National Park", "Author's name"));
        mPictures.add("https://i.redd.it/j6myfqglup501.jpg");
        mItems.add(new Items("Rocky Mountain National Park", "Author's name"));
        mPictures.add("https://i.redd.it/j6myfqglup501.jpg");
        mItems.add(new Items("Rocky Mountain National Park", "Author's name"));
        mPictures.add("https://i.redd.it/j6myfqglup501.jpg");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        Adapter adapter = new Adapter(this, mItems, mPictures);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                intent.putExtra("image_url", mPictures.get(position));
                intent.putExtra("image_name", (mItems.get(position).getTextOne()));
                startActivity(intent);
            }
        });
    }
}
