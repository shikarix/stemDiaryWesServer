<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/card.ftl" as card>
<@pages.page "Расписание">
<@navbar.navbar is></@navbar.navbar>
<h3 style="display: block; padding: 1%; text-align: center; margin-bottom: 0px;">Ближайшие занятия:</h3>
<div style=" display: flex; flex-flow: row wrap; -webkit-justify-content: center;">
    <#list dates as d>
        <div class="card" style="width: 15%; margin: 1%; min-width: 155px; background-color: white;">
            <div class="card-header" style="text-align: center; background-color: white;">
                ${d.name}
            </div>
            <div class="card-body" style="background-color: white;">
                <img src="${d.urlToLessonLogo}" style="display: block; margin-left: auto; margin-right: auto; min-width:100px; min-height: 100px; background-color: white;" class="myimg"/>
                <h4 style="text-align: center; margin-bottom: 10px; background-color: white;">
                    ${d.date1}
                </h4>
                <a href="/timetable/${d.id}/${d.date}"><button class="btn btn-outline-primary" style="font-size 1.5em; margin-left: auto; margin-right: auto; display: block;">ПОДРОБНЕЕ</button></a>
            </div>
        </div>
    </#list>
    <script>
        let a = function(){
            let imgs = document.getElementsByTagName("img");
            for(let i = 0; i < imgs.length; i++){
                if(imgs[i].getAttribute("class") === "myimg"){
                    imgs[i].setAttribute("width", (document.body.offsetWidth / 100 * 10));
                }
            }
        }
        window.onresize = a;
        window.onload = a;
    </script>
</div>
</@pages.page>