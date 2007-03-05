package com.mvproject.bik.designer.ctrl.messages;

import com.mvproject.bik.designer.ctrl.IController;
import com.mvproject.bik.designer.data.IDataProvider;
import com.mvproject.bik.designer.ui.IUIProvider;

public interface IControllerMessage {

		
		/**
		 */
		public abstract String getMessageName();

			
			/**
			 */
			public abstract int getMessageType();


				
				/**
				 */
				public abstract void process(IUIProvider uiVal, IController ctrlVal, IDataProvider dpVal);
				
			
		

}
