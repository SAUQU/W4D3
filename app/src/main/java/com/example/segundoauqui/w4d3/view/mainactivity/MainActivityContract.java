package com.example.segundoauqui.w4d3.view.mainactivity;

import com.example.segundoauqui.w4d3.BasePresenter;
import com.example.segundoauqui.w4d3.model.Food;
import com.example.segundoauqui.w4d3.view.BaseView;

import java.util.List;

/**
 * Created by segundoauqui on 8/24/17.
 */

public interface MainActivityContract {

    interface View extends BaseView {
        void onDataSaved(boolean isSaved);
        void dataRecieved(String data);

        void updateMovieList(List<Food> movieList);
    }


    interface Presenter extends BasePresenter<View> {

        void saveDataToCloud(String s);
        void readFromCloud();
        void pushFoodToDb(Food food);
        void getFood();

    }
}
