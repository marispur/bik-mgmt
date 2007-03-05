package com.mvproject.bik.designer.ctrl;

import com.mvproject.bik.designer.ctrl.messages.IControllerMessage;
import com.mvproject.bik.designer.data.IDataProvider;
import com.mvproject.bik.designer.ui.IUIProvider;
import java.util.Vector;


public class Controller extends Thread implements IController {

	/**
	 * @uml.property  name="dataProvider"
	 */
	private IDataProvider dataProvider = null;

	/**
	 * Getter of the property <tt>dataProvider</tt>
	 * @return  Returns the dataProvider.
	 * @uml.property  name="dataProvider"
	 */
	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	/**
	 * Setter of the property <tt>dataProvider</tt>
	 * @param dataProvider  The dataProvider to set.
	 * @uml.property  name="dataProvider"
	 */
	public void setDataProvider(IDataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	/**
	 * @uml.property  name="uiProvider"
	 */
	private IUIProvider uiProvider = null;

	/**
	 * Getter of the property <tt>uiProvider</tt>
	 * @return  Returns the uiProvider.
	 * @uml.property  name="uiProvider"
	 */
	public IUIProvider getUiProvider() {
		return uiProvider;
	}

	/**
	 * Setter of the property <tt>uiProvider</tt>
	 * @param uiProvider  The uiProvider to set.
	 * @uml.property  name="uiProvider"
	 */
	public void setUiProvider(IUIProvider uiProvider) {
		this.uiProvider = uiProvider;
	}

	/**
	 * @uml.property  name="msgQ"
	 */
	private Vector msgQ;

		
			
			/**
			 */
			public synchronized void addMessage(IControllerMessage msgval){
			
					
					}

}
