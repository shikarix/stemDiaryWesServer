<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Создание пользователя">
<@navbar.navbar is></@navbar.navbar>
<style>
    label{
        font-weight: bold;
    }
</style>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <form action="/create" method="post">
            <label for="name">Имя</label>
            <br/>
            <input type="text" value="" placeholder="" name="name" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="surname">Фамилия</label>
            <br/>
            <input type="text" value="" placeholder="" name="surname" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="login">Логин</label>
            <br/>
            <input type="text" value="" placeholder="" name="login" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="password">Пароль</label>
            <br/>
            <input type="text" value="" placeholder="" name="password" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="url">Url изображения</label>
            <br/>
            <input type="text" value="" placeholder="" name="url" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="checkbox" name="isAdmin" style="margin-left: auto; margin-right: auto;"/>
            <label for="isAdmin">Администратор</label>
            <br/>
            <input type="checkbox" name="isTeacher" style="margin-left: auto; margin-right:auto;"/>
            <label for="isTeacher">Учитель</label>
            <br/>
            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
    </div>
</@pages.page>