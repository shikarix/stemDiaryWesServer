<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Редактирование товара">
<@navbar.navbar is color></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <img src="${p.imgSrc}"/>
        <form action="/productEdit/${p.id}" method="post">
            <input type="text" value="${p.title}" name="title" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="text" value="${p.text}" name="text" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="text" value="${p.about}" name="about" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="number" value="${p.cost}" name="cost" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>
            <input type="text" value="${p.imgSrc}" name="imgSrc" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: 20vw; text-align: center; min-width: 100px;">
            <br/>

            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${p.id}" name="UserId">
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>

        <form action="/deleteProduct/${p.id}" method="post">
            <button type="submit" class="btn btn-outline-danger" style="margin-left: auto; margin-right: auto; margin-top: 1%;">Удалить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">
        </form>
    </div>
</@pages.page>