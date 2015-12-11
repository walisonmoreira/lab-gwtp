package lab.gwtp.ui.place;

import javax.inject.Inject;

import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest.Builder;

import lab.gwtp.ui.NameTokens;

public class PlaceManagerUtils {

	private final PlaceManager placeManager;

	@Inject
	public PlaceManagerUtils(PlaceManager placeManager) {
		this.placeManager = placeManager;
	}

	private void revealPlace(PlaceRequest placeRequest) {
		placeManager.revealPlace(placeRequest, true);
	}

	private Builder builder() {
		return new PlaceRequest.Builder();
	}

	public void revealPlaceLogin() {
		PlaceRequest placeRequest = builder().nameToken(NameTokens.LOGIN).build();
		revealPlace(placeRequest);
	}

	public void revealPlaceHome() {
		PlaceRequest placeRequest = builder().nameToken(NameTokens.HOME).build();
		revealPlace(placeRequest);
	}

	public void revealCurrentPlace() {
		placeManager.revealCurrentPlace();
	}
}
