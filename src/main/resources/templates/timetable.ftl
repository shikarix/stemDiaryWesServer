<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/card.ftl" as card>
<@pages.page "Расписание">
<@navbar.navbar is></@navbar.navbar>
<h3 style="display: block; text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.125); color: rgb(42, 202, 250); margin: 1%; text-align: center;">Ближайшие занятия:</h3>
<div style=" display: flex; flex-flow: row wrap; -webkit-justify-content: center;">
<#list dates as d>
    <div class="card" style="width: 15%; margin: 1%; min-width: 155px; --height: height;">
            <div class="card-header" style="text-align: center;">
                ${d.name}
            </div>
            <div class="card-body">
                <img src="${d.urlToLessonLogo}" style="display: block; margin-left: auto; margin-right: auto; width: 10vw; height: 10vw; min-width:100px; min-height: 100px;"/>
                <h4 style="text-align: center; margin-bottom: 10px">
                    ${d.date1}
                </h4>
                <a href="/timetable/${d.id}"><button style="display: block; padding: 5px; margin-left: auto; margin-right: auto; border-radius: 10px; background-color: rgb(42, 202, 250); color: white; font-size 1.5em; border: none;"><strong>ПОДРОБНЕЕ</strong></button></a>
            </div>
        </div>
</#list>
<button class="btn btn-outline-secondary" style="width: 15%; margin: 1%; min-width: 155px; height: var(--height); min-height: 320px; font-size: 4em;">+</button>
</div>
</@pages.page>