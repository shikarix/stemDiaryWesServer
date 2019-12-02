<#macro navbar>
    <div class="navbar navbar-light bg-light">
        <div class="navbar-brand">
            <a href="/profile">
                <img src="https://static.tildacdn.com/tild3865-3431-4934-a462-636139616135/noroot.png" alt="Стем">
            </a>
        </div>
        <div class="navbar-text">
            <a href="/news">
                Новости
            </a>
        </div>
        <div class="navbar-text">
            <a href="/profile">
                Профиль
            </a>
        </div>
        <div class="navbar-text">
            <a href="/timetable">
                Расписание
            </a>
        </div>
        <div class="navbar-text">
            <a href="/shop">
                Магазин
            </a>
        </div>
        <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
            <button type="submit" class="btn btn-outline-success">Выйти</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </form>
    </div>
</#macro>