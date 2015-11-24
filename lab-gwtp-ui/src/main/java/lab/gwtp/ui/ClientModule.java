package lab.gwtp.ui;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule.Builder;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

import lab.gwtp.ui.application.ApplicationModule;

public class ClientModule extends AbstractPresenterModule {
  @Override
  protected void configure() {
    install(new Builder()
        .tokenFormatter(RouteTokenFormatter.class)
        .defaultPlace(NameTokens.HOME)
        .errorPlace(NameTokens.HOME)
        .unauthorizedPlace(NameTokens.HOME)
        .build());

    install(new ApplicationModule());
  }
}