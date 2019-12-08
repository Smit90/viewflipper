package com.example.viewflipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ViewFlipper v_flipper;
    Spinner dropdownmenu;
    Spinner dropdownlist;
    String City [] = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dropdownmenu = (Spinner) findViewById(R.id.spinner);
        dropdownlist = (Spinner) findViewById(R.id.spinner2);
        dropdownmenu.setOnItemSelectedListener(this);

        /*List<String> list = new ArrayList<>();
        list.add("");
        list.add("Gujarat");
        list.add("Maharashtra");
        list.add("Rajasthan");
        list.add("Goa");
        list.add("Pune");*/

        /*ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownmenu.setAdapter(adapter);

        dropdownmenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemvalue =  adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Selected" + itemvalue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/






        int images [] = {R.drawable.slide1, R.drawable.slide4, R.drawable.slide6};
        v_flipper = findViewById(R.id.v_flipper);

        //loop

        for (int i = 0; i< images.length; i++)
        {
            flipperimages(images[i]);
        }

//         prefer foreach loop

       for (int image : images){
            flipperimages(image);
        }
    }

    public void flipperimages(int image)
        {

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);// 4 sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
        }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(l==0)
        {
            City = new String[]{};
        }
        if(l == 1)
        {
            City = new String[]{"Surat", "Vadodara", "Ghandhinagar"};

        }
        if(l ==2)
        {
            City  = new String[]{"Mumbai"};
        }
        if(l ==3)
        {
            City = new String[]{"Udaypur"};
        }
        if(l==4)
        {
            City = new String[]{"idk"};
        }
        if(l ==5)
        {
            City = new String[]{"idk"};
        }
        else
        {
            String City =  adapterView.getItemAtPosition(i).toString();
            //Toast.makeText(MainActivity.this, "Selected" + itemvalue, Toast.LENGTH_SHORT).show();

            if(adapterView.getItemAtPosition(i).equals("Gujarat")){
                Intent intent = new Intent(MainActivity.this, listSelected.class);
                startActivity(intent);
            }
        }

        ArrayAdapter<String> adt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, City);
        dropdownlist.setAdapter(adt);

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

