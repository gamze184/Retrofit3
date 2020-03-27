package com.example.retrofitconfigrasyonu.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.retrofitconfigrasyonu.Main2Activity;
import com.example.retrofitconfigrasyonu.Models.Bilgiler;
import com.example.retrofitconfigrasyonu.R;

import java.util.List;

public class adapter extends BaseAdapter {
    List<Bilgiler> list;
    Context context;
    Activity activity;

    public adapter(List<Bilgiler> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        final TextView postId,id,name,email,body;
        LinearLayout layoutlist;
        layoutlist=convertView.findViewById(R.id.layoutlist);
        postId=(TextView) convertView.findViewById(R.id.postId);
        id=(TextView) convertView.findViewById(R.id.id);
        name=(TextView) convertView.findViewById(R.id.name);
        body=(TextView) convertView.findViewById(R.id.body);
        email=(TextView) convertView.findViewById(R.id.email);

        postId.setText(""+list.get(position).getId());
        id.setText(""+list.get(position).getId());
        name.setText(list.get(position).getName());
        body.setText(list.get(position).getBody());
        email.setText(list.get(position).getEmail());
        final String post=""+list.get(position).getPostId();
       final String idm=""+list.get(position).getId();

layoutlist.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent=new Intent(activity, Main2Activity.class);
        intent.putExtra("post id",post);
        intent.putExtra("id",idm);
                activity.startActivity(intent);
    }
});
        return convertView;
    }
}
