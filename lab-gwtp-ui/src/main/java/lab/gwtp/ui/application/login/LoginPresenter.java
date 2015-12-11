package lab.gwtp.ui.application.login;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
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
import lab.gwtp.ui.restclient.UserService;
import lab.gwtp.ui.security.CurrentUser;

public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy>
		implements LoginUiHandlers {
	interface MyView extends View, HasUiHandlers<LoginUiHandlers> {
	}

	@ProxyStandard
	@NoGatekeeper
	@NameToken(NameTokens.LOGIN)
	interface MyProxy extends ProxyPlace<LoginPresenter> {
	}

	private final PlaceManagerUtils PlaceManagerUtils;
	private final RestDispatch dispatcher;
	private final UserService userService;
	private final CurrentUser currentUser;

	@Inject
	LoginPresenter(EventBus eventBus, 
								 MyView view, 
								 MyProxy proxy, 
								 PlaceManagerUtils PlaceManagerUtils, 
								 RestDispatch dispatcher,
								 UserService userService, 
								 CurrentUser currentUser) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
		this.PlaceManagerUtils = PlaceManagerUtils;
		this.dispatcher = dispatcher;
		this.userService = userService;
		this.currentUser = currentUser;
		getView().setUiHandlers(this);
	}

	@Override
	public void login(String login, String password) {
		sendLoginRequest(login, password);
	}

	private void sendLoginRequest(String username, String password) {
		dispatcher.execute(userService.login(username, password), new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void user) {
				onLoginSuccess();
			}

			@Override
			public void onFailure(Throwable caught) {
				onLoginFailure();
			}
		});
	}

	private void onLoginSuccess() {
		currentUser.setLoggedIn(true);
		PlaceManagerUtils.revealPlaceHome();
	}

	private void onLoginFailure() {
		Window.alert("Wrong login or password.");
	}
}