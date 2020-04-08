<#import "parts/common.ftl" as page>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/alertTab.ftl" as alert>
<#import "parts/card.ftl" as card>
<@page.page "Новости">
    <div style="background-color: #eeeeee">
    <@navbar.navbar is color></@navbar.navbar>
    <div style="width: 75%; position: relative; left: 12.5%">
        <#list posts as post>
            <@card.card '${post.text}' '${post.srcToImage}' '${post.date}'></@card.card>
        </#list>
    </div>
    </div>


</@page.page>