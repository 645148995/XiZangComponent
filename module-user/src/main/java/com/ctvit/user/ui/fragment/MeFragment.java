package com.ctvit.user.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ctvit.base.base.BaseFragment;
import com.ctvit.base.router.RouterFragmentPath;
import com.ctvit.user.R;
import com.ctvit.user.BR;
import com.ctvit.user.databinding.FragmentMeBinding;
import com.ctvit.user.ui.viewmodel.MeViewModel;




/**
 * Created by goldze on 2018/6/21
 */
@Route(path = RouterFragmentPath.User.PAGER_ME)
public class MeFragment extends BaseFragment<FragmentMeBinding, MeViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_me;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
    }
}
