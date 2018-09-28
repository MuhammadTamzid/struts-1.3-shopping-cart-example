<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
    <title>Struts Hibernate Example</title>
</head>
<body>
    <h2>Category</h2>
    <div>
        <html:errors property="title"/>
    </div>

    <html:form action="/category.do">
        <div>
            <div>
                Title:
                <html:text property="title" size="45" maxlength="45" />
            </div>
            <div>
                <html:submit>
                    Submit
                </html:submit>
                <html:reset>
                    Reset
                </html:reset>
            </div>
        </div>
    </html:form>
</body>
</html>
