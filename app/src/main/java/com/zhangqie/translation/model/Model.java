package com.zhangqie.translation.model;

/**
 * Created by zhangqie on 2016/8/6.
 */

public interface Model<L> {

    void attchModel(L listener);

    void detachModel();
}
