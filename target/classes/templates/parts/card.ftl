<#macro card text imgSrc>
    <div class="card border-dark" style="margin-bottom: 2rem">
        <img src="${imgSrc}" style="display: block; margin: 2% auto;">
        <div style="background-color: #e2e3e5"></div>
        <label class="card-text">${text}</label>
    </div>
</#macro>
<#macro course text>
    <div class="card border-dark" style="margin-bottom: 2rem">
        <div style="background-color: #e2e3e5"></div>
        <label class="card-text">${text}</label>
    </div>
</#macro>