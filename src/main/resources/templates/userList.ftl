<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>

<@pages.page "Пользователи">
<@navbar.navbar is color> </@navbar.navbar>
    <#assign x = 0>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td>Имя</td>
            <td>Фамилия</td>
            <td>Админ</td>
            <td>Учитель</td>
            <td style="width: 25%"></td>
        </tr>
        </thead>
        <tbody>
        <#list pupils as pupil>
            <tr>
                <td>${pupil.name}</td>
                <td>${pupil.surname}</td>
                <td>
                    <#if pupil.admin = true>
                        true
                    <#else>
                        false
                    </#if>
                </td>
                <td>
                    <#if pupil.teacher = true>
                        true
                    <#else>
                        false
                    </#if>
                </td>
                <td>
                    <a href="/pupils/${pupil.id}">
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
            <td></td>
            <td>
                <a href="/pupils/${x}">
                    <button class="btn btn-outline-primary">+</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>

</@pages.page>