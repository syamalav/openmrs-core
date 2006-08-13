package org.openmrs.web.taglib.fieldgen;

import org.openmrs.util.OpenmrsConstants;

public class DateHandler extends AbstractFieldGenHandler implements FieldGenHandler {

	private String defaultUrl = "date.field";
	
	public void run() {
		setUrl(defaultUrl);

		htmlInclude("/scripts/calendar/calendar.js");
		
		String datePattern = OpenmrsConstants.OPENMRS_LOCALE_DATE_PATTERNS().get(getContext().getLocale().toString().toLowerCase());
		String needScript = "true";
		
		if ( getRequest().getAttribute("org.openmrs.widget.dateField.needScript") != null ) {
			needScript = "false";
		} else {
			getRequest().setAttribute("org.openmrs.widget.dateField.needScript", "false");
		}
		
		setParameter("datePattern", datePattern.toLowerCase());
		setParameter("needScript", needScript);
	}
}
