package lab.gwtp.ui.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import lab.gwtp.ui.application.home.HomeModule;
import lab.gwtp.ui.application.menu.MenuModule;

public class ApplicationModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    install(new HomeModule());
    install(new MenuModule());

    bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
  }
}