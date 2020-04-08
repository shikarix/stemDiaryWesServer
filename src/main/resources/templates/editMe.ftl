<#import "parts/common.ftl" as pages>
<#import "parts/navbar.ftl" as navbar>
<#import "parts/alertTab.ftl" as al>
<@pages.page "Профиль">
<@navbar.navbar is color></@navbar.navbar>
<#if warn != "">
    <@al.alert "alert alert-warning alert dismissible fade show" "${warn}" ></@al.alert>
</#if>
<div>
<div style="border: 2px solid rgba(0, 0, 0, 0.125); width: 75%; margin-left: auto; margin-right: auto;">
<div style="display: flex; flex-direction: row; align-items: center; justify-content: center; background-color: white;">
        <img id="myimg" style="padding-right: max(5%, 20px); background-color: white;" src="https://psv4.userapi.com/c856216/u219919602/docs/d3/fde48fb977b2/stem_logo.png?extra=kaMMMcPbX3YsLJPE1AUD0JFPhyUis0bSpvfPVJLterY5qQdY4_qHnM3JxhvZAyRE44sqhEzqsKVwcwL2N_1_VByE8m56hie6Ksvpudl-_MDA_8JolsampplSaf3d5whjMiA9kvAdrAvx4fEfHm_LXIxqg7s" alt="">
        <script>
            let abc = function(){
                let imgT = document.getElementById('myimg');
                imgT.setAttribute('width', (document.body.clientWidth / 100 * 30) + "px");
                imgT.style.minWidth = "250px";
                imgT.style.maxWidth = "380px";
            }
            window.onresize = abc;
            window.onload = abc;
        </script>
        <form action="/profile" method="post" style="margin-top: 30px; background-color: white;">
            <div style="background-color: white;">
                <#list pupils as pupils>
                    <label class="profile-label">Имя:</label>
                    <br>
                    <input disabled class="profile-input"
                           type="text" value="${pupils.name}" name="nickname">
                    <br>
                    <label class="profile-label">Фамилия:</label>
                    <br>
                    <input disabled class="profile-input"
                           type="text" value="${pupils.surname}" name="surname">
                    <br>
                    <label class="profile-label">Старый пароль:</label>
                    <br>
                    <input class="profile-input"
                           type="password" name="oldPassword">
                    <br>
                    <label class="profile-label">Новый пароль:</label>
                    <br>
                    <input class="profile-input"
                           type="password" name="newPassword">
                    <br>
                    <label class="profile-label">Повторите пароль:</label>
                    <br>
                    <input class="profile-input"
                           type="password" name="againPassword">
                    <br>
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                </#list>
            </div>
            <div style="margin-top: 10px; margin-bottom: 30px; background-color: white;">
                <button type="submit" class="btn btn-outline-success">Сохранить</button>
                <button type="reset" class="btn btn-outline-warning">Отменить</button>
            </div>
        </form>
</div>
</div>
</div>
<div>
<div style="border: 2px solid rgba(0, 0, 0, 0.125); width: 75%; margin-left: auto; margin-right: auto;">
<div style="display: flex; flex-direction: row; align-items: center; justify-content: center; background-color: white;">
        <form action="/profile" method="post" style="margin-top: 30px; background-color: white;">
            <p style="text-align: center; background-color: white; font-weight: bold">Выбор цветовой темы навигационной панели</p>
            <div style="background-color: white; display: flex; flex-direction: row; align-items: space-around; justify-content: space-around;">
                <a href="/changeTheme/1" class="btn" style="background-color: #ffbc8a; width: 5vw; height: 5vw; margin: 2vw"></a>
                <a href="/changeTheme/2" class="btn" style="margin: 2vw; background-color: #82deff; width: 5vw; height: 5vw"></a>
                <a href="/changeTheme/3" class="btn" style="margin: 2vw; background-color: #ff99b1; width: 5vw; height: 5vw"></a>
                <a href="/changeTheme/4" class="btn" style="margin: 2vw; background-color: #96ffb2; width: 5vw; height: 5vw"></a>
                <a href="/changeTheme/5" class="btn" style="margin: 2vw; background-color: #e68cff; width: 5vw; height: 5vw"></a>
                <a href="/changeTheme/6" class="btn" style="margin: 2vw; background-color: #ffe278; width: 5vw; height: 5vw"></a>
                <a href="/changeTheme/0" class="btn" style="margin: 2vw; background-color: #eeeeee; width: 5vw; height: 5vw"></a>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
            </div>
        </form>
</div>
</div>
</div>
</@pages.page>