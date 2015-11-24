package lab.gwtp.ui.application.home;

import com.google.gwt.user.client.ui.Label;
import com.gwtplatform.mvp.client.ViewImpl;

public class HomeView extends ViewImpl implements HomePresenter.MyView {
  HomeView() {
    initWidget(new Label("Hello World!"));
  }
}