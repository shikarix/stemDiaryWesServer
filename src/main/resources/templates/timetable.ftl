<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Расписание">
<@navbar.navbar></@navbar.navbar>
<#list dates as dates>
${dates}<br/>
</#list>
</@pages.page>