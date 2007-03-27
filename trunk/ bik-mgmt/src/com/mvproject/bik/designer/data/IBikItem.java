package com.mvproject.bik.designer.data;

public interface IBikItem {

	/**
	 * @uml.property name="BIK_OBJTYPE_DEPRECIATION"
	 */
	public static final int bik_objtype_depreciation = 9;

	/**
	 * @uml.property name="BIK_OBJTYPE_DEPRECIATION_PERCENT"
	 */
	public static final int bik_objtype_depreciation_percent = 10;

	/**
	 * @uml.property name="BIK_OBJTYPE_MATERIALS"
	 */
	public static final int bik_objtype_materials = 8;

	/**
	 * @uml.property name="BIK_OBJTYPE_PRICE_DEF"
	 */
	public static final int bik_objtype_price_def = 11;

	/**
	 * @uml.property name="BIK_OBJTYPE_SECTION"
	 */
	public static final int bik_objtype_section = 1;

	/**
	 * @uml.property name="BIK_OBJTYPE_SUBSECTION"
	 */
	public static final int bik_objtype_subsection = 3;

	/**
	 * @uml.property name="BIK_OBJTYPE_COMMENT"
	 */
	public static final int bik_objtype_comment = 4;

	/**
	 * @uml.property name="BIK_OBJTYPE_SUBSECTION_COMPANY_ASSIGNMENT"
	 */
	public static final int bik_objtype_subsection_company_assignment = 12;

	/**
	 * @uml.property name="BIK_OBJTYPE_LABOR"
	 */
	public static final int bik_objtype_labor = 7;

	/**
	 * @uml.property name="BIK_OBJTYPE_LABOR_COMPANY"
	 */
	public static final int bik_objtype_labor_company = 13;

	/**
	 * @uml.property name="BIK_OBJTYPE_WORK_ITEM"
	 */
	public static final int bik_objtype_work_item = 5;

	public abstract Object clone();
				
			
		

	/**
	 */
	public abstract int getBikObjType();

	/**
	 */
	public abstract int getListViewIndex();

	/**
	 */
	public abstract boolean isExpandable();

	/**
	 */
	public abstract boolean isExpanded();

	/**
	 */
	public abstract boolean isSelected();

	/**
	 */
	public abstract void setExpanded(boolean expandedVal);

	/**
	 */
	public abstract void setListViewIndex(int indexVal);

	/**
	 */
	public abstract void setSelected(boolean selectedVal);

		
		/**
		 */
		public abstract int getID();

			
			/**
			 */
			public abstract String getName();
			
		

}
