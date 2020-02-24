package com.bawei.wangyi20200224.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bawei.wangyi20200224.activity.MainActivity;
import com.bawei.wangyi20200224.bean.BeanInfo;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：DELL<p>
 * <p>创建时间：2020/1/9<p>
 * <p>版本号：1<p>
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<BeanInfo.ResultsBean.NewsistBean> newsist;

    public MyAdapter(Context context, List<BeanInfo.ResultsBean.NewsistBean> newsist) {
        this.context = context;
        this.newsist = newsist;
    }

    @Override
    public int getCount() {
        return newsist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
