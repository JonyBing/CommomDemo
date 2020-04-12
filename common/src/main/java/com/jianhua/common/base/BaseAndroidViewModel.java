package com.jianhua.common.base;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseAndroidViewModel extends AndroidViewModel {

    private CompositeDisposable mCompositeDisposable;

    public BaseAndroidViewModel(Application application) {
        super(application);
    }

    public void addSubscribe(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }


    private void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    @Override
    protected void onCleared() {
        unSubscribe();
        super.onCleared();
    }
}
