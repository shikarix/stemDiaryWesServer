<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Редактирование товара">
<@navbar.navbar is></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <img src="${p.imgSrc}"/>
        <form action="/productEdit" method="post">
            <label for="title">Название</label>
            <input type="text" value="${p.title}" name="title" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="text">Краткое описание</label>
            <input type="text" value="${p.text}" name="text" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="about">Описание</label>
            <input type="text" value="${p.about}" name="about" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="cost">Стоимость</label>
            <input type="number" value="${p.cost}" name="cost" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <label for="imgSrc">Url изоражения</label>
            <input type="text" value="${p.imgSrc}" name="imgSrc" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>

            <button type="submit" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${p.id}" name="UserId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>
    </div>
</@pages.page>