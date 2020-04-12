package com.jianhua.common.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

public abstract class BaseActivity <VM extends ViewModel,VDB extends ViewDataBinding> extends AppCompatActivity {

    protected VM viewModel;
    protected VDB dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBind();
        findViews();
        initViewModel(viewModel);
        dataBinding.setLifecycleOwner(this);
    }

    protected void dataBind(){
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    protected abstract void initViewModel(VM vm);

    protected abstract int getLayoutId();

    protected void findViews(){};
}
