package lab.gwtp.ui.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import lab.gwtp.ui.application.about.AboutModule;
import lab.gwtp.ui.application.home.HomeModule;
import lab.gwtp.ui.application.login.LoginModule;

public class ApplicationModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new HomeModule());
		install(new LoginModule());
		install(new AboutModule());

		bindPresenter(ApplicationPresenter.class, 
									ApplicationPresenter.MyView.class, 
									ApplicationView.class,
									ApplicationPresenter.MyProxy.class);
	}
}