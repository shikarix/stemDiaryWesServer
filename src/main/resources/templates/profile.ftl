<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page>
    <@navbar.navbar></@navbar.navbar>
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
    <div style="text-align:center; position: relative; top: 10px; left: 1%;">
        <#list pupils as pupils>
            <span>${pupils.name+" "}</span>
            <span>${pupils.surname+" "}</span>
            <#if pupils.active == true>
                is active
            <#else>
                is not active
            </#if>
            <span>
                <#list pupils.roles as roles>
                    <span>${roles}<#sep>,</span>
                </#list>
            </span>
        <#else>
        </#list>
    </div>
    <br>



</@pages.page>