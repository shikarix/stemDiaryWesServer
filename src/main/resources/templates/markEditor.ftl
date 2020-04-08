<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>

<@pages.page "Изменение оценки">
    <@navbar.navbar is color></@navbar.navbar>
    <div style="text-align: center;"><h4><strong>Изменение оценки</strong><h4></div>
    <form action="/pupil/${now}/${lessonId}/${pupil.id}" method="post" style="display:flex; justify-content: center; flex-wrap: wrap">
        <label>Имя ученика</label>
        <div style="width: 100%; height: 0;"></div>
        <label>${pupil.name}</label>
        <div style="width: 100%; height: 0;"></div>
        <label>Фамилия ученика</label>
        <div style="width: 100%; height: 0;"></div>
        <label>${pupil.surname}</label>
        <div style="width: 100%; height: 0;"></div>
        <label>Оценка выполнения домашнего задания</label>
        <div style="width: 100%; height: 0;"></div>
        <input type="range" min="1" max="5" value="1" step="1" name="homework"></input>
        <div style="width: 100%; height: 0;"></div>
        <label>Оценка поведения на уроке</label>
        <div style="width: 100%; height: 0;"></div>
        <input type="range" min="1" max="5" value="1" step="1" name="behaviour"></input>
        <div style="width: 100%; height: 0;"></div>
        <label>Оценка выполнения заданий на уроке</label>
        <div style="width: 100%; height: 0;"></div>
        <input type="range" min="1" max="5" value="1" step="1" name="classwork"></input>
        <div style="width: 100%; height: 0;"></div>
        <div style="margin-top: 10px; min-width: 205px;">
            <button type="submit" class="btn btn-outline-success">Сохранить</button>
            <button type="reset" class="btn btn-outline-warning">Отменить</button>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>

</@pages.page>