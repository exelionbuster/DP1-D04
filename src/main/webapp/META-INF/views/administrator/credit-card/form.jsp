<%@page language="java"%>

<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="administrator.credit-card.form.label.holder-name" path="holderName"/>
	<acme:form-textbox code="administrator.credit-card.form.label.number" path="number"/>
	<acme:form-textbox code="administrator.credit-card.form.label.brand" path="brand"/>
	<acme:form-moment code="administrator.credit-card.form.label.expiration-date" path="expirationDate"/>
	<acme:form-textbox code="administrator.credit-card.form.label.cvv" path="cvv"/>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.credit-card.form.button.create" action="/administrator/credit-card/create"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.credit-card.form.button.update" action="/administrator/credit-card/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.credit-card.form.button.delete" action="/administrator/credit-card/delete"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.credit-card.form.button.update" action="/administrator/credit-card/update"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.credit-card.form.button.delete" action="/administrator/credit-card/delete"/>
	<acme:form-return code="administrator.credit-card.form.button.return" />	
</acme:form>
