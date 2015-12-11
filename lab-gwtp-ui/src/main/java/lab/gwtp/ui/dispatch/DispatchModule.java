package lab.gwtp.ui.dispatch;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.dispatch.rest.client.RestApplicationPath;
import com.gwtplatform.dispatch.rest.client.gin.RestDispatchAsyncModule;

import lab.gwtp.shared.ResourcePaths;

public class DispatchModule extends AbstractGinModule {
	@Override
	protected void configure() {
		RestDispatchAsyncModule.Builder dispatchBuilder = new RestDispatchAsyncModule.Builder();
		install(dispatchBuilder.build());

		bindConstant().annotatedWith(RestApplicationPath.class).to(ResourcePaths.ROOT);
	}
}