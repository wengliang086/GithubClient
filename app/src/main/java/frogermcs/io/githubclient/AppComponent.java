package frogermcs.io.githubclient;

import javax.inject.Singleton;

import dagger.Component;
import frogermcs.io.githubclient.data.api.GithubApiModule;
import frogermcs.io.githubclient.data.UserComponent;
import frogermcs.io.githubclient.data.api.UserModule;
import frogermcs.io.githubclient.ui.activity.component.SplashActivityComponent;
import frogermcs.io.githubclient.ui.activity.module.SplashActivityModule;

/**
 * Created by Miroslaw Stanek on 22.04.15.
 */
//@Component:Component从根本上来说就是一个注入器，也可以说是@Inject和@Module的桥梁，它的主要作用就是连接这两个部分。
// 将Module中产生的依赖对象自动注入到需要依赖实例的Container中。
@Singleton
@Component(
        modules = {// 指明Component查找Module的位置
                AppModule.class,
                GithubApiModule.class
        }
)
// 必须定义为接口，Dagger2框架将自动生成Component的实现类，对应的类名是Dagger×××××，这里对应的实现类是DaggerAppComponent
public interface AppComponent {
    // 注入到A(Container)的方法，方法名一般使用inject
    // 注入到SplashActivityModule(Container)的方法，方法名一般使用plus
    SplashActivityComponent plus(SplashActivityModule module);

    UserComponent plus(UserModule userModule);

}