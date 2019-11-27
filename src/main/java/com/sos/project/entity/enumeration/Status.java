package com.sos.project.entity.enumeration;


/**
 * 
 * @author lweyri
 *
 */
public enum Status
{
	OPEN("OPEN","color:DARKBLUE; font-weight:bold;"), 
	IN_PROGRESS("IN PROGRESS","color: DARKGREEN; font-weight:bold;"), 
	BLOCKED("BLOCKED","color: white; background-color: DarkViolet; font-weight:bold;"), 
	ON_HOLD("ON HOLD","color: white; background-color: DarkSlateBlue; font-weight:bold;"), 
	CLOSED("CLOSED","color: white; background-color: BLACK; font-weight:bold;"),
	HIDDEN("HIDDEN","color: lightgrey; background-color: white; font-weight:bold;");
	
	private String style;
	private String statusName;
	
	Status(String statusName, String style)
	{
		this.statusName = statusName;
		this.style = style;
	}
	
	public String getStyle()
	{
		return style;
	}

	public String getStatusName() {
		return statusName;
	}
}
