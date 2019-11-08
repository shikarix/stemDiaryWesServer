<#import "parts/common.ftl" as page>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/alertTab.ftl" as alert>
<#import "parts/card.ftl" as card>
<@page.page>
    <@navbar.navbar></@navbar.navbar>
    <div class="card-columns">
            <#list text as text>
                <@card.card  "${text}" "2 дня назад" "https://sun9-16.userapi.com/c851224/v851224158/194606/pW5Vv5hvKX4.jpg">
                </@card.card>
            </#list>
    </div>


</@page.page>