package com.jianhua.katdemo;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import com.jianhua.common.base.BaseActivity;
import com.jianhua.katdemo.databinding.ActivityDemoBinding;

public class DemoActivity extends BaseActivity<DemoViewModel,ActivityDemoBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViewModel(DemoViewModel demoViewModel) {
        viewModel = ViewModelProviders.of(this).get(DemoViewModel.class);
        dataBinding.setViewModel(viewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo;
    }

    @Override
    protected void findViews() {}
}
