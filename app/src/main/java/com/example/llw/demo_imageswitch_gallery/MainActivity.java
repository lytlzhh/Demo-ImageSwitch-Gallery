package com.example.llw.demo_imageswitch_gallery;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    private Gallery gallery;
    private  int sum =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gally);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.image);

        final int[] picture =new int[] {R.drawable.d,R.drawable.dd,R.drawable.a,R.drawable.c,
                R.drawable.b,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.qq};

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                ImageSwitcher.LayoutParams pp = new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                imageView.setLayoutParams(pp);
                return imageView;
            }
        });

     //   imageSwitcher.setImageResource(picture[sum]);

        BaseAdapter adapter = new BaseAdapter() {


            @Override
            public int getCount() {

                return picture.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

             /* //  imageView1.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
              //  imageView1.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
              imageView1.setPadding(1,1,1,1);
                imageView1.setImageResource(picture[position]);*/
                ImageView imageView1 = null;
                if (convertView==null)
                {
                    imageView1 = new ImageView(MainActivity.this);
                    imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
                  //  imageView1.setLayoutParams(new ViewGroup.LayoutParams(160, 160));
                    //  TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery)
                  //  imageView1.setPadding(1,1,1,1);

                }else {
                    imageView1 = (ImageView) convertView;
                }
                imageView1.setImageResource(picture[position]);
                return imageView1;
            }
        };

        gallery.setAdapter(adapter);
      //  gallery.setSelection(picture.length/2);
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imageSwitcher.setImageResource(picture[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
