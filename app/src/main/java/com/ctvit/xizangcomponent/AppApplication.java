package com.ctvit.xizangcomponent;


import com.ctvit.base.router.config.ModuleLifecycleConfig;

import com.ctvit.base.base.BaseApplication;





/**
 * Created by goldze on 2018/6/21 0021.
 */

public class AppApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件(靠前)

        ModuleLifecycleConfig.getInstance().initModuleAhead(this);




        

        
//1234564654654
        //....
        //初始化组件(靠后)
        ModuleLifecycleConfig.getInstance().initModuleLow(this);
    }
}
