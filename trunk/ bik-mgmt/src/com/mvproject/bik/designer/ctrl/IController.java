package com.mvproject.bik.designer.ctrl;

import com.mvproject.bik.designer.ctrl.messages.IControllerMessage;
import com.mvproject.bik.designer.data.IProvider;
import com.mvproject.bik.designer.ui.IUIProvider;


public interface IController {

		
		
		public abstract void addMessage(IControllerMessage msgVal);
		

		
		/** 
		 * Setter of the property <tt>uiProvider</tt>
		 * @param uiProvider  The uiProvider to set.
		 */
		public abstract void setUiProvider(IUIProvider uiProviderVal);
		

	/**
	 * Getter of the property <tt>uiProvider</tt>
	 * @return  Returns the uiProvider.
	 * @uml.property  name="uiProvider"
	 */
	public IUIProvider getUiProvider();

		
		/** 
		 * Setter of the property <tt>dataProvider</tt>
		 * @param dataProvider  The dataProvider to set.
		 */
		public abstract void setDataProvider(IProvider dataProviderVal);
		

	/**
	 * Getter of the property <tt>dataProvider</tt>
	 * @return  Returns the dataProvider.
	 * @uml.property  name="dataProvider"
	 */
	public IProvider getDataProvider();



		
		/**
		 */
		public abstract int getSelectedItemIndex();




		
		/**
		 * @uml.property  name="STATE_WAIT_LOGIN_INFO"
		 */
		public static final int state_wait_login_info=1;
		/**
		 * @uml.property  name="STATE_WAIT_LOGIN_RESULT"
		 */
		public static final int state_wait_login_result = 2;
		/**
		 * @uml.property  name="STATE_READY"
		 */
		public static final int state_ready = 3;
		/**
		 * @uml.property  name="STATE_CONNECT_FAILED_WAIT_USER_ACTION"
		 */
		public static final int state_connect_failed_wait_user_action = 4;
		/**
		 * @uml.property  name="STATE_CONNECT_FAILED_WAIT_LOGIN_RESULT"
		 */
		public static final int state_connect_failed_wait_login_result = 5;
		
		
	
	


}
