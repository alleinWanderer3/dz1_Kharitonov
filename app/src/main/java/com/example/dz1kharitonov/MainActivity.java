package com.example.dz1kharitonov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Exit;
    Button chooseGallery;
    private Object v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Exit = findViewById(R.id.Exit);
Exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        MainActivity.this.finish();
    }});


        Button chooseGallery = findViewById(R.id.chooseGallery);
        chooseGallery.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, ChooseGallery.class);
            startActivity(intent);}
    }
);
}
}
