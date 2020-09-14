<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1><p:show person="${person}">
    Dette er body
</p:show></h1>

<p>Du er ${person?.age ?: 'et ukendt antal'} år gammel</p>

<p>Din fødselsdag er <g:formatDate date="${person?.dob}" format="d. MMMMM yyyy"/></p>
<g:unless test="${person?.errors}">
    <hr/>
    <h3>Fejl:</h3>
    <g:renderErrors bean="${person}"/>
</g:unless>
</body>
</html>
