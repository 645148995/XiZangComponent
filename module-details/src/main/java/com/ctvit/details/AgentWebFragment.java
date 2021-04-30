package com.ctvit.details;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import androidx.annotation.Nullable;


import com.ctvit.base.Constant;
import com.ctvit.base.base.BaseFragment;


import com.ctvit.details.databinding.FragmentAgentwebBinding;
import com.just.agentweb.AgentWeb;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.KLog;


/**
 * Created by cenxiaozhong on 2017/5/15.
 * source code  https://github.com/Justson/AgentWeb
 */

public class AgentWebFragment extends BaseFragment<FragmentAgentwebBinding, BaseViewModel> {

    private AgentWeb mAgentWeb;

    @Override
    public void initParam() {
        //获取列表传入的实体
        Bundle mBundle = getArguments();
        if (mBundle != null) {
            mBundle.getString(Constant.EXTRA_PAGE_ID);
            KLog.i("getArguments" + mBundle.getString("123"));
        }
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_agentweb;
    }


    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public void initData(View view) {

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent((LinearLayout) binding.linearLayout, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .createAgentWeb()
                .ready()
                .go("<p style=\\\"line-height: 30px; font-size: 17px; margin-top: 15px; overflow-wrap: break-word; font-weight: 400; text-align: justify; color: rgb(51, 51, 51); letter-spacing: 0px; font-family: PingFangSC-Regular, PingFangSC-Light, sans-serif;\\\">贵州茅台涨近2%，股价最高触及1829.69元，创出历史新高。</p><p style=\\\"line-height: 30px; font-size: 17px; margin-top: 15px; overflow-wrap: break-word; font-weight: 400; text-align: right; color: rgb(51, 51, 51); letter-spacing: 0px; font-family: PingFangSC-Regular, PingFangSC-Light, sans-serif;\\\">（编辑 龚新语）<br></p>");


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }
}
