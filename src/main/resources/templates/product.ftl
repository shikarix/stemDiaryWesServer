<#import "parts/common.ftl" as page>
<#import "parts/navbar.ftl" as navbar>
<@page.page "${product.title}">
    <@navbar.navbar></@navbar.navbar>
    <div style="width: 80%; position: relative; left: 10%; height: 80%; background-color: #fffafa; border-color: #fffafa;">
        <div class="col-md-10">
            <img src="${product.imgSrc}" alt="" style="width: 30rem; height: 30rem">
        </div>
        <div class="col-md-10" style="text-align: center">
            <h4>${product.title}</h4>
            <br>
            ${product.text}
        </div>
    </div>
</@page.page>