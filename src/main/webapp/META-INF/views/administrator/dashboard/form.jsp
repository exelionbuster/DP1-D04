<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
div.containerL{
display: inline-block;
width: 40%;
text-align: center
}
div.containerR{
display: inline-block;
width: 40%;
text-align: center}
</style>

<h1>
	<acme:message code="administrator.dashboard.form.title" />
</h1>

<br />
<br />

<table>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.total-notices"/>
		</td>
		<td>
			<acme:print value="${ numberOfNotices}"/>
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.total-tech-records"/>
		</td>
		<td>
			<acme:print value="${ numberOfTechnologyRecords}"/>
		</td>
	</tr>
	<!-- 
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.total-tool-records"/>
		</td>
		<td>
			<acme:print value="${ numberOfToolRecords}"/>
		</td>
	</tr>
	-->
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.min-money-active-inquiries"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumMinMoneyActiveInquiries}"/> 	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumMinMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ avgMinMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevMinMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.max-money-active-inquiries"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumMaxMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumMaxMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ avgMaxMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevMaxMoneyActiveInquiries}"/>	&euro;
		</td>
	</tr>
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.min-money-active-overtures"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumMinMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumMinMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ avgMinMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevMinMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
</table>
<br />
<br />
<table>
	<tr>
		<th colspan="2">
			<acme:message code="administrator.dashboard.form.table.title.max-money-active-overtures"/>
		</th>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.min"/>
		</td>
		<td>
			<acme:print value="${ minimumMaxMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.max"/>
		</td>
		<td>
			<acme:print value="${ maximumMaxMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.avg"/>	
		</td>
		<td>
			<acme:print value="${ avgMaxMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
	<tr>
		<td>
			<acme:message code="administrator.dashboard.form.table.cell.stats.stddev"/>
		</td>
		<td>
			<acme:print value="${ stddevMaxMoneyActiveOvertures}"/>	&euro;
		</td>
	</tr>
</table>
<br />
<br />
<h2></h2>
<div class="containerL">
	<b><acme:message code="administrator.dashboard.form.chart.title.techs-by-sector"/></b>
	<br /><br />
	<canvas id="chart-area"></canvas>
</div>

<div class="containerR">
	<b><acme:message code="administrator.dashboard.form.chart.title.techs-by-licence"/></b>
	<br /><br />
	<canvas id="chart-area2" ></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
				<jstl:forEach var="sector" items="${techRecordsSectors}" varStatus="loop">
					"<jstl:out value="${sector}"/>"
					<jstl:if test="${!loop.last}"> ,</jstl:if>
				</jstl:forEach>		
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="recordsNum" items="${techRecordsBySector}" varStatus="loop">
							<jstl:out value="${recordsNum}"/>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
							
						</jstl:forEach>
					],
					backgroundColor : [
						<jstl:forEach var="recordsNum" items="${techRecordsBySector}" varStatus="loop">
							<jstl:choose>
								<jstl:when test="${loop.count % 3 == 1}">
									'rgba(50,0,200,1)'
								</jstl:when>
								
								<jstl:when test="${loop.count % 3 == 2}">
									'rgba(200, 50, 0, 1)'
								</jstl:when>
								
								<jstl:otherwise>
									'rgba(0, 200, 50, 1)'
								</jstl:otherwise>
							</jstl:choose>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
						</jstl:forEach>
					]
				}
			]
		};
		var options = {
				responsive : true
			};
		var canvas, context;
		
		canvas = document.getElementById("chart-area3");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : ["Open-source","Closed-source"],
			datasets: [
				{
					data: [
						<jstl:forEach var="licenceCount" items="${techRecordsLicence}" varStatus="loop">
							<jstl:out value="${licenceCount}"/>
							<jstl:if test="${!loop.last}"> ,</jstl:if>							
						</jstl:forEach>
					],
					backgroundColor : [	"green", "red" ]
				}
			]
		};
		var options = {
				responsive : true
			};
		var canvas, context;
		
		canvas = document.getElementById("chart-area4");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>

<br />
<br />
<br />
<br />
<div class="containerL">
	<b><acme:message code="administrator.dashboard.form.chart.title.tools-by-sector"/></b>
	<br /><br />
	<canvas id="chart-area3"></canvas>
</div>

<div class="containerR">
	<b><acme:message code="administrator.dashboard.form.chart.title.tools-by-licence"/></b>
	<br /><br />
	<canvas id="chart-area4" ></canvas>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : [
				<jstl:forEach var="sector" items="${toolRecordsSectors}" varStatus="loop">
					"<jstl:out value="${sector}"/>"
					<jstl:if test="${!loop.last}"> ,</jstl:if>
				</jstl:forEach>		
			],
			datasets: [
				{
					data: [
						<jstl:forEach var="recordsNum" items="${toolRecordsBySector}" varStatus="loop">
							<jstl:out value="${recordsNum}"/>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
							
						</jstl:forEach>
					],
					backgroundColor : [
						<jstl:forEach var="recordsNum" items="${toolRecordsBySector}" varStatus="loop">
							<jstl:choose>
								<jstl:when test="${loop.count % 3 == 1}">
									'rgba(50,0,200,1)'
								</jstl:when>
								
								<jstl:when test="${loop.count % 3 == 2}">
									'rgba(200, 50, 0, 1)'
								</jstl:when>
								
								<jstl:otherwise>
									'rgba(0, 200, 50, 1)'
								</jstl:otherwise>
							</jstl:choose>
							<jstl:if test="${!loop.last}"> ,</jstl:if>
						</jstl:forEach>
					]
				}
			]
		};
		var options = {
				responsive : true
			};
		var canvas, context;
		
		canvas = document.getElementById("chart-area");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		var data = {
			labels : ["Open-source","Closed-source"],
			datasets: [
				{
					data: [
						<jstl:forEach var="licenceCount" items="${toolRecordsLicence}" varStatus="loop">
							<jstl:out value="${licenceCount}"/>
							<jstl:if test="${!loop.last}"> ,</jstl:if>							
						</jstl:forEach>
					],
					backgroundColor : [	"green", "red" ]
				}
			]
		};
		var options = {
				responsive : true
			};
		var canvas, context;
		
		canvas = document.getElementById("chart-area2");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "pie",
			data : data,
			options : options
		});
	});
</script>
