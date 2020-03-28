<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Редактирование урока">
<@navbar.navbar is></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <img src="${lesson.urlToLessonLogo}"/>
        <form action="/editTimetable" method="post">
            <input type="text" value="${lesson.lessonName}" name="name" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="date" value="${lesson.firstTime}" name="date" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="text" value="${lesson.urlToLessonLogo}" name="url" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <select>
                <#list teachers as t>
                    <#if t.id == teacher.id>
                        <option selected value="${t.name} ${t.surname}">${t.name} ${t.surname}</option>
                    <#else>
                        <option value="${t.name} ${t.surname}">${t.name} ${t.surname}</option>
                    </#if>
                </#list>
            <select>
            <br/>
            <select>
                <#list pupils as p>
                    <select multiple name="pupils[]">
                        <option name="${p.name} ${p.surname}">${p.name} ${p.surname}</option>
                    </select>
                </#list>
            </select>
            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>
        <form action="/deleteLesson/${lesson.id}" method="post">
            <button type="submit" class="btn btn-outline-danger" style="margin-left: auto; margin-right: auto; margin-top: 1%;">Удалить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
    </div>
</@pages.page>