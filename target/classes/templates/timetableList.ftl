<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>

<@pages.page "Пользователи">
<@navbar.navbar is color> </@navbar.navbar>
    <#assign x = 0>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td>Название</td>
            <td>Дата первого занятия</td>
            <td>Url</td>
            <td style="width: 25%"></td>
        </tr>
        </thead>
        <tbody>
        <#list timetables as t>
            <tr>
                <td>${t.lessonName}</td>
                <td>${t.firstTimeString}</td>
                <td>${t.urlToLessonLogo}</td>
                <td>
                    <a href="/editTimetable/${t.lessonId}">
                        <button class="btn btn-outline-primary">Редактировать</button>
                    </a>
                </td>
                <#assign x++>
            </tr>
        </#list>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <a href="/createTimetable">
                    <button class="btn btn-outline-primary">+</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>

</@pages.page>