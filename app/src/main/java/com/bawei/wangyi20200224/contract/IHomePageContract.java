package com.bawei.wangyi20200224.contract;

/**
 * 契约类
 */
public interface IHomePageContract {
    //v层
    interface IView{
        void getBannerSuccess(String str);
        void getBannerFaliure(String str);

        void getListSuccess(String str);
        void getListFaliure(String str);
    }
    //p层
    interface IPresenter{
        void getBanner(String url);
        void getList(String url);
    }
    //m层
    interface IModel{
        void getBanner(String url,ICallBackModel iCallBackModel);

        interface ICallBackModel{
            void getBannerSuccess(String str);
            void getBannerFaliure(String str);
        }
        void getList(String url,CallBack callBack);

        interface CallBack{
            void getListSuccess(String str);
            void getListFaliure(String str);
        }


    }

}
