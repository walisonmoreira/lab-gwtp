package lab.gwtp.ui;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule.Builder;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

import lab.gwtp.ui.application.ApplicationModule;
import lab.gwtp.ui.dispatch.DispatchModule;
import lab.gwtp.ui.place.PlaceManagerUtilsModule;
import lab.gwtp.ui.security.SecurityModule;

public class ClientModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new Builder()
				.tokenFormatter(RouteTokenFormatter.class)
				.defaultPlace(NameTokens.HOME)
				.errorPlace(NameTokens.HOME)
				.unauthorizedPlace(NameTokens.LOGIN).build());

		install(new ApplicationModule());
		install(new DispatchModule());
		install(new SecurityModule());
		install(new PlaceManagerUtilsModule());
	}
}