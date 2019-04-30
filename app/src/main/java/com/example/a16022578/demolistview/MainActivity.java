package com.example.a16022578.demolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<food> food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvFood);

        //Create a few food object in food array
        food = new ArrayList<food>();
        food.add(new food("Ah Lat Coffee", false));
        food.add(new food("Rock Choc", true));
        food.add(new food("Kid Cat Choc", true));

        //Link this Activity object, the row.xml layout for each row and the food String array together.
         aa = new FoodAdapter(this, R.layout.row, food);
         lv.setAdapter(aa);


         lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 food selectedFood = food.get(position);

                 Toast.makeText(MainActivity.this, selectedFood.getName()
                                 + " Star: " + selectedFood.isStar(),
                         Toast.LENGTH_LONG).show();
             }

         });



    }
}
