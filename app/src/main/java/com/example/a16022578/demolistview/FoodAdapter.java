package com.example.a16022578.demolistview;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<food> {
private ArrayList<food> food;
private Context context;
private TextView tvFoodName;
private ImageView ivStar;



    public FoodAdapter(Context context, int resource, ArrayList<food> objects) {
        super(context, resource, objects);

        //store the food that is passed to this adapter
        food = objects;
        //Store Context object as we would need to use it later
        this.context = context;
    }

    //getView() is the method ListView will call to get the view object everytime listview needs a row.
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //The usual way to get the layout inflater obj to "inflate" the XML file into a view object.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //"Inflate" the row.xml as the layout for the view object.
        View rowView = inflater.inflate(R.layout.row,parent,false);

        //get the TextView object
        tvFoodName = (TextView) rowView.findViewById(R.id.tvFoodName);
        //get the ImageView object
        ivStar = (ImageView) rowView.findViewById(R.id.ivStar);

        //the parameter "position" is the index of the row ListView is requesting.
        //We get back the food at the same index.
        food currentFood = food.get(position);

           tvFoodName.setText(currentFood.getName());

        //Set the image to star or nostar accordingly
        if(currentFood.isStar()){
            ivStar.setImageResource(R.drawable.star);
        }else {
            ivStar.setImageResource(R.drawable.nostar);
        }
        //Return the nicely done up View to the listview..
        return rowView;
    }
}
