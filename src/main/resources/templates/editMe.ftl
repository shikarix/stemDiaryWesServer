<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/alertTab.ftl" as al>
<@pages.page "Профиль">
<@navbar.navbar is></@navbar.navbar>
<#if warn != "">
    <@al.alert "alert alert-warning alert dismissible fade show" "${warn}" ></@al.alert>
</#if>
<div style="border: 2px solid rgba(0, 0, 0, 0.125);">
<div style="display: flex; flex-direction: row; align-items: center; justify-content: center;">
        <img style="--width: width; height: calc(var(--width)); width: 30vw; " src="https://sun9-16.userapi.com/c851224/v851224158/194606/pW5Vv5hvKX4.jpg" alt="">
        <form action="/profile" method="post">
            <div>
                <#list pupils as pupils>
                    <label>Имя:</label>
                    <br>
                    <input disabled style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%; background-color: white"
                           type="text" value="${pupils.name}" name="nickname">
                    <br>
                    <label>Фамилия:</label>
                    <br>
                    <input disabled style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%; background-color: white"
                           type="text" value="${pupils.surname}" name="surname">
                    <br>
                    <label>Старый пароль:</label>
                    <br>
                    <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%;"
                           type="password" name="oldPassword">
                    <br>
                    <label>Новый пароль:</label>
                    <br>
                    <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%;"
                           type="password" name="newPassword">
                    <br>
                    <label>Повторите пароль:</label>
                    <br>
                    <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%;"
                           type="password" name="againPassword">
                    <br>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </#list>
            </div>
            <div style="margin-top: 10px">
                <button type="submit" class="btn btn-outline-success">Сохранить</button>
                <button type="reset" class="btn btn-outline-warning">Отменить</button>
            </div>
        </form>
</div>
</div>
</@pages.page>