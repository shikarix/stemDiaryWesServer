<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Панель Администратора">
<@navbar.navbar is></@navbar.navbar>
    <div style="display: flex; flex-flow: column wrap; align-items: center;">
        <a href="/pupils">
            <button class="btn btn-outline-primary" style="font-size: 2em; width: 50vw; min-width: 280px; height: 20vh; min-height: 30px; max-height: 200px; margin: 2vw;">
                Ученики и Учителя
            </button>
        </a>
        <a href="">
            <button class="btn btn-outline-primary" style="font-size: 2em; width: 50vw; min-width: 280px; height: 20vh; min-height: 30px; max-height: 200px; margin: 2vw;">
                Изменение магазина
            </button>
        </a>
        <a href="">
            <button class="btn btn-outline-primary" style="font-size: 2em; width: 50vw; min-width: 280px; height: 20vh; min-height: 30px; max-height: 200px; margin: 2vw;">
                Редактирование уроков
            </button>
        </a>
    </div>
</@pages.page>