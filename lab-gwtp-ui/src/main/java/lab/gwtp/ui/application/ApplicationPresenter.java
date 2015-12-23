package lab.gwtp.ui.application;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

import lab.gwtp.ui.application.ApplicationPresenter.MyProxy;
import lab.gwtp.ui.application.ApplicationPresenter.MyView;

public class ApplicationPresenter extends Presenter<MyView, MyProxy> {
  interface MyView extends View {
  }

  @ProxyStandard
  interface MyProxy extends Proxy<ApplicationPresenter> {
  }

  public static final NestedSlot SLOT_MAIN = new NestedSlot();

  @Inject
  ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
    super(eventBus, view, proxy, RevealType.Root);
  }

}