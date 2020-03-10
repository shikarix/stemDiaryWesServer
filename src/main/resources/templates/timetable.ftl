<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/card.ftl" as card>
<@pages.page "Расписание">
<@navbar.navbar is></@navbar.navbar>
<#list dates as d>
    <div class="card" style="width: 15%; margin: 1%">
        <div class="card-header">
            ${d.name}
        </div>
        <div class="card-body">
            <h4>
                ${d.time} <br/>
                ${d.date1}
            </h4>
            <div class="text-muted">
                ${d.date2} <br/>
                ${d.date3} <br/>
                ${d.date4} <br/>
                ${d.date5}
            </div>
        </div>
    </div>
</#list>
</@pages.page>