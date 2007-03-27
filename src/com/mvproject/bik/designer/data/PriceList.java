package com.mvproject.bik.designer.data;

import javax.swing.table.AbstractTableModel;


public class PriceList extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter of the property <tt>price</tt>
	 * @return  Returns the price.
	 * @uml.property  name="price"
	 */
	public Float getPrice(int idVal) {
		return new Float(0);
	}

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName(int idVal) {
		return null;
	}

	/**
	 * Getter of the property <tt>category</tt>
	 * @return  Returns the category.
	 * @uml.property  name="category"
	 */
	public String getCategory(int idVal) {
		return null;
	}

}
