<#macro product imgSrc title text cost id>
    <div class="card border-dark">
        <div class="row no-gutters">
            <div style="display: block; margin-left: auto; margin-right: auto;">
                <img src="${imgSrc}" alt="" class="card-img" style="display: block; margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto;">
            </div>
            <div style="text-align: center; display: block; margin: 2% auto;">
                <div class="card-body text-dark" style="text-align: center; text-align: -moz-center; text-align: -webkit-center">
                    <div class="card-title">
                        <h4>${title}</h4>
                    </div>
                    <div class="card-text" style="margin-bottom: 10%">
                        ${text}
                    </div>
                    <div class="card-footer" style="border-color: white; border-top: white; background-color: white">
                        <a class="btn btn-outline-primary" href="/shop/${id}">${cost}$</a>
                    </div>

                </div>
            </div>
        </div>
    </div>
</#macro>