<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/card.ftl" as card>
<@pages.page "Расписание">
<@navbar.navbar is></@navbar.navbar>
<h3 style="display: block; text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.125); color: rgb(42, 202, 250); margin: 1%">Ближайшие занятия:</h3>
<div style=" display: flex; flex-flow: row wrap;">
<#list dates as d>
    <div class="card" style="width: 15%; margin: 1%;">
            <div class="card-header" style="text-align: center;">
                ${d.name}
            </div>
            <div class="card-body">
                <img src="${d.urlToLessonLogo}" style="display: block; margin-left: auto; margin-right: auto; width: 150px; height: 150px;"/>
                <h4 style="text-align: center; margin-bottom: 10px">
                    ${d.date1}
                </h4>
                <a href="/timetable/${d.id}"><button style="display: block; padding: 5px; margin-left: auto; margin-right: auto; border-radius: 10px; background-color: rgb(42, 202, 250); color: white; font-family: sans-serif; font-size 1.5em; border: none;">ПОДРОБНЕЕ</button></a>
            </div>
        </div>
</#list>
</div>
</@pages.page>