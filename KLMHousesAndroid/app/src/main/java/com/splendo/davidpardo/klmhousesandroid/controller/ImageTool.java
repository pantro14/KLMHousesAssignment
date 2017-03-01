package com.splendo.davidpardo.klmhousesandroid.controller;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by davidpardo on 11/24/16.
 */

public class ImageTool {

    private Context context;

    public ImageTool(Context context){
        this.context = context;
    }

    public InputStream generateImageTool(String imageName) throws IOException {
        InputStream imputString = null;
        imputString = context.getAssets().open(imageName+".jpg");
        return imputString;
    }
}
