package lab.gwtp.ui.application.home;

import javax.inject.Inject;

import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import lab.gwtp.ui.NameTokens;
import lab.gwtp.ui.application.ApplicationPresenter;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {
  interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
  }

  @ProxyStandard
  @NameToken(NameTokens.HOME)
  interface MyProxy extends ProxyPlace<HomePresenter> {
  }

  private final PlaceManager placeManager;

  @Inject
  HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    this.placeManager = placeManager;
    getView().setUiHandlers(this);
  }

  public void mostrarMenu() {
    PlaceRequest menuPlaceRequest = new PlaceRequest.Builder()
        .nameToken(NameTokens.MENU)
        .build();
    placeManager.revealPlace(menuPlaceRequest);
  }
}