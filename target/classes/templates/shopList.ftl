<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>

<@pages.page "Товары">
<@navbar.navbar is> </@navbar.navbar>
    <#assign x = 0>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td>Название</td>
            <td>Стоимость</td>
            <td>Краткое описание</td>
            <td>Описание</td>
            <td style="width: 25%"></td>
        </tr>
        </thead>
        <tbody>
        <#list products as p>
            <tr>
                <td>${p.title}</td>
                <td>${p.cost}</td>
                <td>${p.text}</td>
                <td>${p.about}</td>
                <td>
                    <a href="/productEdit/${p.id}">
                        <button class="btn btn-outline-primary">Редактировать</button>
                    </a>
                </td>
                <#assign x++>
            </tr>
        </#list>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                <a href="/productEdit/${x}">
                    <button class="btn btn-outline-primary">+</button>
                </a>
            </td>
        </tr>
        </tbody>
    </table>

</@pages.page>