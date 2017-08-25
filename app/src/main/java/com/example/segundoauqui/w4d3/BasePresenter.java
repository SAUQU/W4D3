package com.example.segundoauqui.w4d3;

import com.example.segundoauqui.w4d3.view.BaseView;

/**
 * Created by segundoauqui on 8/24/17.
 */

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);

    void deattachView();


}
