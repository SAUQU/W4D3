package com.example.segundoauqui.w4d3.injection.mainactivty;

import com.example.segundoauqui.w4d3.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by segundoauqui on 8/24/17.
 */

@Module
public class MainActivityModule {


    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
