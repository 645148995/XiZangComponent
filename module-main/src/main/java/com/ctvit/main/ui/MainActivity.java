package com.ctvit.main.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ctvit.base.base.BaseActivity;
import com.ctvit.base.router.RouterActivityPath;
import com.ctvit.base.router.RouterFragmentPath;
import com.ctvit.main.R;
import com.ctvit.main.BR;
import com.ctvit.main.databinding.ActivityMainBinding;


import java.util.ArrayList;
import java.util.List;


import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.utils.KLog;
import me.goldze.mvvmhabit.utils.ToastUtils;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by goldze on 2018/6/21
 */
@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {
    private long touchTime = 0; // 再点一次退出程序时间设置
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIVE = 4;
    private SupportFragment[] mFragments = new SupportFragment[5];

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }

    private void initFragment() {
        if ((ARouter.getInstance().build(
                RouterFragmentPath.Home.PAGER_HOME).navigation()) == null) {
            //防止单独运行时候找不到类 崩溃
            return;

        }

        SupportFragment firstFragment = findFragment(((SupportFragment) ARouter.getInstance().build(
                RouterFragmentPath.Home.PAGER_HOME).navigation()).getClass());
        if (firstFragment == null) {


            //ARouter拿到多Fragment(这里需要通过ARouter获取，不能直接new,因为在组件独立运行时，宿主app是没有依赖其他组件，所以new不到其他组件的Fragment)
            mFragments[FIRST] = (SupportFragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME).navigation();
            mFragments[SECOND] = (SupportFragment) ARouter.getInstance().build(RouterFragmentPath.CARDGROUPS.PAGER_CARDGROUPS).navigation();
            mFragments[THIRD] = (SupportFragment) ARouter.getInstance().build(RouterFragmentPath.Msg.PAGER_MSG).navigation();
            mFragments[FOURTH] = (SupportFragment) ARouter.getInstance().build(RouterFragmentPath.User.PAGER_ME).navigation();
            mFragments[FIVE] = (SupportFragment) ARouter.getInstance().build(RouterFragmentPath.Msg.PAGER_MSG).navigation();


            loadMultipleRootFragment(R.id.frameLayout, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH],
                    mFragments[FIVE]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(((SupportFragment) ARouter.getInstance().build(
                    RouterFragmentPath.CARDGROUPS.PAGER_CARDGROUPS).navigation()).getClass());
            mFragments[THIRD] = findFragment(((SupportFragment) ARouter.getInstance().build(
                    RouterFragmentPath.Msg.PAGER_MSG).navigation()).getClass());
            mFragments[FOURTH] = findFragment(((SupportFragment) ARouter.getInstance().build(
                    RouterFragmentPath.User.PAGER_ME).navigation()).getClass());
            mFragments[FIVE] = findFragment(((SupportFragment) ARouter.getInstance().build(
                    RouterFragmentPath.Msg.PAGER_MSG).navigation()).getClass());
        }


    }

    private void initBottomTab() {


        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.mipmap.yingyong, "广播电视")
                .addItem(R.mipmap.yingyong, "新闻")
                .addItem(R.mipmap.huanzhe, "视听")
                .addItem(R.mipmap.xiaoxi_select, "直播", ContextCompat.getColor(this, R.color.colorAccent))
                .addItem(R.mipmap.wode_select, "我的")
//                .addItem(R.mipmap.wode_select, "我的")
                .setDefaultColor(ContextCompat.getColor(this, R.color.textColorVice))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                showHideFragment(mFragments[index], mFragments[old]);
            }

            @Override
            public void onRepeat(int index) {
                // 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                LiveEventBus.get(Constant.LiveDataBus.TABAUTOREFRESH)
//                        .post(index);
            }
        });


    }

    @Override
    public void onBackPressedSupport() {

        if (System.currentTimeMillis() - touchTime < 2000) {
            finish();
        } else {
            touchTime = System.currentTimeMillis();
            ToastUtils.showShort(R.string.press_again_exit);
        }
    }
}
