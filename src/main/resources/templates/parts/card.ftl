<#macro card text imgSrc date>
    <div style="margin: 10px; border: 1px solid rgba(0,0,0,0.125)">
        <img src="${imgSrc}" style="display: block; margin: 2% auto; width: 50%; height: 50%">
        <div>
        <label class="card-text">${text}</label>
        </div>

        <div>
        <p class="text-muted">${date}</p>
        </div>
    </div>
</#macro>
<#macro course text>
    <div class="card border-dark" style="margin-bottom: 2rem">
        <div style="background-color: #fffffe"></div>
        <label class="card-text">${text}</label>
    </div>
</#macro>