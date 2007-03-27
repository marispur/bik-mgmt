package com.mvproject.bik.designer.data;

import com.mvproject.bik.designer.ctrl.IController;
import java.util.Vector;

public interface IProvider {

	/**
	 */
	public abstract void setController(IController controllerVal);

	/**
	 */
	public abstract IController getController();

	/**
	 */
	public abstract boolean establishConnection(String urlVal);

	/**
	 */
	public abstract PriceList getPriceList();

	/**
	 */
	public abstract Vector getSectionIdList();

	/**
	 */
	public abstract Section getSection(int idVal);

	/**
	 */
	public abstract Vector getCommentIdList(int objTypeVal, int objIdVal);

	/**
	 */
	public abstract void updateSection(Section sectionVal);

	/**
	 */
	public abstract Vector getSubsectionIdList(int sectionIdVal);

	/**
	 */
	public abstract Subsection getSubsection(int idVal);

	/**
	 */
	public abstract void updateSubsection(Subsection subsectionVal);

	/**
	 */
	public abstract Vector getWorkItemIdList(int subsectionIdVal);

	/**
	 */
	public abstract WorkItem getWorkItem(int idVal);

	/**
	 */
	public abstract void updateWorkItem(WorkItem wiVal);

	/**
	 */
	public abstract Vector getDepreciationPercentIdList(int wiIdVal);

	/**
	 */
	public abstract DepreciationPercent getDepreciationPercent(int dpIdVal);

	/**
	 */
	public abstract void updateDepreciationPercent(DepreciationPercent dpVal);

	/**
	 */
	public abstract Vector getDepreciationIdList(int wiIdVal);

	/**
	 */
	public abstract Depreciation getDepreciation(int depreciationIdVal);

	/**
	 */
	public abstract void updateDepreciation(Depreciation depVal);

	/**
	 */
	public abstract Vector getMaterialIdList(int wiIdVal);

	/**
	 */
	public abstract Materials getMaterials(int materialsIdVal);

	/**
	 */
	public abstract void updateMaterials(Materials matVal);

	/**
	 */
	public abstract Vector getLabourIdList(int wiIdVal);

	/**
	 */
	public abstract Labour getLabour(int labourIdVal);

	/**
	 */
	public abstract void updateLabour(Labour labourVal);

		
		
		public abstract Vector getHistoryEvents(IBikItem bikItemVal, int maxEventCountVal);
		

		
			
			/** 
			 * Returns last 5 events for object requested
			 */
			public abstract Vector getHistoryEvents(IBikItem bikItemVal);
			
		
}
