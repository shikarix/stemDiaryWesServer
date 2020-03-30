<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Редактирование урока">
<@navbar.navbar is></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <img src="${lesson.urlToLessonLogo}" style="width: 20vmin; height: 20vmin; width: 20vm; height: 20vm;"/>
        <form action="/editTimetable/${lesson.lessonId}" method="post">
            <input type="text" value="${lesson.lessonName}" name="name" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="date" value="${date}" name="date" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="text" value="${lesson.urlToLessonLogo}" name="url" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <strong style="margin: 1vh;"> Выберите учителя: </strong>
            <br/>
            <select name="teacher">
                <#list teachers as t>
                    <#if teacher??>
                        <#if t.id == teacher.id>
                            <option value="${t.id}" selected>${t.name} ${t.surname}</option>
                        <#else>
                            <option value="${t.id}">${t.name} ${t.surname}</option>
                        </#if>
                    <#else>
                        <option value="${t.id}">${t.name} ${t.surname}</option>
                    </#if>
                </#list>
            <select>
            <br/>
            <strong style="margin: 1vh;"> Отметьте учеников </strong>
            <div style="width: 50vw; min-width: 250px; overflow-y: scroll; height: 10vh; min-height: 250px;">
                <#list pupils as p>
                    <input type="checkbox" name="check" value="${p.id}"></input>
                    <label>${p.name} ${p.surname}</label>
                </#list>
            </div>
            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>
        <form action="/deleteLesson/${lesson.lessonId}" method="post">
            <button type="submit" class="btn btn-outline-danger" style="margin-left: auto; margin-right: auto; margin-top: 1%;">Удалить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
    </div>
</@pages.page>