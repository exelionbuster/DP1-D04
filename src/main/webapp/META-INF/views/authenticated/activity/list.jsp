<%--
- list.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>

	<acme:list-column code="authenticated.activity.list.label.title" path="title" width="30%"/>
	<acme:list-column code="authenticated.activity.list.label.end-date" path="endDate" width="35%"/>
	<acme:list-column code="authenticated.activity.list.label.budget" path="budget" width="35%"/>
	
		
</acme:list>


