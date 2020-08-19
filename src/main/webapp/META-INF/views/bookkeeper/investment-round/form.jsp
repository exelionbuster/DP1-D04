<%@page language="java"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<acme:form readonly="true">

	<acme:form-textbox code="bookkeeper.investment-round.form.label.ticker" path="ticker"/>
	<acme:form-moment code="bookkeeper.investment-round.form.label.creation-date" path="creationDate"/>
	<acme:form-textbox code="bookkeeper.investment-round.form.label.kind" path="kind"/>	
	<acme:form-textbox code="bookkeeper.investment-round.form.label.title" path="title"/>
	<acme:form-textarea code="bookkeeper.investment-round.form.label.description" path="description"/>
	<acme:form-money code="bookkeeper.investment-round.form.label.amount" path="amount"/>
	<acme:form-url code="bookkeeper.investment-round.form.label.link" path="link"/>
	
	<jstl:if test="${activities}">
		<acme:form-submit test="${command != 'create'}" method="get" code="bookkeeper.investment-round.form.button.activities" action="/authenticated/activity/list?id=${id}"/>
	</jstl:if>
	
	<acme:form-return code="bookkeeper.investment-round.form.button.return" />
		
</acme:form>
