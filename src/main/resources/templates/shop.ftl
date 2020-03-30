<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/productCard.ftl" as productCard>

<@pages.page "Магазин">
    <@navbar.navbar is></@navbar.navbar>
    <form class="alert alert-success" style="position: fixed; left: 2%; width: 15%; min-width:160px" action="/shop" method="post">
        <h4 style="margin-bottom: 10px">Фильтр</h4>
        <label>Название</label>
        <br>
        <@pages.myTextInput 1 90 'name'></@pages.myTextInput>
        <br>
        <label style="margin-top: 10px">Стоимость</label>
        <br>
        <@pages.myTextInput 1 90 'cost'></@pages.myTextInput>
        <br>
        <button class="btn btn-outline-success" type="submit" style="margin-top: 20px">Выбрать</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>

    <div class="card-columns" style="position: relative; left: max(20%, 180px); width: 75%">
        <#list products as products>
            <@productCard.product "${products.imgSrc}" "${products.title}" "${products.text}" "${products.cost}" '${products.id}' >
            </@productCard.product>
        <#else>
            <div>
                Хм... Возможно Ваши фильтры слишком строги?
            </div>
        </#list>
    </div>
</@pages.page>