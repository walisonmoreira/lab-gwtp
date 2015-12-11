package lab.gwtp.ui.application.about;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class AboutView extends ViewWithUiHandlers<AboutUiHandlers> implements AboutPresenter.MyView {

	interface Binder extends UiBinder<Widget, AboutView> {
	}

	@Inject
	AboutView(Binder uiBinder) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("submit")
	void onSubmitClicked(ClickEvent event) {
		getUiHandlers().callHome();
	}
}