<#macro navbar isAdmin>
    <style>
        .mynavbar-max{
            width: 60%;
            min-width: 750px;
            max-width: 850px;
            display: flex;
            display: -webkit-flex;
            justify-content: space-around;
            align-items: center;
            -webkit-justify-content: space-around;
            -webkit-align-items: center;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
    <script>
        let div = document.createElement("div");
        div.setAttribute("class", "mynavbar-max");

        let divImg = document.createElement("div");
        divImg.setAttribute("class", "navbar-brand");
        let aImg = document.createElement("a");
        aImg.setAttribute("href", "/profile");
        let img = document.createElement("img");
        img.setAttribute("src", "https://static.tildacdn.com/tild3865-3431-4934-a462-636139616135/noroot.png");
        divImg.appendChild(aImg);
        aImg.appendChild(img);

        let divNews = document.createElement("div");
        divNews.setAttribute("class", "navbar-text");
        let aNews = document.createElement("a");
        aNews.setAttribute("href", "/news");
        aNews.innerHTML = "Новости";
        divNews.appendChild(aNews);

        let divProfile = document.createElement("div");
        divProfile.setAttribute("class", "navbar-text");
        let aProfile = document.createElement("a");
        aProfile.setAttribute("href", "/profile");
        aProfile.innerHTML = "Профиль";
        divProfile.appendChild(aProfile);

        let divTimetable = document.createElement("div");
        divTimetable.setAttribute("class", "navbar-text");
        let aTimetable = document.createElement("a");
        aTimetable.setAttribute("href", "/timetable");
        aTimetable.innerHTML = "Расписание";
        divTimetable.appendChild(aTimetable);

        let divShop = document.createElement("div");
        divShop.setAttribute("class", "navbar-text");
        let aShop = document.createElement("a");
        aShop.setAttribute("href", "/shop");
        aShop.innerHTML = "Магазин";
        divShop.appendChild(aShop);

        <#if is = true>
            let divPanel = document.createElement("div");
            divPanel.setAttribute("class", "navbar-text");
            let aPanel = document.createElement("a");
            aPanel.setAttribute("href", "/pupils");
            aPanel.innerHTML = "Панель администратора";
            divPanel.appendChild(aPanel);
        </#if>

        let formButton = document.createElement("form");
        formButton.setAttribute("class", "form-inline my-2 my-lg-0");
        formButton.setAttribute("action", "/logout");
        formButton.setAttribute("method", "post");
        let button = document.createElement("button");
        button.setAttribute("type", "submit");
        button.setAttribute("class", "btn btn-outline-danger");
        button.innerHTML = "Выйти";
        let inputButton = document.createElement("input");
        inputButton.setAttribute("type", "hidden");
        inputButton.setAttribute("name", "_csrf");
        inputButton.setAttribute("value", "${_csrf.token}");
        formButton.appendChild(button);
        formButton.appendChild(inputButton);

        div.appendChild(divImg);
        div.appendChild(divNews);
        div.appendChild(divProfile);
        div.appendChild(divTimetable);
        div.appendChild(divShop);
        div.appendChild(divPanel);
        div.appendChild(formButton);

        document.body.appendChild(div);
    </script>
</#macro>