<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-4 col-form-label"><h1>Вход в МИС</h1></label>

    </div>
    <div class="form-group row">

        <label class="col-sm-3 col-form-label"><h5>Имя пользователя:</h5></label>
        <div class="col-sm-5">
            <input type="text" name="username" class="form-control" placeholder="Логин" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-3 col-form-label"><h5>Пароль:</h5></label>
        <div class="col-sm-5">
            <input type="password" name="password" class="form-control" placeholder="Пароль" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a href="/registration">Регистрация</a></#if>
    <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Выйти</button>
</form>
</#macro>
