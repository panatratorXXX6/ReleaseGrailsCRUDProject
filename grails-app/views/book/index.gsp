<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'author.label', default: 'Book')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

    <link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/start/jquery-ui.min.css" rel="stylesheet">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <asset:javascript src="tablebook.js" />

</head>
<body>

<g:form controller="book" action="delete" class="deleteFunctionBook">
    <input type="hidden" value="" name="id" id="six" >
</g:form>

<a href="#list-author" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>

<table>
    <tr>
        <th>Name of book</th>
        <th>ISBN number</th>
        <th>Book age</th>
        <th>Publish Date</th>
        <th>Count</th>
        <th>Actions</th>
    </tr>
    <g:each in="${allBooks}" var="item">
        <tr>
            <td>${item?.name}</td>
            <td>${item?.isbn}</td>
            <td>${item?.age}</td>
            <td>${item?.publishDate}</td>
            <td>${item?.count}</td>
            <td>
                <button onclick="editBook(${item.id})">Edit it</button>
                <button onclick="deleteBook(${item.id})">Delete it</button>
            </td>
        </tr>
    </g:each>
</table>
</body>
</html>