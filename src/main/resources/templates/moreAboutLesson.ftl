<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "${name}">
<@navbar.navbar is color></@navbar.navbar>
<div style="text-align: center;"><h4><strong>${name}</strong><h4></div>
<div style=" display: flex; flex-flow: row wrap; -webkit-justify-content: center; text-align: center;">

    <div class="card" style="width: 20%; margin: 1%; min-width: 155px; background-color: white;">
         <div class="card-body" style="background-color: white;">
             <strong style="background-color: white;"> Занятие </strong> <br/>
             ${time} <br/>
             ${date} <br/>
             <strong style="background-color: white;"> Домашняя работа </strong> <br/>
             ${hw}
             <#if isT = true>
                <a href="/homework/${now}/${id}"><button class="btn btn-outline-primary" style="display: block; margin-left: auto; margin-right: auto; margin-top: 2%; font-size 1.5em;">РЕДАКТИРОВАТЬ</button></a>
             </#if>
         </div>
    </div>
    <div class="card" style="width: 20%; margin: 1%; min-width: 155px; background-color: white;">
         <div class="card-body" style="background-color: white;">
             <strong style="background-color: white;"> Учитель </strong> <br/>
             <#if teacher??>
                <img src="${teacher.avatarUrl}" style="margin-left: auto; margin-right: auto; background-color: white;" id="teacherImg"/>
                <script>
                    let a = function(){
                        let imgT = document.getElementById('teacherImg');
                        imgT.setAttribute('width', (document.body.clientWidth / 100 * 15) + "px");
                        imgT.style.minWidth = "82px";
                        imgT.style.maxWidth = "250px";
                    }
                    window.onresize = a;
                    window.onload = a;
                </script>
                ${teacher.name} ${teacher.surname}<br/>
             <#else>
                Пока не назначен
             </#if>

         </div>
    </div>
    <#if (isT = true) || (is = true)>
    <div class="card" style="width: 20%; margin: 1%; min-width: 155px; background-color: white;">
        <div class="card-body" style="background-color: white;">
            <strong style="background-color: white;"> Ученики </strong> <br/>
            <#list pupils as p>
                ${p.name} ${p.surname}
                    <#if isT = true>
                        <div style="background-color: white;">Оценка <#if p.currentMark == 0>ещё не выставлена<#else>${p.currentMark}</#if></div>
                        <a href="/pupil/${now}/${id}/${p.id}"><button class="btn btn-outline-primary" style="display: block; padding: 5px; margin-left: auto; margin-right: auto; font-size 1.5em; margin-top: 2%">ОЦЕНКИ</button></a>
                    </#if>
                    <br/>
            </#list>
        </div>
    </div>
    </#if>
</div>
</@pages.page>