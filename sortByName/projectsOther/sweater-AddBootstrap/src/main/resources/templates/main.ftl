<#import "parts/common.ftl" as c>

<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder=" ИИН">
            <button type="submit" class="btn btn-primary ml-2">Найти по ИИН</button>
        </form>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Регистрация пациента
</a>

    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="iin" placeholder="Введите ИИН" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="patientName" placeholder="Введите ФИО">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="address" placeholder="Введите адресс">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="mestoPrik" placeholder="Введите место прикрипления">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Добавить файл</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>


<div class="card-columns">
    <h5>Пациенты</h5>
    <#list registrations as registration>
    <div class="card my-3">
        <#if registration.filename??>
        <img src="/img/${registration.filename}" class="card-img-top">
        </#if>
        <div class="m-2">
            <div><span>ИИН: ${registration.iin}</span></div>
            <div> <i>ФИО: ${registration.patientName}</i></div>
                <div> <i>Адресс: ${registration.address}</i></div>
                    <div><i>Место прикрепления: ${registration.mestoPrik}</i></div>
        </div>
        <div class="card-footer text-muted">
            Отправил: ${registration.authorName}
        </div>
    </div>
    <#else>
    Нет данных
    </#list>
</div>
</@c.page>
