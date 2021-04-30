package com.ctvit.details;

import android.os.Bundle;


import com.alibaba.android.arouter.facade.annotation.Route;

import com.ctvit.base.base.BaseActivity;
import com.ctvit.base.router.RouterActivityPath;


import me.yokeyword.fragmentation.SupportFragment;
@Route(path = RouterActivityPath.Web.PAGER_WEB)
public class AgentWebActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SupportFragment fragment = findFragment(AgentWebFragment.class);
        if (fragment == null)
            loadRootFragment(R.id.rel_webfragment, new AgentWebFragment());

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_webview;
    }

    @Override
    public int initVariableId() {
        return 0;
    }



}
