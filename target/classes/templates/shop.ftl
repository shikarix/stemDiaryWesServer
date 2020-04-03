<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/productCard.ftl" as productCard>

<@pages.page "Магазин">
    <@navbar.navbar is></@navbar.navbar>
    <form class="alert alert-success" style="position: fixed; left: 2%; width: 15%; min-width:160px" action="/shop" method="post">
        <h4 style="margin-bottom: 10px" class="form-success-text">Фильтр</h4>
        <label class="form-success-text">Название</label>
        <br>
        <@pages.myTextInput 1 90 'name'></@pages.myTextInput>
        <br>
        <label style="margin-top: 10px" class="form-success-text">Стоимость</label>
        <br>
        <@pages.myTextInput 1 90 'cost'></@pages.myTextInput>
        <br>
        <button class="btn btn-outline-success" type="submit" style="margin-top: 20px">Выбрать</button>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </form>

    <script>
         let a = function(){
             let imgs = document.getElementsByTagName('img');
             let maxHeight = 0;
             for(let i = 0; i < imgs.length; i++){
                 if(imgs[i].getAttribute('class') === 'myimg'){
                     imgs[i].setAttribute('width', (document.body.clientWidth / 100 * 10.5) + "px");
                     imgs[i].style.minWidth = "82px";
                     imgs[i].style.maxWidth = "150px";
                     imgs[i].style.paddingTop = "0px";
                     imgs[i].style.paddingBottom = "0px";
                     if(Number(imgs[i].parentElement.parentElement.getAttribute("startHeight")) > maxHeight){
                        maxHeight = imgs[i].parentElement.parentElement.scrollHeight;
                     }
                 }
             }
             for(let i = 0; i < imgs.length; i++){
                if(imgs[i].getAttribute('class') === 'myimg'){
                    imgs[i].parentElement.parentElement.style.height = maxHeight + "px";
                }
             }
         };
         let b = function(){
            let imgs = document.getElementsByTagName('img');
            for(let i = 0; i < imgs.length; i++){
                if(imgs[i].getAttribute('class') === 'myimg'){
                    imgs[i].parentElement.parentElement.setAttribute("startHeight", imgs[i].parentElement.parentElement.scrollHeight);
                }
                a();
            }
         }
         window.onresize = a;
         window.onload = b;
     </script>

    <div class="card-columns" style="padding-left: max(20%, 180px); margin: 0;">
        <#list products as products>
            <@productCard.product "${products.imgSrc}" "${products.title}" "${products.text}" "${products.cost}" '${products.id}' >
            </@productCard.product>
        <#else>
            Хм... Возможно Ваши фильтры слишком строги?
        </#list>
    </div>
</@pages.page>