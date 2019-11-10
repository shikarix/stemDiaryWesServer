<#import "parts/common.ftl" as pages>
<@pages.page "Редактирование">
    <img src="https://sun9-8.userapi.com/c851224/v851224158/194606/pW5Vv5hvKX4.jpg" height="25%" width="25%" id="pic"
         style="display: block; margin-left: auto; margin-right: auto; position: relative;">
    <form action="/pupils" method="post">
        <input type="text" value="${pupil.name}" name="name" style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; left: 44%; width: 14%">
        <#list roles as role>
            <div style="position: relative; outline:none; left: 44%;"><input type="checkbox" name="${role}" value="${role}" ${pupil.roles?seq_contains(role)?string("checked", "")}>${role}</div>
        </#list>
        <button type="submit" style="left: 49%;">Сохранить</button>
        <input type="hidden" value="${pupil.id}" name="UserId">
        <input type="hidden" value="${_csrf.token}" name="_csrf">

    </form>
</@pages.page>