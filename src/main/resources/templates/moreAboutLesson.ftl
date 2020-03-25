<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "${name}">
<@navbar.navbar is></@navbar.navbar>
<div style="text-align: center;"><h4><strong>${name}</strong><h4></div>
<div style=" display: flex; flex-flow: row wrap; -webkit-justify-content: center; text-align: center;">

    <div class="card" style="width: 20%; margin: 1%; min-width: 155px; --height: height;">
         <div class="card-body">
             <strong> Занятие </strong> <br/>
             ${time} <br/>
             ${date} <br/>
             <strong> Домашняя работа </strong> <br/>
             ${hw}
             <#if isT = true>
                <a href="/homework/${now}/${id}"><button style="display: block; padding: 5px; margin-left: auto; margin-right: auto; margin-top: 2%; border-radius: 10px; background-color: rgb(42, 202, 250); color: white; font-size 1.5em; border: none;"><strong>РЕДАКТИРОВАТЬ</strong></button></a>
             </#if>
         </div>
    </div>
    <div class="card" style="width: 20%; margin: 1%; min-width: 155px; --height: height;">
         <div class="card-body">
             <strong> Учитель </strong> <br/>
             <img src="${teacher.avatarUrl}" style="margin-left: auto; margin-right: auto;"/>
             ${teacher.name} ${teacher.surname}<br/>
         </div>
    </div>
    <#if isT = true>
    <div class="card" style="width: 20%; margin: 1%; min-width: 155px; --height: height;">
        <div class="card-body">
            <strong> Ученики </strong> <br/>
            <#list pupils as p>
                ${p.name} ${p.surname}
                    <#if isT = true>
                        <div>Оценка <#if p.currentMark == 0>ещё не выставлена<#else>${p.currentMark}</#if></div>
                        <a href="/pupil/${now}/${id}/${p.id}"><button style="display: block; padding: 5px; margin-left: auto; margin-right: auto; border-radius: 10px; background-color: rgb(42, 202, 250); color: white; font-size 1.5em; border: none; margin-top: 2%"><strong>ОЦЕНКИ</strong></button></a>
                    </#if>
            </#list>
        </div>
    </div>
    </#if>
</div>
</@pages.page>