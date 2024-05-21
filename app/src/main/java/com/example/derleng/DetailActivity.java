package com.example.derleng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.derleng.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        String imageUrl = getIntent().getStringExtra("image_url");
        String provinceName = getIntent().getStringExtra("province_name");
        String pageBannerTitle = getIntent().getStringExtra("page_banner_title");
        String section1PhotoUrl = getIntent().getStringExtra("section1_photo_url");
        String section2PhotoUrl = getIntent().getStringExtra("section2_photo_url");
        String section2PhotoUrl2 = getIntent().getStringExtra("section2_photo_url2");
        String section3PhotoUrl = getIntent().getStringExtra("section3_photo_url");
        String section1PhotoDesc = getIntent().getStringExtra("section1_photo_desc");
        String section2PhotoDesc = getIntent().getStringExtra("section2_photo_desc");
        String section3PhotoDesc = getIntent().getStringExtra("section3_photo_desc");
        String sectionPhotoDesc = getIntent().getStringExtra("des");


        TextView textView = findViewById(R.id.province_name);
        textView.setText(provinceName);
        ImageView imageView = findViewById(R.id.res_image);
        Picasso.get().load(imageUrl).into(imageView);
        TextView textView1 = findViewById(R.id.page_banner_title);
        textView1.setText(pageBannerTitle);
        TextView textView2 = findViewById(R.id.page_banner_titles);
        textView2.setText(pageBannerTitle);
        TextView textView3 = findViewById(R.id.des1);
        textView3.setText(sectionPhotoDesc);
        ImageView imageView1 = findViewById(R.id.section1_photo);
        Picasso.get().load(section1PhotoUrl).into(imageView1);
        TextView textView4 = findViewById(R.id.section1_photo_desc);
        textView4.setText(section1PhotoDesc);
        ImageView imageView2 = findViewById(R.id.section2_photo);
        Picasso.get().load(section2PhotoUrl).into(imageView2);
        TextView textView5 = findViewById(R.id.section2_photo_desc);
        textView5.setText(section2PhotoDesc);
        ImageView imageView3 = findViewById(R.id.section2_photo2);
        Picasso.get().load(section2PhotoUrl2).into(imageView3);
        ImageView imageView4 = findViewById(R.id.section3_photo);
        Picasso.get().load(section3PhotoUrl).into(imageView4);
        TextView textView6 = findViewById(R.id.section3_photo_desc);
        textView6.setText(section3PhotoDesc);

        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}