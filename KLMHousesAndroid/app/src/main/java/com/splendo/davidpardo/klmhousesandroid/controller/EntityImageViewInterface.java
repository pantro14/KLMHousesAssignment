package com.splendo.davidpardo.klmhousesandroid.controller;

import android.view.View;

import com.splendo.davidpardo.klmhousesandroid.data.Entity;

import java.util.ArrayList;

/**
 * Created by davidpardo on 11/22/16.
 */

public interface EntityImageViewInterface {

    public View generateEntityImageView(int position, ArrayList<Entity> entityList, View convertView);


}
