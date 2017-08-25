package com.example.segundoauqui.w4d3.view.mainactivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.segundoauqui.w4d3.R;
import com.example.segundoauqui.w4d3.model.Food;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by segundoauqui on 8/25/17.
 */

public class DataBaseAdapter extends RecyclerView.Adapter<DataBaseAdapter.ViewHolder>{

    private static final String TAG = "DishesListAdapter";
    ArrayList<Food> newFoodArrayList = new ArrayList<>();
    Context context;

    public DataBaseAdapter(ArrayList<Food> newFoodArrayList) {
        this.newFoodArrayList = newFoodArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        @Nullable
//        @BindView(R.id.img)
//        BootstrapCircleThumbnail img;



        @BindView(R.id.dishType)
        TextView dishType;


        @BindView(R.id.dishUrl)
        TextView dishUrl;

        @BindView(R.id.dishDesc)
        TextView dishDesc;


        @BindView(R.id.dishPrice)
        TextView dishPrice;




        public ViewHolder(View DishesView) {
            super(DishesView);
            ButterKnife.bind(this, DishesView);
        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Log.d(TAG, "onCreateViewHolder: ");
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(view);
    }

    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        if(position > lastPosition){
            //Animation animation = AnimationUtils
        }

        //Log.d(TAG, "onBindViewHolder: ");
        final Food Dishess = newFoodArrayList.get(position);
        //Picasso.with(context).load(Dishess.getUrl()).error(R.drawable.andvapp).into(holder.img);
        if(!Dishess.getType().trim().equals(""))
            holder.dishType.setText(Dishess.getType());

        if(!Dishess.getUrl().trim().equals(""))
            holder.dishUrl.setText(Dishess.getUrl());
        else
            holder.dishUrl.setVisibility(holder.dishUrl.getRootView().GONE);

        if(!Dishess.getDescription().trim().equals(""))
            holder.dishDesc.setText(Dishess.getDescription());
        else
            holder.dishDesc.setVisibility(holder.dishDesc.getRootView().GONE);

        if(!Dishess.getPrice().trim().equals(""))
            holder.dishPrice.setText(Dishess.getPrice());
        else
            holder.dishPrice.setVisibility(holder.dishPrice.getRootView().GONE);


    }

    @Override
    public int getItemCount() {
        //Log.d(TAG, "getDishesCount: "+DishesList.size());
        return newFoodArrayList.size();
    }
}
