package com.ctvit.msg.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ctvit.base.base.BaseFragment;
import com.ctvit.base.router.RouterFragmentPath;
import com.ctvit.msg.R;
import com.ctvit.msg.BR;
import com.ctvit.msg.databinding.FragmentMsgBinding;
import com.ctvit.msg.ui.viewmodel.MsgViewModel;




/**
 * Created by goldze on 2018/6/21
 */
@Route(path = RouterFragmentPath.Msg.PAGER_MSG)
public class MsgFragment extends BaseFragment<FragmentMsgBinding, MsgViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_msg;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
    }
}
