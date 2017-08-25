package com.example.segundoauqui.w4d3.view.mainactivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.segundoauqui.w4d3.R;
import com.example.segundoauqui.w4d3.model.Food;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String PROVIDER_NAME = "androidcontentproviderdemo.androidcontentprovider.food";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/food");
    private static final String TAG = "MainActivity";

    @BindView(R.id.dishRecyclerList)
    RecyclerView dishRecyclerList;

    @BindView(R.id.txtViewDishType)
    TextView txtViewDishType;

    @BindView(R.id.txtViewDishUrl)
    TextView txtViewDishUrl;

    @BindView(R.id.txtViewDishDesc)
    TextView txtViewDishDesc;

    @BindView(R.id.txtViewDishPrice)
    TextView txtViewDishPrice;


    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    DataBaseAdapter dishesListAdapter;

    ArrayList<Food> dishesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);


        dishRecyclerList.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        layoutManager = new LinearLayoutManager(getApplicationContext());
        itemAnimator = new DefaultItemAnimator();
        dishRecyclerList.setLayoutManager(layoutManager);
        dishRecyclerList.setItemAnimator(itemAnimator);

        refreshValuesFromContentProvider();

        //initialize the adapter
        dishesListAdapter = new DataBaseAdapter(dishesList);
        dishRecyclerList.setAdapter(dishesListAdapter);

        dishesListAdapter.notifyDataSetChanged();

    }

    private void refreshValuesFromContentProvider() {

        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);


        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                String DISHTYPE = cursor.getString(cursor.getColumnIndex("DISHTYPE"));
                String DISHURL = cursor.getString(cursor.getColumnIndex("DISHURL"));
                String DISHDESC = cursor.getString(cursor.getColumnIndex("DISHDESC"));
                String DISHPRICE = cursor.getString(cursor.getColumnIndex("DISHPRICE"));

                dishesList.add(new Food(
                        DISHTYPE,
                        DISHURL,
                        DISHDESC,
                        DISHPRICE
                ));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void onClickAddDish(View view) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("DISHTYPE", txtViewDishType.getText().toString());
        contentValues.put("DISHURL", txtViewDishUrl.getText().toString());
        contentValues.put("DISHDESC", txtViewDishDesc.getText().toString());
        contentValues.put("DISHPRICE", txtViewDishPrice.getText().toString());
        Uri uri = getContentResolver().insert(CONTENT_URI, contentValues);
        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();


        dishesList.add(new Food(
                txtViewDishType.getText().toString(),
                txtViewDishUrl.getText().toString(),
                txtViewDishDesc.getText().toString(),
                txtViewDishPrice.getText().toString()
                ));
        dishesListAdapter.notifyItemInserted(dishesList.size() - 1);


        cleanValues();
    }

    protected void cleanValues() {
        txtViewDishType.setText("");
        txtViewDishUrl.setText("");
        txtViewDishDesc.setText("");
        txtViewDishPrice.setText("");
    }
}