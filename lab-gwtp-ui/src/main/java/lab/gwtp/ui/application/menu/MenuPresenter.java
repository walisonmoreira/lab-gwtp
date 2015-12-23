package lab.gwtp.ui.application.menu;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import lab.gwtp.ui.NameTokens;
import lab.gwtp.ui.application.ApplicationPresenter;

public class MenuPresenter extends Presenter<MenuPresenter.MyView, MenuPresenter.MyProxy> {
  interface MyView extends View {
  }

  @ProxyStandard
  @NameToken(NameTokens.MENU)
  interface MyProxy extends ProxyPlace<MenuPresenter> {
  }

  @Inject
  MenuPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
  }
}