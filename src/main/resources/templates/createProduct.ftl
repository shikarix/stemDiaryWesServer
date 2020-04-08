<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Создание товара">
<@navbar.navbar is color></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <form action="/createProduct" method="post">
            <label for="title">Название</label>
            <input type="text" value="" name="title" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 70px); text-align: center; min-width: 164px;">
            <br/>
            <label for="text">Краткое описание</label>
            <input type="text" value="" name="text" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 133px); text-align: center; min-width: 101px;">
            <br/>
            <label for="about">Описание</label>
            <input type="text" value="" name="about" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 73px); text-align: center; min-width: 161px;">
            <br/>
            <label for="cost">Стоимость</label>
            <input type="number" value="" name="cost" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 77px); text-align: center; min-width: 158px;">
            <br/>
            <label for="imgSrc">Url изображения</label>
            <input type="text" value="" name="imgSrc" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 124px); text-align: center; min-width: 110px;">
            <br/>

            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>
    </div>
</@pages.page>