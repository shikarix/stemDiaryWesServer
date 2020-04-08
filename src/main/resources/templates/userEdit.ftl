<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Редактирование">
<@navbar.navbar is color></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <img src="${p.avatarUrl}"/>
        <form action="/pupils" method="post">
            <input type="text" value="${p.name}" name="name" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="text" value="${p.surname}" name="surname" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <#if p.admin == true>
                <input type="checkbox" name="isAdmin" style="margin-left: auto; margin-right: auto;" checked/>
                <label for="isAdmin">Администратор</label>
            <#else>
                <input type="checkbox" name="isAdmin" style="margin-left: auto; margin-right: auto;"/>
                <label for="isAdmin">Администратор</label>
            </#if>
            <br/>
            <#if p.teacher == true>
                <input type="checkbox" name="isTeacher" style="margin-left: auto; margin-right:auto;" checked/>
                <label for="isTeacher">Учитель</label>
            <#else>
                <input type="checkbox" name="isTeacher" style="margin-left: auto; margin-right:auto;"/>
                <label for="isTeacher">Учитель</label>
            </#if>
            <br/>
            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${p.id}" name="UserId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>
        <form action="/deleteUser/${p.id}" method="post">
            <button type="submit" class="btn btn-outline-danger" style="margin-left: auto; margin-right: auto; margin-top: 1%;">Удалить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
    </div>
</@pages.page>