<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Профиль">
<@navbar.navbar is></@navbar.navbar>
<div style="text-align: center;"><h4><strong>Добавить урок</strong><h4></div>
<form action="/addlesson" method="post" style="display:flex; justify-content: center; flex-wrap: wrap">

    <label>Название</label>
    <div style="width: 100%; height: 0;"></div>
    <input type="text" name="name" style="outline: none; resize: none; width: 50vw; min-width: 205px;"></input>
    <div style="width: 100%; height: 0;"></div>

    <label>Дата</label>
    <div style="width: 100%; height: 0;"></div>
    <input type="text" name="date" style="outline: none; resize: none; width: 50vw; min-width: 205px;" placeholder="дд мм гггг чч мм"></input>
    <div style="width: 100%; height: 0;"></div>

    <label>URL логотипа занятия</label>
    <div style="width: 100%; height: 0;"></div>
    <input type="text" name="url" style="outline: none; resize: none; width: 50vw; min-width: 205px;"></input>
    <div style="width: 100%; height: 0;"></div>

    <label> Учитель</label>
    <div style="width: 100%; height: 0;"></div>
    <select name="teacher">
        <#list teachers as t>
            <option>${t}</option>
        </#list>
    </select>
    <div style="width: 100%; height: 0;"></div>

    <div style="margin-top: 10px; min-width: 205px;">
        <button type="submit" class="btn btn-outline-success">Сохранить</button>
        <button type="reset" class="btn btn-outline-warning">Отменить</button>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@pages.page>