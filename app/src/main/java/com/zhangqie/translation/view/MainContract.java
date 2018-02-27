package com.zhangqie.translation.view;

import java.util.Map;

/**
 * Created by zhangqie on 2017/2/26.
 */

public interface MainContract {

    interface DataListener extends BaseListener<String> {

    }
    interface DataModle {

        void requestData(Map<String, Object> map);

    }

    interface IMvpView<T> extends BaseView<T>{
        void updateView();

        void noData();//无数据

    }
    interface IMvpPresenter{

        //信用借还-订单记录
        void rorrownRecordList(Map<String, Object> map);

        void onRefresh();//刷新

        void onLoad();//加载更多

        void onResult(int position);

    }
    interface IMvpListener extends BaseListener<String>{

        void noData();
    }

}
