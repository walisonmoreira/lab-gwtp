package lab.gwtp.ui.application.home;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements HomePresenter.MyView {
  HomeView() {
    FlowPanel fp = new FlowPanel();
    fp.add(new Label("Home!"));
    Button ok = new Button("Ok");
    ok.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        getUiHandlers().mostrarMenu();
      }
    });
    fp.add(ok);
    initWidget(fp);
  }
}