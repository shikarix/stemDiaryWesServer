<#import "parts/common.ftl" as pages>
<@pages.page "Database">
<#list strings as str>
"${str}"
<#else>
"Go daleko!"
</#list>
</@pages.page>