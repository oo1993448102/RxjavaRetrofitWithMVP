package com.echo.rxjavaretrofitwithmvp.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.echo.rxjavaretrofitwithmvp.R;
import com.echo.rxjavaretrofitwithmvp.entity.AnnexMode;

import java.util.List;

/**
 * Created by EchoZhou on 2016/8/4.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;

    private List<AnnexMode> list;

    public MyAdapter(Context context, List<AnnexMode> list) {
        this.context = context;
        this.list = list;
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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_annex, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        AnnexMode mode = list.get(position);
        holder.tv_name.setText(mode.getName());

        return convertView;
    }

    class ViewHolder {
        TextView tv_name;
    }

    public void updateListView(List<AnnexMode> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }
}
