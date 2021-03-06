<#macro navbar isAdmin color>
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
            <#if color == 0>
                background-color: #eeeeee;
            </#if>
            <#if color == 1>
                background-color: #ffbc8a;
            </#if>
            <#if color == 2>
                background-color: #82deff;
            </#if>
            <#if color == 3>
                background-color: #ff99b1;
            </#if>
            <#if color == 4>
                background-color: #96ffb2;
            </#if>
            <#if color == 5>
                background-color: #e68cff;
            </#if>
            <#if color == 6>
                background-color: #ffe278;
            </#if>
        }
        mybtn:hover{
            background-color: #dc3545;
        }
    </style>
    <script>
    let ab;
        <#if color == 0>
            ab = "#eeeeee";
        </#if>
        <#if color == 1>
            ab = "#ffbc8a";
        </#if>
        <#if color == 2>
            ab = "#82deff";
        </#if>
        <#if color == 3>
            ab = "#ff99b1";
        </#if>
        <#if color == 4>
            ab = "#96ffb2";
        </#if>
        <#if color == 5>
            ab = "#e68cff";
        </#if>
        <#if color == 6>
            ab = "#ffe278";
        </#if>
        let allDiv = document.createElement('div');

        let div = document.createElement("div");
        div.setAttribute("class", "mynavbar-max");

        let divImg = document.createElement("div");
        divImg.setAttribute("class", "navbar-brand");
        divImg.setAttribute("style", "background-color:" + ab);
        let aImg = document.createElement("a");
        aImg.setAttribute("href", "/profile");
        let img = document.createElement("img");
        img.setAttribute("style", "background-color:" + ab);
        img.setAttribute("src", "https://static.tildacdn.com/tild3865-3431-4934-a462-636139616135/noroot.png");
        divImg.appendChild(aImg);
        aImg.appendChild(img);

        let divNews = document.createElement("div");
        divNews.setAttribute("style", "background-color:" + ab);
        divNews.setAttribute("class", "navbar-text");
        let aNews = document.createElement("a");
        aNews.setAttribute("style", "background-color:" + ab);
        aNews.setAttribute("href", "/news");
        aNews.innerHTML = "Новости";
        divNews.appendChild(aNews);

        let divProfile = document.createElement("div");
        divProfile.setAttribute("style", "background-color:" + ab);
        divProfile.setAttribute("class", "navbar-text");
        let aProfile = document.createElement("a");
        aProfile.setAttribute("href", "/profile");
        aProfile.setAttribute("style", "background-color:" + ab);
        aProfile.innerHTML = "Профиль";
        divProfile.appendChild(aProfile);

        let divTimetable = document.createElement("div");
        divTimetable.setAttribute("class", "navbar-text");
        divTimetable.setAttribute("style", "background-color:" + ab);
        let aTimetable = document.createElement("a");
        aTimetable.setAttribute("style", "background-color:" + ab);
        aTimetable.setAttribute("href", "/timetable");
        aTimetable.innerHTML = "Расписание";
        divTimetable.appendChild(aTimetable);

        let divShop = document.createElement("div");
        divShop.setAttribute("class", "navbar-text");
        divShop.setAttribute("style", "background-color:" + ab);
        let aShop = document.createElement("a");
        aShop.setAttribute("style", "background-color:" + ab);
        aShop.setAttribute("href", "/shop");
        aShop.innerHTML = "Магазин";
        divShop.appendChild(aShop);

        <#if is = true>
            let divPanel = document.createElement("div");
            divPanel.setAttribute("style", "background-color:" + ab);
            divPanel.setAttribute("class", "navbar-text");
            let aPanel = document.createElement("a");
            aPanel.setAttribute("style", "background-color:" + ab);
            aPanel.setAttribute("href", "/adminPanel");
            aPanel.innerHTML = "Панель администратора";
            divPanel.appendChild(aPanel);
        </#if>

        let formButton = document.createElement("form");
        formButton.setAttribute("class", "form-inline my-2 my-lg-0");
        formButton.setAttribute("action", "/logout");
        formButton.setAttribute("method", "post");
        let button = document.createElement("button");
        button.setAttribute("type", "submit");
        button.setAttribute("class", "btn btn-outline-danger mybtn");
        button.setAttribute("style", "background-color:" + ab);
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
        <#if is = true>
            div.appendChild(divPanel);
        </#if>
        div.appendChild(formButton);
        allDiv.appendChild(div);
        allDiv.setAttribute("style", "background-color: " + ab);
        document.body.prepend(allDiv);
    </script>
</#macro>