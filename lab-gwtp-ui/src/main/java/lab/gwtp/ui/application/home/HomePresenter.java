package lab.gwtp.ui.application.home;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import lab.gwtp.ui.NameTokens;
import lab.gwtp.ui.application.ApplicationPresenter;
import lab.gwtp.ui.place.PlaceManagerUtils;
import lab.gwtp.ui.restclient.UserService;
import lab.gwtp.ui.security.CurrentUser;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
	interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
	}

	@ProxyStandard
	@NameToken(NameTokens.HOME)
	interface MyProxy extends ProxyPlace<HomePresenter> {
	}

	private final PlaceManagerUtils placeManagerUtils;
	private final RestDispatch dispatcher;
	private final UserService userService;
	private final CurrentUser currentUser;

	@Inject
	HomePresenter(EventBus eventBus, 
								MyView view, 
								MyProxy proxy, 
								PlaceManagerUtils placeManager, 
								RestDispatch dispatcher,
								UserService userService, 
								CurrentUser currentUser) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		this.placeManagerUtils = placeManager;
		this.dispatcher = dispatcher;
		this.userService = userService;
		this.currentUser = currentUser;
		getView().setUiHandlers(this);
	}

	@Override
	public void logout() {
		dispatcher.execute(userService.logout(), new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				onLogout();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}

	protected void onLogout() {
		this.currentUser.setLoggedIn(false);
    revealLogin();
	}

	private void revealLogin() {
		placeManagerUtils.revealPlaceLogin();
	}
}