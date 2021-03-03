<#import "parts/common.ftlh" as c>
<@c.page>

    <a href="/registration">
        <button type="submit" class="btn btn-primary">Добавить нового пользователя</button>
    </a>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Имя</th>
        <th scope="col">Роль</th>
        <th scope="col">Email</th>
        <th scope="col">Действие</th>
        <th ></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
   <tr>
       <td>${user.username}</td>
       <td>${user.email}</td>
       <td><#list user.roles as role>${role}<#sep>, </#list></td>
       <td><a href="/user/${user.id}"> <button type="submit" class="btn btn-primary">Редактировать</button></a></td>
       <td><form action="${user.id}" method="delete">
           <button type="submit" class="btn btn-outline-danger">Удалить</button>
       </form></td>
   </tr>
    </#list>
    </tbody>
</table>


</@c.page>
