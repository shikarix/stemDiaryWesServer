<#import "parts/common.ftl" as pages>
<@pages.page "Логин">
<div style="display: flex; flex-direction: row; align-items: center; justify-content: center;" id="loginForm">
    <img style="margin: 20px;" src="https://psv4.userapi.com/c856216/u219919602/docs/d3/fde48fb977b2/stem_logo.png?extra=kaMMMcPbX3YsLJPE1AUD0JFPhyUis0bSpvfPVJLterY5qQdY4_qHnM3JxhvZAyRE44sqhEzqsKVwcwL2N_1_VByE8m56hie6Ksvpudl-_MDA_8JolsampplSaf3d5whjMiA9kvAdrAvx4fEfHm_LXIxqg7s" id="pic">
    <form action="/login" method="post">
        <div style="display: flex; justify-content: center; align-items: center; flex-flow: column wrap;">
            <label> Логин: </label>
            <input type="text" name="username" id="usrn" class="login-input"/>
            <br/>
            <label> Пароль: </label>
            <input type="password" name="password" id="ps" class="login-input"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="Войти" style="margin-top: 20px;" class="btn btn-outline-success"/>
        </div>
    </form>
</div>
     <script>
        let a = function(){
            let main = document.getElementById("pic");
            main.setAttribute("width", (document.body.offsetWidth / 100 * 15));

            let div = document.getElementById("loginForm");
            let height = div.scrollHeight;
            let windowHeight = document.documentElement.clientHeight;
            div.style.marginTop = (windowHeight - 1.5 * height) / 2 + "px";
            div.style.marginBottom = (windowHeight - 1.5 * height) / 2 + "px";
        }
        window.onload = a;
        window.onresize = a;
     </script>

</@pages.page>