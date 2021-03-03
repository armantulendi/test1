<#--Определяем переменные для freemarker, переменные подтягивается из контроллера -->
<#assign
known=Session.SPRING_SECURITY_CONTEXT??
>
<#if known><#--if session opened-->
    <#assign
    user=Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name=user.getUsername()
    isAdmin=user.isAdmin()
    >
<#else>
    <#assign
        name="пользователь"
        isAdmin=false
    >
</#if>