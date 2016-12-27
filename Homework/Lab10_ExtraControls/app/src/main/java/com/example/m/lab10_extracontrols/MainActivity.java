package com.example.m.lab10_extracontrols;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.widget.BaseAdapter;


import android.view.ViewGroup;





public class MainActivity extends AppCompatActivity {
Spinner spinner;
    String[] pies;
    TextView text;
    Button postButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postButton=(Button) findViewById(R.id.button);
        postButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent startIntent=new Intent(getApplicationContext(),Tri_C.class);
                        startActivity(startIntent);
                    }
                });

        //spinner=(Spinner)findViewById(R.id.spinner);
        //Resources resourses=getResources();
        //pies=resourses.getStringArray(R.array.pie_array);
        //text=(TextView) findViewById(R.id.textView);
        //spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pies));
        //spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
          //  @ Override
          //  public void onItemSelected(AdapterView<?> parent, View view, int position,long id){
            //    Toast.makeText(getApplicationContext(),pies[position],Toast.LENGTH_SHORT).show();
              //  parent.getItemAtPosition(position);
                //String Text = spinner.getSelectedItem().toString();
                //text.setText(Text);
            //}
            //@Override
            //public void onNothingSelected(AdapterView<?> parent){}
        //});
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7
        };
    }

}
