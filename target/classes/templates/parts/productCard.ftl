<#macro product imgSrc title text cost id>
    <div class="card border-dark" style="min-width: 180px;">
        <div class="row no-gutters" style="min-width: 180px;">
            <div style="display: block; margin-left: auto; margin-right: auto;">
                <img src="${imgSrc}" alt="" class="myimg" style="display: block; margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto;">
            </div>
            <div style="text-align: center; display: block; margin: 2% auto;">
                <div class="card-body text-dark" style="text-align: center; text-align: -moz-center; text-align: -webkit-center">
                    <div class="card-title">
                        <h4>${title}</h4>
                    </div>
                    <div class="card-text" style="margin-bottom: 10%">
                        ${text}
                    </div>
                    <div class="card-footer" style="border-color: var(--main); border-top: var(--main); background-color: var(--main)">
                        <button class="btn btn-outline-primary">${cost}$</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</#macro>