<#import "parts/common.ftl" as pages>
<@pages.page>
    <div class="navbar navbar-light bg-light">
        <div class="navbar-brand"><img
                    src="https://static.tildacdn.com/tild3865-3431-4934-a462-636139616135/noroot.png"></div>
        <div class="navbar-text">
            <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                <button type="submit" class="btn btn-outline-success">Выйти</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </form>
        </div>
        <div class="navbar-text">
            <a href="#">Профиль</a>
        </div>
    </div>
    <script>
        window.onload = function () {
            setTimeout(a, 1000);
        };
        var a = function () {
            var abc = document.getElementById('al');
            setTimeout(document.body.removeChild(abc), 1000);
        };
    </script>
    <div style="position: relative; width: 50%; left: 25%" id="al">
        <div class="alert alert-success" role="alert">
            <div style="display: block; text-align: center">
                Вы успешно вошли!
            </div>
        </div>
    </div>
    <img src="https://sun9-8.userapi.com/c851224/v851224158/194606/pW5Vv5hvKX4.jpg" height="25%" width="25%"
         style="display: block; margin-left: auto; margin-right: auto; position: relative;">
    <div style="text-align:center; position: relative; top: 10px; left: 1%;">
        <#list pupils as pupils>
            <span>${pupils.name+" "}</span>
            <span>${pupils.surname+" "}</span>
            <#if pupils.active == true>
                is active
            <#else>
                is not active
            </#if>
        <#else>
        </#list>
    </div>
    <br>



</@pages.page>