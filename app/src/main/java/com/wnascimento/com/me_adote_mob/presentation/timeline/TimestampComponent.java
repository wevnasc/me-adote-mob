package com.wnascimento.com.me_adote_mob.presentation.timeline;

import com.wnascimento.com.me_adote_mob.MainComponent;
import com.wnascimento.com.me_adote_mob.data.repository.contract.RepositoryComponent;
import com.wnascimento.com.me_adote_mob.util.dagger.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = {MainComponent.class, RepositoryComponent.class}, modules = TimelineModule.class)
public interface TimestampComponent {

    void inject(TimelineActivity view);

}