<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<@pages.page "Создание урока">
<@navbar.navbar is></@navbar.navbar>
    <div style="display: flex; flex-direction: column; align-items: center; justify-content: center; text-align: center;">
        <img src="https://psv4.userapi.com/c856216/u219919602/docs/d3/fde48fb977b2/stem_logo.png?extra=kaMMMcPbX3YsLJPE1AUD0JFPhyUis0bSpvfPVJLterY5qQdY4_qHnM3JxhvZAyRE44sqhEzqsKVwcwL2N_1_VByE8m56hie6Ksvpudl-_MDA_8JolsampplSaf3d5whjMiA9kvAdrAvx4fEfHm_LXIxqg7s" id="pic"/>
        <script>
          let a = function(){
              let main = document.getElementById("pic");
              main.setAttribute("width", (document.body.offsetWidth / 100 * 15));
          }
          window.onload = a;
          window.onresize = a;
        </script>
        <form action="/createTimetable" method="post">
            <label for="name">Название</label>
            <input type="text" value="" name="name" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 70px); text-align: center; min-width: 100px;">
            <br/>
            <label for="date">Дата первого урока</label>
            <input type="date" value="" name="date" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 146px); text-align: center; min-width: 100px;">
            <br/>
            <label for="time">Время первого урока</label>
            <input type="time" value="" name="time" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 146px); text-align: center; min-width: 100px;">
            <br/>
            <label for="url">Url логотипа</label>
            <input type="text" value="" name="url" style="border-width: 0px 0px 1px 0px; border-color: silver; outline:none; width: calc(30vw - 91px); text-align: center; min-width: 100px;">
            <br/>
            <strong style="margin: 1vh;"> Выберите учителя: </strong>
            <br/>
            <select name="teacher">
                <#list teachers as t>
                    <option value="${t.id}">${t.name} ${t.surname}</option>
                </#list>
            <select>
            <br/>
            <strong style="margin: 1vh;"> Отметьте учеников </strong>
            <div style="width: 50vw; min-width: 250px; overflow-y: scroll; height: 10vh; min-height: 250px;">
                <#list pupils as p>
                    <input type="checkbox" name="check" value="${p.id}"></input>
                    <label>${p.name} ${p.surname}</label>
                </#list>
            </div>
            <button type="submit" class="btn btn-outline-success" style="margin-left: auto; margin-right: auto;">Сохранить</button>
            <input type="hidden" value="${_csrf.token}" name="_csrf">

        </form>
    </div>
</@pages.page>