package com.splendo.davidpardo.klmhousesandroid.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.splendo.davidpardo.klmhousesandroid.R;
import com.splendo.davidpardo.klmhousesandroid.controller.EntityImageAdapter;
import com.splendo.davidpardo.klmhousesandroid.controller.EntityImageViewInterface;
import com.splendo.davidpardo.klmhousesandroid.controller.ImageTool;
import com.splendo.davidpardo.klmhousesandroid.data.Entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class EntityMainActivity extends AppCompatActivity implements EntityImageViewInterface {

    private GridView entityGridView;
    private EntityImageAdapter adapter;
    private ImageTool imageTool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_main);

        imageTool = new ImageTool(getBaseContext());

        entityGridView = (GridView) findViewById(R.id.gridview);

        adapter = new EntityImageAdapter(this);

        entityGridView.setAdapter(adapter);

        entityGridView.setOnItemClickListener(entityGridClickCellListener);

    }

    public AdapterView.OnItemClickListener
            entityGridClickCellListener = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final String MESSAGE1 = "TOTAL_ENTITY_NUMBER";
            final String MESSAGE2 = "ENTITY_ITEM_SELECTED";
            Intent intent = new Intent().setClass(EntityMainActivity.this, EntityDetailActivity.class);
            intent.putExtra(MESSAGE1, adapter.getTotalEntity());
            intent.putExtra(MESSAGE2, position);
            startActivity(intent);
        }

    };

    @Override
    public View generateEntityImageView(int position, ArrayList<Entity> entityList, View convertView) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new GridView.LayoutParams(
                GridView.LayoutParams.MATCH_PARENT, GridView.LayoutParams.MATCH_PARENT));

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

        // Entity Principal ImageView Construction
        ImageView entityImage;
        entityImage = createImageView
                (entityList.get(position).getEntityImageName(), "ENTITY");
        relativeLayout.addView(entityImage);

        // Image TextView Construction
        TextView txtEntityId = new TextView(this);
        txtEntityId.setText(String.valueOf(entityList.get(position).getEntityId()));
        txtEntityId.setTextSize(25f);
        txtEntityId.setTextColor(Color.parseColor("#F39C12"));
        txtEntityId.setLayoutParams(params);
        relativeLayout.addView(txtEntityId, params);

        // Image Favourite TextView Construction
        ImageView favouriteImage;
        favouriteImage = createImageView("star", "FAV");
        relativeLayout.addView(favouriteImage);

        if (convertView == null) {
            return relativeLayout;
        } else {
            return convertView;
        }
    }

    private ImageView createImageView(String name, String imageType){
        ImageView entityImage = new ImageView(EntityMainActivity.this);
        InputStream inputStream;
        try {
            inputStream = imageTool.generateImageTool(name);
        } catch (IOException e) {
            inputStream = null;
            e.printStackTrace();
        }
        Drawable drawable = Drawable.createFromStream(inputStream, null);
        entityImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        entityImage.setImageDrawable(drawable);

        if(imageType.equals("FAV")){
            RelativeLayout.LayoutParams imageViewParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            imageViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            entityImage.setLayoutParams(imageViewParams);
            entityImage.getLayoutParams().height = 40;
            entityImage.getLayoutParams().width = 40;
            entityImage.setVisibility(View.GONE);
        }else if(imageType.equals("ENTITY")){
            FrameLayout.LayoutParams imageViewParams = new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
            entityImage.setLayoutParams(imageViewParams);
        }
        return entityImage;
    }

}
