package com.ctvit.work.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.ctvit.base.base.BaseFragment;
import com.ctvit.base.router.RouterFragmentPath;
import com.ctvit.work.R;
import com.ctvit.work.BR;
import com.ctvit.work.databinding.FragmentWorkBinding;
import com.ctvit.work.ui.viewmodel.WorkViewModel;




/**
 * Created by goldze on 2018/6/21
 */
@Route(path = RouterFragmentPath.Work.PAGER_WORK)
public class WorkFragment extends BaseFragment<FragmentWorkBinding, WorkViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_work;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
    }
}
