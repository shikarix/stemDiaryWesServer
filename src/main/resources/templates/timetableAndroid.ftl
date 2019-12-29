<#import "parts/common.ftl" as pages>
<@pages.page "Расписание">
<img src="https://static.tildacdn.com/tild3865-3431-4934-a462-636139616135/noroot.png" alt="Стем">
<br/>
<#list dates as dates>
${dates}<br/>
</#list>
</@pages.page>