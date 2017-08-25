package com.example.segundoauqui.w4d3.injection.mainactivty;

import com.example.segundoauqui.w4d3.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by segundoauqui on 8/24/17.
 */

@Component(modules = MainActivityModule.class)
public interface MianActivityComponent {

    void inject(MainActivity mainActivity);
}
