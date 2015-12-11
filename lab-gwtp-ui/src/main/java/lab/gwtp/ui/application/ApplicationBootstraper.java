package lab.gwtp.ui.application;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.dispatch.rest.client.RestDispatch;
import com.gwtplatform.mvp.client.Bootstrapper;

import lab.gwtp.ui.place.PlaceManagerUtils;
import lab.gwtp.ui.restclient.UserService;
import lab.gwtp.ui.security.CurrentUser;

public class ApplicationBootstraper implements Bootstrapper {

	private final PlaceManagerUtils placeManagerUtils;
	private final CurrentUser currentUser;
	private final RestDispatch dispatcher;
	private final UserService userService;

	@Inject
	public ApplicationBootstraper(PlaceManagerUtils placeManager, CurrentUser currentUser, RestDispatch dispatcher,
			UserService userService) {
		this.placeManagerUtils = placeManager;
		this.currentUser = currentUser;
		this.dispatcher = dispatcher;
		this.userService = userService;
	}

	@Override
	public void onBootstrap() {
		dispatcher.execute(userService.isCurrentUserLoggedIn(), new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				setLoggedIn(result);
			}

			@Override
			public void onFailure(Throwable caught) {
				onLoginFailure(caught);
			}
		});

	}

	protected void setLoggedIn(Boolean isCurrentUserLoggedIn) {
		currentUser.setLoggedIn(isCurrentUserLoggedIn);

		if (isCurrentUserLoggedIn) {
			placeManagerUtils.revealCurrentPlace();
		} else {
			revealLogin();
		}
	}

	private void revealLogin() {
		placeManagerUtils.revealPlaceLogin();
	}

	private void onLoginFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

}
