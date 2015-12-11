package lab.gwtp.ui.application.login;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class LoginView extends ViewWithUiHandlers<LoginUiHandlers> implements LoginPresenter.MyView {

	interface Binder extends UiBinder<Widget, LoginView> {
	}

	protected @UiField TextBox username;
	protected @UiField PasswordTextBox password;
	
	@Override
	protected void onAttach() {
		username.setFocus(true);
	}

	@Inject
	LoginView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("login")
	void onSubmitClicked(ClickEvent event) {
		getUiHandlers().login(username.getText(), password.getText());
		username.setText("");
		password.setText("");
	}
}