/*
 * BikObjType.java
 *
 * Created on pirmdiena, 2007, 16 aprîlis, 12:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author mpurins
 */
public enum BikObjType {
	CATALOG (0),
	SECTION (1),
	SUBSECTION (2),
	WORK_ITEM (3),
	DEPRECIATION (4),
	DEPRECIATION_PERCENT (5),
	MATERIAL (6),
	LABOUR (7),
	PRICE_DEFINITION (100),
	HISTORY_EVENT(101),
	COMMENT (102),
	UNKNOWN (1000);
	
	private int id;
	
	private BikObjType(int idVal) {
		this.id = idVal;
	}
	/**
	 * @return  the id
	 * @uml.property  name="id"
	 */
	public int getId() {return this.id;}
}
