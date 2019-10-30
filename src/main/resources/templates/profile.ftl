<#import "parts/common.ftl" as pages>
<@pages.page>
    <div>
        <form action="/logout" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Sign Out" style="display: block; position: relative; left: 94%"/>
        </form>
    </div>
    <script>
        window.onload = function () {
            setTimeout(a, 1000);
        };
        var a = function () {
            var abc = document.getElementById('al');
            for (var i = 0; i < 100; i++) {
                setTimeout(abc.style.opacity = 100-i+'%',100);
            }
            document.body.removeChild(abc);
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
            ${pupils.name}
        <#else>
        </#list>
    </div>
</@pages.page>