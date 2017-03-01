package com.splendo.davidpardo.klmhousesandroid.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.splendo.davidpardo.klmhousesandroid.activities.EntityMainActivity;
import com.splendo.davidpardo.klmhousesandroid.data.Entity;

import java.util.ArrayList;

/**
 * Created by davidpardo on 11/22/16.
 */

public class EntityImageAdapter extends BaseAdapter {

    private ArrayList<Entity> entityList;
    private EntityMainActivity mainActivity;
    private static final int TOTAL_ENTITY = 11;

    public EntityImageAdapter(Context context) {
        this.mainActivity = (EntityMainActivity)context;
        this.entityList = getEntityObjectList();;
    }

    @Override
    public int getCount() {
        return entityList.size();
    }

    @Override
    public Object getItem(int i) {
        return entityList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return mainActivity.generateEntityImageView(i, entityList,view);
    }

    private ArrayList<Entity> getEntityObjectList(){
        ArrayList<Entity> entityList = new ArrayList<Entity>();
        for(int i = 0; i< TOTAL_ENTITY; i++) {
            int index = TOTAL_ENTITY -i;
            Entity entity = new Entity(index, "klm-miniature-" + index,
                    "House in Amsterdam " + index, "Amsterdam", false);
            entityList.add(entity);
        }
        return entityList;
    }

    public static int getTotalEntity() {
        return TOTAL_ENTITY;
    }

}
