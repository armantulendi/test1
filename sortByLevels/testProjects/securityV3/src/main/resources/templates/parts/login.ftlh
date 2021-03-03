<#macro login path isRegisterForm>
    <div class="center"  style="width:700px; margin:0 auto;" >
<form action="${path}" method="post">
    <#if isRegisterForm>
        <div class="form-group row   ">
            <label class="col-sm-2 col-form-label">Email:</label>
            <div class="col-sm-6">
                <input type="text" name="email" class="form-control" placeholder="Email" />
            </div>
        </div>
        <div class="form-group row  ">
            <label class="col-sm-2 col-form-label">Firstname:</label>
            <div class="col-sm-6">
                <input type="text" name="firstname" class="form-control" placeholder="Имя" />
            </div>
        </div>
        <div class="form-group row   ">
            <label class="col-sm-2 col-form-label">Lastname:</label>
            <div class="col-sm-6">
                <input type="text" name="lastname" class="form-control" placeholder="Фамилия" />
            </div>
        </div>
    </#if>
    <div class="form-group row   ">
        <label class="col-sm-2 col-form-label">User Name :</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="Логин" />
        </div>
    </div>
    <div class="form-group row   ">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Пароль" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if isRegisterForm>
    <div class="form-group row  ">
        <label class="col-sm-2 col-form-label">Confirm Password:</label>
        <div class="col-sm-6">
            <input type="password" name="repeatPassword" class="form-control" placeholder="Подтверждение пароли" />
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </#if>
    <div class="col justify-content-start">
        <div class="col-2">
            <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
        </div>
    </div>
</form>
    </div>
</#macro>

<#macro logout path isLogin>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">  Sign Out </button>
</form>

</#macro>
