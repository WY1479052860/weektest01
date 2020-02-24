package com.bawei.wangyi20200224.model;

import android.util.Log;

import com.bawei.wangyi20200224.contract.IHomePageContract;
import com.bawei.wangyi20200224.utils.NetUtils;

/**
 * m层
 */
public class IHomePageModel implements IHomePageContract.IModel {
    @Override
    public void getBanner(String url, final ICallBackModel iCallBackModel) {
       NetUtils.getNetUtils().getJson(url, new NetUtils.ICallBack() {
           @Override
           public void Success(String json) {
               Log.i("xxx",json);
               iCallBackModel.getBannerSuccess(json);
           }
           @Override
           public void Error(String msg) {
               iCallBackModel.getBannerFaliure(msg);

           }
       });
    }

    @Override
    public void getList(String url, final CallBack callBack) {
        NetUtils.getNetUtils().getJson(url, new NetUtils.ICallBack() {
            @Override
            public void Success(String json) {
                Log.i("xxx",json);
                callBack.getListSuccess(json);
            }

            @Override
            public void Error(String msg) {
                callBack.getListFaliure(msg);

            }
        });

    }
}
