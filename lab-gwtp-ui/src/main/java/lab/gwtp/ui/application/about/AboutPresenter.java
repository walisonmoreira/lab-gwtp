package lab.gwtp.ui.application.about;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.NoGatekeeper;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import lab.gwtp.ui.NameTokens;
import lab.gwtp.ui.application.ApplicationPresenter;
import lab.gwtp.ui.place.PlaceManagerUtils;

public class AboutPresenter extends Presenter<AboutPresenter.MyView, AboutPresenter.MyProxy> implements AboutUiHandlers {
	interface MyView extends View, HasUiHandlers<AboutUiHandlers> {
	}

	@ProxyStandard
	@NoGatekeeper
	@NameToken(NameTokens.ABOUT)
	interface MyProxy extends ProxyPlace<AboutPresenter> {
	}

	private final PlaceManagerUtils PlaceManagerUtils;

	@Inject
	AboutPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManagerUtils PlaceManagerUtils) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		this.PlaceManagerUtils = PlaceManagerUtils;
		getView().setUiHandlers(this);
	}

	@Override
	public void callHome() {
		PlaceManagerUtils.revealPlaceHome();
	}
}