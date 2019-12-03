<#import "parts/common.ftl" as pages>
<@pages.page "Логин">
<img src="https://sun9-8.userapi.com/c851224/v851224158/194606/pW5Vv5hvKX4.jpg" height="25%" width="25%" id="pic"
     style="display: block; margin-left: auto; margin-right: auto; position: relative;">
<form action="/login" method="post">
    <div>
        <label style="position:relative; left: 44%; font-family: sans-serif;"> User Name : </label>
        <br>
        <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; width: 14%; left: 44%; "
               type="text" name="username" id="usrn"/>
    </div>

    <div>
        <label style="position:relative; left: 44%; font-family:sans-serif;"> Password: </label>
        <br>
        <input style="border-width: 0px 0px 1px 0px; position: relative; border-color: silver; outline:none; left: 44%; width: 14%"
               type="password" name="password" id="ps"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </div>
    <br>
    <div><input type="submit" value="Sign In" style="position:relative; left: 49%; font-family:sans-serif;"/></div>
</form>
</@pages.page>