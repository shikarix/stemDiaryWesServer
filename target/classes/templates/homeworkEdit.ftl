<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Профиль">
<@navbar.navbar is color></@navbar.navbar>
<div style="text-align: center;"><h4><strong>${name}</strong><h4></div>
<form action="/homework/${date}/${lesson}" method="post" style="display:flex; justify-content: center; flex-wrap: wrap">
    <textarea name="homework" style="outline: none; resize: none; width: 50vw; height: 20vh; min-width: 205px; background-color: white;">
        ${homework}
    </textarea>
    <div style="width: 100%; height: 0;"></div>
    <div style="margin-top: 10px; min-width: 205px;">
        <button type="submit" class="btn btn-outline-success">Сохранить</button>
        <button type="reset" class="btn btn-outline-warning">Отменить</button>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@pages.page>