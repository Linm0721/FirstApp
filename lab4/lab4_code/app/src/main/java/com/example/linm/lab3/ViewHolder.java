package com.example.linm.lab3;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ACER on 2017/10/23.
 */

public class ViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViews; //存储list_Item的子View
    private View mConvertView; //存储list_Item

    public ViewHolder(Context context, View itemView, ViewGroup parent){
        super(itemView);
        mConvertView = itemView;
        mViews = new SparseArray<View>();
    }

    //获取viewHolder实例
    public static ViewHolder get(Context context, ViewGroup parent, int layoutId){
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        ViewHolder holder = new ViewHolder(context, itemView, parent);
        return holder;
    }

    //通过id获取view
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view==null){
            //创建view
            view = mConvertView.findViewById(viewId);
            //将view存入mViews
            mViews.put(viewId, view);
        }
        return (T) view;
    }
}
