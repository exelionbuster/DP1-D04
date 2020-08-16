<%@page language="java"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">

	<acme:form-textbox code="entrepreneur.application.form.label.ticker" path="ticker"/>
	<acme:form-moment code="entrepreneur.application.form.label.creationDate" path="creationDate"/>
	<acme:form-textbox code="entrepreneur.application.form.label.statement" path="statement"/>	
	<acme:form-textbox code="entrepreneur.application.form.label.offer" path="offer"/>
	<acme:form-textbox code="entrepreneur.application.form.label.investor" path="investor.userAccount.username"/>
	
	<acme:form-return code="entrepreneur.application.form.button.return" />
		
</acme:form>
