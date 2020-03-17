<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "${name}">
<@navbar.navbar is></@navbar.navbar>
<h3>${name}</h3>
<div>
    ${time}, ${date}
</div>
<div>
    Ещё занятия:
    <ul>
        <#list dates as d>
            <li>${d}</li>
        </#list>
    </ul>
</div>
</@pages.page>