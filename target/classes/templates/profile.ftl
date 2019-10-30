<#import "parts/common.ftl" as pages>
<@pages.page>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign Out"/>
    </form>
</div>
<div style="position: relative; width: 50%; left: 25%" id="al" onload="function a(){setTimeout(document.getElementById('al').remove(), 1000)} a();">
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