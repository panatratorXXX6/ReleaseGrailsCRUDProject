<!DOCTYPE html>
<html>
<head>
    <h1 align="center">Create new author</h1>
</head>
    <body>
        <div align="center">
                    <g:form controller="author" action="save">
        Name:       <g:field type="text" name="name" value=""></g:field><br>
        Birth Day:  <g:datePicker name="birthday" precision="day" value=""></g:datePicker><br>
        Address:    <g:field type="text" name="address" value=""></g:field><br>
        Description:    <g:field type="text" name="description" value=""></g:field><br>
        List of book:
                    <g:select name="books"
                            from="${releasegrailscrudproject.Book.list()}"
                            value=""
                            optionValue="name"
                            optionKey="id"
                            multiple="true"
                    />
                    <br>
                    <g:submitButton name="submit" class="save"></g:submitButton>
                    </g:form>
                    <p>Click on "submit" button to submit this form</p>
        </div>
    </body>
</html>