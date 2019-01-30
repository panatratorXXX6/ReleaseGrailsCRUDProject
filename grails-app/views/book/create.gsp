<!DOCTYPE html>
<html>
<head>
    <h1 align="center">Create new book</h1>
</head>
<body>
    <div align="center">
        <g:form controller="book" action="save">
            ISBN number: <g:field type="text" name="isbn" value=""></g:field><br>
            Name of book:<g:field type="text" name="name" value=""></g:field><br>
            Book age: 	 <g:field type="text" name="age" value=""></g:field><br>
            Publish Date:<g:datePicker name="publishDate" precision="day" value="" ></g:datePicker><br>
            Count: 		 <g:field type="text" name="count" value=""></g:field><br>

            <br>
            <g:submitButton name="submit" class="save"></g:submitButton>
        </g:form>
        <p>Click on "submit" button to submit this form</p>
    </div>
</body>
</html>
