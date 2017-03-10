package frogermcs.io.githubclient;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frogermcs.io.githubclient.utils.AnalyticsManager;
import frogermcs.io.githubclient.utils.Validator;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
// Module类里面的方法专门提供依赖，所以我们定义一个类，用@Module注解，这样Dagger在构造类的实例的时候，就知道从哪里去找到需要的依赖。
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    //@Provides:在Module中，我们定义的方法是用这个注解，以此来告诉Dagger我们想要构造对象并提供这些依赖。
    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    AnalyticsManager provideAnalyticsManager() {
        return new AnalyticsManager(application);
    }

    @Provides
    @Singleton
    Validator provideValidator() {
        return new Validator();
    }

    @Provides
    @Singleton
    HeavyExternalLibrary provideHeavyExternalLibrary() {
        HeavyExternalLibrary heavyExternalLibrary = new HeavyExternalLibrary();
        heavyExternalLibrary.init();
        return heavyExternalLibrary;
    }

    @Provides
    @Singleton
    HeavyLibraryWrapper provideLibraryWrapper() {
        return new HeavyLibraryWrapper();
    }
}