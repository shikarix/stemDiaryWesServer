<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/card.ftl" as card>
<@pages.page "Расписание">
<@navbar.navbar is></@navbar.navbar>
<#list dates as dates>
<@card.course "${dates}"></@card.course><br/>
</#list>
</@pages.page>