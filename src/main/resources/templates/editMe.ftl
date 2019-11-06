<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/alertTab.ftl" as al>
<@pages.page>
    <@navbar.navbar></@navbar.navbar>
    <#if was!=true>
        <@al.alert "alert alert-success alert-dismissible fade show" "Вы успешно вошли"></@al.alert>
    </#if>
    <#if warn != "">
        <@al.alert "alert alert-warning alert dismissible fade show" "${warn}" ></@al.alert>
    </#if>
    <div style="width: 70%; height: 70%; position: relative; margin-top: 1%; left: 10%; border-radius: 20px 20px 20px 20px; background-color: #fdfffd">
        <img style="position: relative; left: 3.5%; width: 16%; height: 23.8%; border-radius: 50px 50px 50px 50px;"
             src="https://sun9-16.userapi.com/c851224/v851224158/194606/pW5Vv5hvKX4.jpg" alt="">
        <div style="position: relative; font-family: sans-serif; left: 24%">s
            <form action="/profile" method="post">
                <#list pupils as pupils>
                    <label>Имя:</label>
                    <br>
                    <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%;"
                           type="text" value="${pupils.name}" name="nickname">
                    <br>
                    <label>Фамилия:</label>
                    <br>
                    <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 28%;"
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
                <button type="submit" class="btn btn-outline-success" style="position: relative; left: 64%">Сохранить
                </button>
                <button type="reset" class="btn btn-outline-warning" style="position: relative; left: 67%">Отменить
                </button>
            </form>
        </div>
    </div>
</@pages.page>