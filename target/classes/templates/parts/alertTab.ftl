<#macro alert type title>
    <div style="position: relative; width: 50%; left: 25%">
        <div class="${type}" role="alert">
            <div style="display: block; text-align: center">
                ${title}
                <button type="button" class="close" data-dismiss="alert">
                    <span aria-hidden="true">
                        &times;
                    </span>
                </button>
            </div>
        </div>
    </div>
</#macro>