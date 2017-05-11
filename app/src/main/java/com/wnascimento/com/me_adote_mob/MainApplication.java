package com.wnascimento.com.me_adote_mob;

import android.app.Application;

import com.wnascimento.com.me_adote_mob.data.repository.contracts.DaggerRepositoryComponent;
import com.wnascimento.com.me_adote_mob.data.repository.contracts.RepositoryComponent;
import com.wnascimento.com.me_adote_mob.data.repository.retrofit.RepositoryRetrofitModule;

public class MainApplication extends Application {

    public static MainComponent mainComponent;
    public static RepositoryComponent repositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(getApplicationContext()))
                .build();

        repositoryComponent = DaggerRepositoryComponent.builder()
                .repositoryRetrofitModule(new RepositoryRetrofitModule())
                .build();

    }
}
