package com.bawei.wangyi20200224.presenter;

import com.bawei.wangyi20200224.contract.IHomePageContract;
import com.bawei.wangyi20200224.model.IHomePageModel;

/**
 * p层
 */
public class IHomePagePresenter implements IHomePageContract.IPresenter {
    private IHomePageContract.IView mView;
    private IHomePageModel mModel;

     //构造方法
    public IHomePagePresenter(IHomePageContract.IView view) {
        mView = view;
        mModel=new IHomePageModel();
    }

    @Override
    public void getBanner(String url) {
        mModel.getBanner(url, new IHomePageContract.IModel.ICallBackModel() {
            @Override
            public void getBannerSuccess(String str) {
                mView.getBannerSuccess(str);
            }

            @Override
            public void getBannerFaliure(String str) {
                mView.getBannerFaliure(str);

            }
        });

    }

    @Override
    public void getList(String url) {
        mModel.getList(url, new IHomePageContract.IModel.CallBack() {
            @Override
            public void getListSuccess(String str) {
                mView.getListSuccess(str);
            }

            @Override
            public void getListFaliure(String str) {
                mView.getListFaliure(str);

            }
        });
    }
}
