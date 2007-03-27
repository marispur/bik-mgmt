package com.mvproject.bik.designer.data;


public abstract class AbstractBikItem implements IBikItem {
	
	private java.lang.String name;
	/** 
	 * ID as stored in database
	 * @uml.property name="id"
	 */
	private int id;
	private int listViewIndex;
	private boolean expanded;
	private boolean selected;
	private boolean isExpandable = false;
	
		
		
		public Object clone(){
		
				return null;
			}
	
	public int getBikObjType() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getID() {
		return id;
	}

	public int getListViewIndex() {
		return listViewIndex;
	}

	public String getName() {
		return name;
	}

	public boolean isExpandable() {
		return isExpandable;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setExpanded(boolean expandedVal) {
		if (this.isExpandable()) expanded = expandedVal;
	}

	public void setListViewIndex(int indexVal) {
		listViewIndex=indexVal;
	}
	
	public void setSelected(boolean selectedVal) {
		selected = selectedVal;
	}

	/**
	 * Parent id as stored in database. For Section object this property has no meaning.
	 * @uml.property  name="parentId"
	 */
	private int parentId;



	/**
	 * Getter of the property <tt>parentId</tt>
	 * @return  Returns the parentId.
	 * @uml.property  name="parentId"
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * Setter of the property <tt>parentId</tt>
	 * @param parentId  The parentId to set.
	 * @uml.property  name="parentId"
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
