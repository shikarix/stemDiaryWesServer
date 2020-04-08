<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>

<@pages.page "Покупки">
<@navbar.navbar is> </@navbar.navbar>
    <#assign x = 0>
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <td>Товар</td>
            <td>Покупатель</td>
            <td style="width: 25%"></td>
            <td style="width: 25%"></td>
        </tr>
        </thead>
        <tbody>
        <#list purs as p>
            <tr>
                <td>${p.productId}</td>
                <td>${p.login}</td>
                <td>
                    <a href="/closePurchase/${p.id}">
                        <button class="btn btn-outline-primary">Выполнить заказ</button>
                    </a>
                    <a href="/cancelPurchase/${p.id}">
                        <button class="btn btn-outline-primary">Отказаться от заказа</button>
                    </a>
                </td>
            </tr>
            <#else>
            <tr><td>Ничего нет!</td></tr>
        </#list>
        </tbody>
    </table>

</@pages.page>