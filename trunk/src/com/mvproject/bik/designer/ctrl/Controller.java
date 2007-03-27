package com.mvproject.bik.designer.ctrl;

import com.mvproject.bik.designer.ctrl.messages.IControllerMessage;
import com.mvproject.bik.designer.data.IBikItem;
import com.mvproject.bik.designer.data.IProvider;
import com.mvproject.bik.designer.ui.IUIProvider;
import java.util.Vector;


public class Controller extends Thread implements IController {

	/**
	 * @uml.property  name="dataProvider"
	 */
	private IProvider dataProvider = null;

	/**
	 * Getter of the property <tt>dataProvider</tt>
	 * @return  Returns the dataProvider.
	 * @uml.property  name="dataProvider"
	 */
	public IProvider getDataProvider() {
		return dataProvider;
	}

	/**
	 * Setter of the property <tt>dataProvider</tt>
	 * @param dataProvider  The dataProvider to set.
	 * @uml.property  name="dataProvider"
	 */
	public void setDataProvider(IProvider dataProvider) {
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
	private Vector<IControllerMessage> msgQ;

	public void addMessage(IControllerMessage msgVal) {
		msgQ.add(msgVal);
		
	}

		
		/**
		 */
		public Controller(){
			msgQ = new Vector<IControllerMessage>(); 
			listView = new Vector<IBikItem>();
		}

		public int getSelectedItemIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		/**
		 * @uml.property  name="listView"
		 */
		private Vector listView;

			
			/**
			 */
			public void addListViewItem(){
			
			}

				
				/**
				 */
				public void addListViewItem(int indexVal){
				
				}

					
					/**
					 */
					public IBikItem getListViewItem(int indexVal){
						return (IBikItem) listView.get(indexVal);
					}

					/**
					 */
					public void removeListViewItem(int indexVal){
					
					}

					/**
					 * @uml.property  name="controllerState"
					 */
					private int controllerState;

					/**
					 * Getter of the property <tt>controllerState</tt>
					 * @return  Returns the controllerState.
					 * @uml.property  name="controllerState"
					 */
					public int getControllerState() {
						return controllerState;
					}

					/**
					 * Setter of the property <tt>controllerState</tt>
					 * @param controllerState  The controllerState to set.
					 * @uml.property  name="controllerState"
					 */
					public void setControllerState(int state) {
						this.controllerState = state;
					}

}
