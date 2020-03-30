<#macro product imgSrc title text cost id>
    <div class="card border-dark" style="min-width: 180px;">
        <div class="row no-gutters" style="min-width: 180px;">
            <div style="display: block; margin-left: auto; margin-right: auto;">
                <img src="${imgSrc}" alt="" class="myimg" style="display: block; margin-left: auto; margin-right: auto; margin-top: auto; margin-bottom: auto;">
                <script>
                    let a = function(){
                        let imgs = document.getElementsByTagName('img');
                        for(let i = 0; i < imgs.length; i++){
                            if(imgs[i].getAttribute('class') === 'myimg'){
                                imgs[i].setAttribute('width', (document.body.clientWidth / 100 * 10.5) + "px");
                                imgs[i].style.minWidth = "82px";
                                imgs[i].style.maxWidth = "150px";
                            }
                        }
                    };
                    window.onresize = a;
                    window.onload = a;
                </script>
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