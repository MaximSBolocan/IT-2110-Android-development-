package com.example.m.lab09_materialdesign;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecycleView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    RecycleView pieRecyclerView;
    private RecycleView.LayoutManager pieLayoutManager;
    ArrayList<Pie> pies;

    @Override
    proteted void onCreate(Bundle saveInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    pieRecyclerView=(RecycleView)findViewById(R.id.recuclerView);
    pieRecyclerView.setHasFixedSize(true);
    pies=makePies();
    pieLayoutManager=new LinearLayoutManager(this);
    pieRecyclerView.setLayoutManager(pieLayoutManager);
    PieAdapter adapter=new PieAdapter(pies);
    pieRecyclerView.setAdapter(adapter);
}
    public class PieAdapter extends RecycleView.Adapter<ViewHolder>
    {
        Context mContext;
        ArrayList<Pie>mPies;
        LayoutInflater mInflater;

        public PieAdapter(ArrayList<Pie>pies)
        {
            mPies=pies
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
        {
            View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.pie_view_item, parent,false);
            return new ViewHolder(v);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder, int position)
        {
            Pie currentPie =mPies.get(position);
            holder.textViewName.setText(currentPie.mName);
            holder.textViewDescription.setText(currentPie.mDescription);
            NumberFormat formatter=NumberFormat.getCurrencyInstance();
            String price=formatter.format(currentPie.mPrice);
            holder.texViewPrice.setText(price);
        }
        @Override
        public int getItemCount()
        {
            return mPies.size();
        }

    }
    private class ViewHolder extends RecycleView.ViewHolder
    {
        public TextView textViewName;
        public TextView textViewDescription;
        public TextView texViewPrice;
        public ViewHolder(View v)
        {
            super(v);
            textViewName=(TextView)v.findViewById(R.id.textViewName);
            textViewDescription=(TextView)v.findViewById(R.id.textViewDescription);
            texViewPrice= (TextView)v.findViewById(R.id.texViewPrice);
        }
    }
    private ArrayList<Pie>makePies()
    {
        ArrayList<Pie>pies= new ArrayList<Pie>();
        pies.add(new Pie("","",0));
        pies.add(new Pie("","",1));
        pies.add(new Pie("","",2));
        pies.add(new Pie("","",3));
        return pies;
    }
    private class Pie
    {
        String mName;
        String mDescription;
        double mPrice;
        public Pie (String name,String description,double price)
        {
            this.mName=name;
            this.mDescription=description;
            this.mPrice=price;
        }
    }
}
