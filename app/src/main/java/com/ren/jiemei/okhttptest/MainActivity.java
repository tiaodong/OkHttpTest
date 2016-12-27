package com.ren.jiemei.okhttptest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ren.jiemei.mylibrary.LoadTest;



public class MainActivity extends AppCompatActivity {

    private Button load;

    String url = "http://img02.tooopen.com/images/20141231/sy_78327074576.jpg";
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        load = (Button) findViewById(R.id.load);
        image = (ImageView) findViewById(R.id.image);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final LoadTest loadTest = new LoadTest();
                loadTest.setUrl(url);
                loadTest.execute();
                loadTest.setDataListence(new LoadTest.setDataL() {
                    @Override
                    public void getData(byte[] data) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                        image.setImageBitmap(bitmap);
                    }
                });


            }
        });
    }
}
