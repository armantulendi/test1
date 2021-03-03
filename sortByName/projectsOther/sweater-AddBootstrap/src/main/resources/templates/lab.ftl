<#import "parts/common.ftl" as c>

<@c.page>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/lab" class="form-inline">
                <input type="text" name="filterLab" class="form-control" value="${filterLab?ifExists}" placeholder=" ИИН">
                <button type="submit" class="btn btn-primary ml-2">Найти по ИИН</button>
            </form>
        </div>
    </div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Добавить результатов
    </a>

    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="nomer" placeholder="Номер заявки" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="result" placeholder="Результат">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="iin" placeholder="ИИН">
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
    </div>
    <h5>Результаты анализов</h5>
    <div class="card-columns">
    <#list laboratorias as laboratoria>
        <div class="card my-3">
            <#if laboratoria.filename??>
                <img src="/img/${laboratoria.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <div><span>Номер заявки: ${laboratoria.nomer}</span></div>
                <div> <i>Резултат: ${laboratoria.result}</i></div>
                <div> <i>ИИН: ${laboratoria.iin}</i></div>
                <div><i>Код анализа: ${laboratoria.kod}</i></div>
            </div>
            <div class="card-footer text-muted">
                Назначено: ${laboratoria.authorName}
            </div>
        </div>
    <#else>
        Нет данных
    </#list>
    </div>
    <h5>Результаты поиска</h5>
        <div class="card-columns">
            <#list doctors1 as doctor1>
                <div class="card my-3">
                    <#if doctor1.filename??>
                        <img src="/img/${doctor1.filename}" class="card-img-top">
                    </#if>
                    <div class="m-2">
                        <div><span>ИИН: ${doctor1.iin}</span></div>
                        <div> <i>Анализ: ${doctor1.analys}</i></div>
                        <div> <i>Диагноз: ${doctor1.diagnos}</i></div>
                        <div><i>Код анализа: ${doctor1.kod}</i></div>
                    </div>
                    <div class="card-footer text-muted">
                        Отправил: ${doctor1.authorName}
                    </div>
                </div>
            <#else>
                Нет данных
            </#list>
        </div>

</@c.page>
