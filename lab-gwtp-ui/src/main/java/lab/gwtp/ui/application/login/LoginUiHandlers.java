package lab.gwtp.ui.application.login;

import com.gwtplatform.mvp.client.UiHandlers;

public interface LoginUiHandlers extends UiHandlers {
	void login(String usernamen, String password);
}
