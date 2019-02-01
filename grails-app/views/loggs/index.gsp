<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'author.label', default: 'Author')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
    <body>
    <p align="center">Logs representation:</p><br>
        <table align="center">
            <tr>
                <td>Date</td>
                <td>Hash</td>
            </tr>
                <g:each in="${log}" var="logItem">
                <tr>
                    <td>${logItem.key}</td>
                    <td>${logItem.value}</td>
                </g:each>
            </tr>
        </table>
    </body>
</html>