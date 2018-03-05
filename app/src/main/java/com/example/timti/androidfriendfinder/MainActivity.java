package com.example.timti.androidfriendfinder;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView animalName;
    private TextView animalAge;
    private ImageView animalImage;
    private Button rightButton;
    private Button leftButton;
    ArrayList<AnimalClass> animalList = new ArrayList<AnimalClass>();
    int i = animalList.size()/2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animalList.add(new AnimalClass("Bonnie", "Dog", "Labrador", 3, R.drawable.dog_ggg));
        animalList.add(new AnimalClass("Cam the Camel", "Camel", "Wolly Camel", 11, R.drawable.camel));
        animalList.add(new AnimalClass("Annie", "Dog", "Labrador", 2, R.drawable.dog_ggg));
        animalList.add(new AnimalClass("Lamfred the Lion", "Cat", "African Lion", 4, R.drawable.camel));
        animalList.add(new AnimalClass("Lucy", "Dog", "Labrador", 4, R.drawable.dog_ggg));
        animalList.add(new AnimalClass("Wolly the Sheep", "Sheep", "Bluefaced Leicester", 2, R.drawable.camel));
        animalList.add(new AnimalClass("Missy", "Dog", "West Highland White Terrior", 13, R.drawable.dog_ggg));
        animalList.add(new AnimalClass("Lucifer", "Cat", "Bengal", 6, R.drawable.camel));


        rightButton = (Button) findViewById(R.id.rightButton);
        leftButton = (Button) findViewById(R.id.leftButton);
        animalName = (TextView) findViewById(R.id.animalName);
        animalAge = (TextView) findViewById(R.id.animalAge);
        animalImage = (ImageView) findViewById(R.id.animalImage);

        animalName.setText(animalList.get(i).getName());
        animalAge.setText("Age: " + String.valueOf(animalList.get(i).getAge()));
        animalImage.setImageResource(animalList.get(i).getPhotoid());

        rightButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        i++;
                        if (i >= animalList.size()){
                            i = 0;
                        }
                        animalName.setText(animalList.get(i).getName());
                        animalAge.setText("Age: " + String.valueOf(animalList.get(i).getAge()));
                        animalImage.setImageResource(animalList.get(i).getPhotoid());
                    }
                }
        );

        leftButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        i--;
                        if (i < 0)
                        {
                            i = animalList.size()-1;
                        }
                        animalName.setText(animalList.get(i).getName());
                        animalAge.setText("Age: " + String.valueOf(animalList.get(i).getAge()));
                        animalImage.setImageResource(animalList.get(i).getPhotoid());
                    }
                }
        );

    }
}
