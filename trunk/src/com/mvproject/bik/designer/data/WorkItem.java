package com.mvproject.bik.designer.data;


public class WorkItem extends AbstractBikItem {

	/**
	 * @uml.property  name="code"
	 */
	private String code = "";

	/**
	 * Getter of the property <tt>code</tt>
	 * @return  Returns the code.
	 * @uml.property  name="code"
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter of the property <tt>code</tt>
	 * @param code  The code to set.
	 * @uml.property  name="code"
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @uml.property  name="subsectionId"
	 */
	private String subsectionId = "";

	/**
	 * Getter of the property <tt>subsectionId</tt>
	 * @return  Returns the subsectionId.
	 * @uml.property  name="subsectionId"
	 */
	public String getSubsectionId() {
		return subsectionId;
	}

	/**
	 * Setter of the property <tt>subsectionId</tt>
	 * @param subsectionId  The subsectionId to set.
	 * @uml.property  name="subsectionId"
	 */
	public void setSubsectionId(String subsectionId) {
		this.subsectionId = subsectionId;
	}

}
