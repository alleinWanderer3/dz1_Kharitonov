package com.example.dz1kharitonov;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class ChooseGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_gallery);
    }

    ImageView chooseGallery = findViewById(R.id.chooseGallery);

    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 12345);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 12345){
            if(resultCode == RESULT_OK){
                Uri uri = data.getData();
                Bitmap bitmap = null;
                ImageView imageView = findViewById(R.id.chooseGallery);
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
                    bitmap = Bitmap.createBitmap(bitmap,0,0,256,256);
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(bitmap!=null){
                        imageView.setImageBitmap(bitmap);
                    }   else {
                        imageView.setImageURI(uri);
                    }
                }
                imageView.setImageURI(uri);
            }else {
                Toast.makeText(this,"Выход",Toast.LENGTH_SHORT).show();
            }
        }
    } }

