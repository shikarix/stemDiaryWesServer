<#macro product imgSrc title text cost>
    <div class="card border-dark">
        <div class="row no-gutters">
            <div style="display: block; margin-left: auto; margin-right: auto;">
                <img src="${imgSrc}" alt="" class="card-img" style="display: block; margin-left: auto; margin-right: auto;">
            </div>
            <div style="text-align: center; display: block; margin: 2% auto;">
                <div class="card-body text-dark" style="text-align: center; text-align: -moz-center; text-align: -webkit-center">
                    <div class="card-title">
                        <h4>${title}</h4>
                    </div>
                    <div class="card-text" style="margin-bottom: 10%">
                        ${text}
                    </div>
                    <button class="btn btn-outline-primary" style="position: relative; left: 80%">
                        ${cost}$
                    </button>
                </div>
            </div>
        </div>
    </div>
</#macro>