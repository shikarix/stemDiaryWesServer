<#macro card text smallText imgSrc>
    <div class="card">
        <img src="${imgSrc}" style="width: 30rem; height: 30rem">
        <label class="card-text">${text}</label>
        <label class="card-text"><small class="text-muted">${smallText}</small></label>
    </div>
</#macro>