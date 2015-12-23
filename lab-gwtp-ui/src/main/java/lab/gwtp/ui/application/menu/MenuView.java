package lab.gwtp.ui.application.menu;

import com.google.gwt.user.client.ui.Label;
import com.gwtplatform.mvp.client.ViewImpl;

public class MenuView extends ViewImpl implements MenuPresenter.MyView {
  MenuView() {
    initWidget(new Label("Menu!"));
  }
}