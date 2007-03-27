package com.mvproject.bik.designer.data;

import com.mvproject.bik.designer.ctrl.IController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class PostgresProvider implements IProvider {

	/**
	 * @uml.property name="connectionSql"
	 */
	private Connection connectionSql;

	/**
	 * @uml.property name="connectionString"
	 */
	private String connectionString = "";

	/**
	 * @uml.property name="controller"
	 */
	private IController controller;

	/**
	 * @uml.property name="rsComments"
	 */
	private String rsComments = "";

	/**
	 * @uml.property name="rsDepreciation"
	 */
	private ResultSet rsDepreciation;

	/**
	 * @uml.property name="rsDepreciationPercent"
	 */
	private ResultSet rsDepreciationPercent;

	/**
	 * @uml.property name="rsHistoryEvents"
	 */
	private ResultSet rsHistoryEvents;

	/**
	 * @uml.property name="rsLabour"
	 */
	private ResultSet rsLabour;

	/**
	 * @uml.property name="rsMaterials"
	 */
	private ResultSet rsMaterials;

	/**
	 * @uml.property name="rsPriceList"
	 */
	private ResultSet rsPriceList;

	/**
	 * @uml.property name="rsSections"
	 */
	private ResultSet rsSections;

	/**
	 * @uml.property name="rsSubsections"
	 */
	private ResultSet rsSubsections;

	/**
	 * @uml.property name="rsWorkItems"
	 */
	private ResultSet rsWorkItems;

	/**
	 */
	public PostgresProvider(IController controllerVal) {

	}

	public boolean establishConnection(String urlVal) {
		// TODO Auto-generated method stub
		connectionString = new String(urlVal);
		return false;
	}

	public Vector getCommentIdList(int objTypeVal, int objIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Getter of the property <tt>controller</tt>
	 * 
	 * @return Returns the controller.
	 * @uml.property name="controller"
	 */
	public IController getController() {
		return controller;
	}

	public Depreciation getDepreciation(int depreciationIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getDepreciationIdList(int wiIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public DepreciationPercent getDepreciationPercent(int dpIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getDepreciationPercentIdList(int wiIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getHistoryEvents(IBikItem bikItemVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getHistoryEvents(IBikItem bikItemVal, int maxEventCountVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Labour getLabour(int labourIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getLabourIdList(int wiIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getMaterialIdList(int wiIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Materials getMaterials(int materialsIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public PriceList getPriceList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Section getSection(int idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getSectionIdList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Subsection getSubsection(int idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getSubsectionIdList(int sectionIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public WorkItem getWorkItem(int idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getWorkItemIdList(int subsectionIdVal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Resets connection to database and refreshes recordsets.
	 */
	public void resetRecordsets() {

	}

	/**
	 * Setter of the property <tt>controller</tt>
	 * 
	 * @param controller
	 *            The controller to set.
	 * @uml.property name="controller"
	 */
	public void setController(IController controller) {
		this.controller = controller;
	}

	public void updateDepreciation(Depreciation depVal) {
		// TODO Auto-generated method stub

	}

	public void updateDepreciationPercent(DepreciationPercent dpVal) {
		// TODO Auto-generated method stub

	}

	public void updateLabour(Labour labourVal) {
		// TODO Auto-generated method stub

	}

	public void updateMaterials(Materials matVal) {
		// TODO Auto-generated method stub

	}

	public void updateSection(Section sectionVal) {
		// TODO Auto-generated method stub

	}

	public void updateSubsection(Subsection subsectionVal) {
		// TODO Auto-generated method stub

	}

	public void updateWorkItem(WorkItem wiVal) {
		// TODO Auto-generated method stub

	}

}
