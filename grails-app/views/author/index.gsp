<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'author.label', default: 'Author')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <asset:javascript src="tableauthor.js" />
    <asset:javascript src="authorajax.js" />

</head>
<body>

<input type="submit" id="increaseA" value="Increase" onclick="increase()" />
<input type="hidden" id="undoId" value="Undo" onclick="undo()" />

<a href="#list-author" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
    <div class="nav" role="navigation">
         <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
         </ul>
    </div>

<g:form controller="author" action="delete" class="deleteFunction" >
    <input type="hidden" value="" name="id" id="five">
</g:form>


    <fieldset>
        <div>
            <br>
            <strong>Metrics</strong>
            <p>Amount of authors: ${amountOfAuthors}</p>
            <p>The youngest author: ${youngestAuthor.name}</p>
            <p>The oldest author: ${oldestAuthor.name}</p>
            %{--<p>The best-selling author: ${bestSellingAuthor.name}</p>--}%
            %{--<p>The least-selling author: ${}</p>--}%
            %{--<p>The most efficient author: ${}</p>--}%
        </div>

        <div id="dialog">
            <p>Name: <span id="modalname"></span></p>
            <p>Address: <span id="modaladdress"></span></p>
            <p>Description: <span id="modaldescription"></span></p>
        </div>

    </fieldset>
        <h4 align="center">An information about authors</h4>

<table id="table" class="tab">
    <tr>
        <th>Name</th>
        <th>Birth Day</th>
        <th>Address</th>
        <th>Description</th>
        <th>Author's book(s)</th>
        <th>Actions</th>
    </tr>
    <g:each in="${allAuthors}" var="item">
        <tr>
            <td>${item?.name}</td>
            <td>${item?.birthday}</td>
            <td>${item?.address}</td>
            <td>${item?.description}</td>
            <td>Some books</td>
            <td>
               <button onclick="editAuthor(${item.id})">Edit it</button>
               <button onclick="deleteAuthor(${item.id})">Delete it</button>
               <button onclick="descriptionAuthor(${item.id})">Description</button>
            </td>
        </tr>
    </g:each>
</table>
</body>
</html>