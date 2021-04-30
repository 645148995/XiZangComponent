package com.ctvit.home.debug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import androidx.annotation.Nullable;

import com.ctvit.base.base.ContainerActivity;

import com.ctvit.home.ui.channel.ChannelFragment;




/**
 * 组件单独运行时的调试界面，不会被编译进release里
 * Created by goldze on 2018/6/21
 */

public class DebugActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, ContainerActivity.class);
        intent.putExtra("fragment", ChannelFragment.class.getCanonicalName());
        this.startActivity(intent);
        finish();
    }
}
