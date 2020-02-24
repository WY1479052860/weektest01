package com.bawei.wangyi20200224.activity;



import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bawei.wangyi20200224.R;
import com.bawei.wangyi20200224.base.BaseActivity;
import com.bawei.wangyi20200224.bean.BeanInfo;
import com.bawei.wangyi20200224.contract.IHomePageContract;
import com.bawei.wangyi20200224.presenter.IHomePagePresenter;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * v层  主页面
 */
public class MainActivity extends BaseActivity implements IHomePageContract.IView {

    private XBanner xb;
    private ListView lv;
    private IHomePagePresenter mPresenter;
    String url="http://blog.zhaoliang5156.cn/api/news/news_data.json";

    //加载布局资源
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
    //加载控件
    @Override
    protected void initView() {
        //找控件
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);

    }
   //加载数据
    @Override
    protected void initData() {
        mPresenter = new IHomePagePresenter(this);
        mPresenter.getBanner(url);


    }
    //获取轮播成功的方法
    @Override
    public void getBannerSuccess(String str) {
        //解析展示
        Gson gson = new Gson();
        BeanInfo beanInfo = gson.fromJson(str, BeanInfo.class);
        final List<BeanInfo.ResultsBean> results = beanInfo.getResults();
        //设置数据源
        xb.setBannerData(results);
        //加载图片
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                BeanInfo.ResultsBean resultsBean = results.get(position);
                List<BeanInfo.ResultsBean.BannerBean> banner1 = resultsBean.getBanner();
                Glide.with(MainActivity.this).load(banner1).into((ImageView) view);
            }
        });

    }
    //获取轮播失败的方法
    @Override
    public void getBannerFaliure(String str) {

    }
    //获取列表成功的方法
    @Override
    public void getListSuccess(String str) {

    }
   //获取列表失败的方法
    @Override
    public void getListFaliure(String str) {

    }
}
