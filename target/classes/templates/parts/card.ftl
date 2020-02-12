<#macro card text imgSrc>
    <div class="" style="margin-bottom: 2rem; border-color: #${color}}">
        <img src="${imgSrc}" style="display: block; margin: 2% auto;">
        <div style="background-color: #${color}}">
        <label class="card-text">${text}</label>
        </div>
    </div>
</#macro>
<#macro course text>
    <div class="card border-dark" style="margin-bottom: 2rem">
        <div style="background-color: #fefefe"></div>
        <label class="card-text">${text}</label>
    </div>
</#macro>