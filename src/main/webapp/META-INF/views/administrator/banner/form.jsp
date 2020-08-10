<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-textbox code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>
	<acme:form-textbox code="administrator.banner.form.label.target" path="target"/>
	
	<acme:form-select code="administrator.banner.form.label.credit-card" path="creditCardId">
		<jstl:if test="${creditCardId != null}">
			<acme:form-option code="${creditCardNumber}" value="${creditCardId}"/>
		</jstl:if>
		<acme:form-option code="administrator.banner.form.credit-card.default" value=""/>
		<jstl:forEach items="${creditCards}"  var="creditCard">
			<acme:form-option code="${creditCard.number}" value="${creditCard.id}"/>
		</jstl:forEach>
	</acme:form-select>
	
	
	<jstl:if test="${creditCardId != null}">
		<acme:form-return code="administrator.banner.form.button.credit-card" action="/administrator/credit-card/show?id=${creditCardId}"/>
		<br>
		<br>
	</jstl:if>
	<acme:form-submit test="${command == 'create'}" code="administrator.banner.form.button.create" action="/administrator/banner/create"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.banner.form.button.update" action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.banner.form.button.delete" action="/administrator/banner/delete"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.banner.form.button.update" action="/administrator/banner/update"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.banner.form.button.delete" action="/administrator/banner/delete"/>
	<acme:form-return code="administrator.banner.form.button.return" />
		
</acme:form>
