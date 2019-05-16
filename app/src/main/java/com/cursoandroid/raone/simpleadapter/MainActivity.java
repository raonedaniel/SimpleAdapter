package com.cursoandroid.raone.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {


    private String[] BrandName = new String[]{"iPhone","Samsung","Nokia","HTC","Moto"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mlist = (ListView) findViewById(R.id.list);
        MyListAdapter mAdapter = new MyListAdapter();
        mlist.setAdapter(mAdapter);
    }

    private class MyListAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            if (BrandName!= null && BrandName.length != 0){
                return BrandName.length;
            }
            return 0;
        }

        @Override
        public Object getItem (int position)
        {
            return BrandName[position];
        }
        @Override
        public long getItemId (int position)
        {
            return position;
        }

        public class ViewHolder{
            TextView txtBrandName;
            int ref;
        }

        @Override
        public View getView(final int position, View ConvertView, ViewGroup parent){
            final ViewHolder holder;
            if (ConvertView == null){
                holder = new ViewHolder();
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                ConvertView = inflater.inflate(R.layout.itemlist, null);
                holder.txtBrandName = (TextView) ConvertView.findViewById(R.id.itemName);

                ConvertView.setTag(holder);

            }
            else {
                holder = (ViewHolder) ConvertView.getTag();
            }
            holder.ref=position;
            holder.txtBrandName.setText(BrandName[position]);

            return ConvertView;
        }
    }
}
