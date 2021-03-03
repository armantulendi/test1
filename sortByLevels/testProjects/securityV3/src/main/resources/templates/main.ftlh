<#import "parts/common.ftlh" as c>


<@c.page>
<div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form class="form-inline" method="get" action="/main">

                <input type="text" class="form-control" name="filter" value="${RequestParameters.filter!}" placeholder="Search">
                <button type="submit" class="btn btn-primary ml-2">Search</button>

            </form>
        </div>
    </div>

    <div>
        <form enctype="multipart/form-data" method="post">
            <input type="text" name="text" placeholder="Введите сообщение"/>
            <input type="text" name="tag" placeholder="Тэг">
            <input type="file" name="file">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <#list messages as message>
        <div>
            <b>${message.id}</b>
            <span>${message.text}</span>
            <i>${message.tag}</i>
            <strong>${message.authorName}</strong>
            <div>
                <#if message.fileName??>
                    <img src="/img/message.filename"
                         <#else >Error
                </#if>
            </div>
        </div>
    <#else>
        No message
    </#list>
    </@c.page>
