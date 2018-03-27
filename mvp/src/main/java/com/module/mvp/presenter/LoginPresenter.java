package com.module.mvp.presenter;

import com.module.mvp.model.PersonModel;

public interface LoginPresenter {
    void validateCredentials(PersonModel personModel);

    void onDestroy();
}
