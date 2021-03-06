<#macro page title>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-16BE">
        <title>${title}</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <style>
        *{
            --main: #eeeeee;
            --input-border-color: #bbbbbb;
            --success-background: #d4edda;
            --input-background: #ffffff;
            background-color: var(--main);
        }
        .form-success-text{
            background-color: var(--success-background);
        }
        .form-input{
            background-color: var(--input-background);
        }
        .login-input{
            background-color: var(--main);
            border-width: 0 0 1px 0;
            border-color: var(--input-border-color);
            outline: none;
        }
        .profile-input{
            background-color: var(--input-background);
            border-width: 0 0 1px 0;
            border-color: var(--input-border-color);
            outline: none;
            width: 28vw;
            min-width: 150px;
        }
        .profile-label{
            background-color: white;
        }

        </style>
    </head>
    <body style="background-color: var(--main)">

    <#nested>

    </body>
    </html>
</#macro>
<#macro myTextInput left width id>
    <input style="border-width: 0 0 1px 0; position: relative; border-color: silver; outline:none; left: ${left}%; width: ${width}%" id="${id}" name="${id}" class="form-input">
</#macro>