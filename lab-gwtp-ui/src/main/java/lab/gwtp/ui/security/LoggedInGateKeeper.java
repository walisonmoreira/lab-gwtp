package lab.gwtp.ui.security;

import javax.inject.Inject;

import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

@DefaultGatekeeper
public class LoggedInGateKeeper implements Gatekeeper {

	private final CurrentUser currentUser;

	@Inject
	public LoggedInGateKeeper(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	@Override
	public boolean canReveal() {
		return currentUser.isLoggedIn();
	}

}
