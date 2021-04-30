package com.ctvit.cardgroups.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;


import com.ctvit.cardgroups.R;
import com.ctvit.cardgroups.base.BaseViewHolder;


import com.ctvit.base.base.BaseViewType;



/**
 * 默认布局。如果itemType没找到，就用这个布局，必须有，否则recyclerivew报错找不到itemType
 */

public class CardGroupsDefault extends BaseViewHolder<BaseViewType> {

    public CardGroupsDefault(Context context, ViewGroup parent) {
        super(context, parent, R.layout.cardgroups_default);
    }

    @Override
    public void findView(View itemView) {

    }

    @Override
    public void setData(BaseViewType data) {

    }
}
