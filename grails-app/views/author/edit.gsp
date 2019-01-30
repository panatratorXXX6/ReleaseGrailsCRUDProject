<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

<h1 align="center">Edit author</h1>
<div align="center">
                    <g:form controller="author" action="editAuthor" >
                        <g:hiddenField name="id" value="${authorAuthor.id}" ></g:hiddenField><br>
        Name: 		<g:field type="text" name="name" value="${authorAuthor.name}"></g:field><br>
        Birth Day	<g:datePicker name="birthday" precision="day" value="${authorAuthor.birthday}" ></g:datePicker><br>
        Address 	<g:field type="text" name="address" value="${authorAuthor.address}"></g:field><br>
        Description <g:field type="text" name="description" value="${authorAuthor.description}"></g:field><br>
        List of books

                    <g:select name="books"
                              from="${releasegrailscrudproject.Book.list()}"
                              value=""
                              optionValue="name"
                              optionKey="id"
                              multiple="true"
                    />

                    <p><input type="submit" value="Submit"></p>
                    </g:form>
                    <p>Click the "Submit" button once you're done</p>
        </div>
    </body>
</html>