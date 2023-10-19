    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>
    <div class="container">
        <h1>Add a todo</h1>
        <form:form method="post" commandName="todo">
            <fieldset class="form-group">
                <form:label path="description" class="form-label">Description</form:label>
                <form:input path="description" class="form-control" type="text" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>
            <fieldset class="form-group">
                <form:label path="targetDate" class="form-label">Target Date</form:label>
                <form:input path="targetDate" class="form-control" type="text" required="required"/>
                <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>
            <br>
            <div>
                <input class="btn btn-success" value="Add" type="submit"/>
            </div>
        </form:form>
    </div>
 <%@ include file="common/footer.jspf"%>