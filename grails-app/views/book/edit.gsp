<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

<h1 align="center">Edit book</h1>
<div align="center">
    <g:form controller="book" action="editBook" >
                     <g:hiddenField name="id" value="${bookBook.id}" ></g:hiddenField><br>
        Name: 	     <g:field type="text" name="name" value="${bookBook.name}"></g:field><br>
        ISBN	     <g:field type="text" name="isbn" value="${bookBook.isbn}" ></g:field><br>
        Age 	     <g:field type="text" name="age" value="${bookBook.age}"></g:field><br>
        Publish Date <g:datePicker name="publishDate" precision="day" value="${bookBook.publishDate}"></g:datePicker><br>
        Count        <g:field type="text" name="count" value="${bookBook.count}"></g:field>

        <p><input type="submit" value="Submit"></p>
    </g:form>
    <p>Click the "Submit" button once you're done</p>
</div>
</body>
</html>