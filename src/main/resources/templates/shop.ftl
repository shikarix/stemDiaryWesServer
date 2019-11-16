<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/productCard.ftl" as productCard>

<@pages.page "Магазин">
    <@navbar.navbar></@navbar.navbar>
    <form style="position: fixed; left: 2%;" action="/shop" method="post">
        <h4>Фильтр</h4>
        <label>Название</label>
        <br>
        <@pages.myTextInput 1 90 'name'></@pages.myTextInput>
        <br>
        <label>Стоимость</label>
        <br>
        <@pages.myTextInput 1 90 'cost'></@pages.myTextInput>
        <br>
        <button class="btn btn-outline-success" type="submit">Выбрать</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>

    <div class="card-columns" style="position: relative; left: 20%; width: 75%">
        <#list products as products>
            <@productCard.product "${products.imgSrc}" "${products.title}" "${products.text}" "${products.cost}">
            </@productCard.product>
        <#else>
            <div style="position: relative; display: block; text-align: center; margin: auto;">
                Хм... Возможно Ваши фильтры слишком строги?
            </div>

        </#list>

    </div>
</@pages.page>