<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/doctor" class="form-inline">
                <input type="text" name="filterDoc" class="form-control" value="${filterDoc?ifExists}" placeholder=" ИИН">
                <button type="submit" class="btn btn-primary ml-2">Найти по ИИН</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Создание направлении
    </a>

    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="iin" placeholder="Введите ИИН" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="analys" placeholder="Назначьте анализ">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="diagnos" placeholder="Диагноз">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="kod" placeholder="код анализа">
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Выбор файла</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div><h5>Назначенные анализы</h5>
    <div class="card-columns">
        <#list doctors as dostor>
            <div class="card my-3">
                <#if dostor.filename??>
                    <img src="/img/${dostor.filename}" class="card-img-top">
                </#if>
                <div class="m-2">
                    <div><span>ИИН: ${dostor.iin}</span></div>
                    <div> <i>Анализ: ${dostor.analys}</i></div>
                    <div> <i>Диагноз: ${dostor.diagnos}</i></div>
                    <div><i>Код анализа: ${dostor.kod}</i></div>
                </div>
                <div class="card-footer text-muted">
                    Назначено: ${dostor.authorName}
                </div>
            </div>
        <#else>
            Нет данных
        </#list>
    </div>
    <h5>Результаты поиска</h5>
<div class="card-columns">

    <#list registrations as filterD>
        <div class="card my-3">
            <#if filterD.filename??>
                <img src="/img/${filterD.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <div><span>ИИН: ${filterD.iin}</span></div>
                <div> <i>ФИО: ${filterD.patientName}</i></div>
                <div> <i>Адресс: ${filterD.address}</i></div>
                <div><i>Место прикрепления: ${filterD.mestoPrik}</i></div>
            </div>
            <div class="card-footer text-muted">
                Отправил: ${filterD.authorName}
            </div>
        </div>
    <#else>
        Нет данных
    </#list>
</div>
    </@c.page>
