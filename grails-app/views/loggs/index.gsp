<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <asset:javascript src="logajax.js" />
</head>
    <body>

    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        </ul>
    </div>

    <g:form controller="log" action="delete" class="deleteLogFunction">
        <input type="hidden" value="" name="id" id="ten">
    </g:form>

    <h1 align="center">Logs representation:</h1><br>
        <table align="center">
            <tr>
                <td>Date</td>
                <td>Hash</td>
                <td>Action</td>
            </tr>
                <g:each in="${log}" var="logItem">
                <tr>
                    <td>${logItem.key}</td>
                    <td>${logItem.value}</td>
                    <td>
                        <button onclick="deleteLogs(${logItem})">Delete log</button>
                    </td>
                </g:each>
            </tr>
        </table>
    </body>
</html>