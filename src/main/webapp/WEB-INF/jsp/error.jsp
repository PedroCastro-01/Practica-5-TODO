<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">

    <div class="alert alert-danger">

        <h3>Ha ocurrido un error</h3>

        <p>
            Se ha producido una excepción.
            Comprueba el sistema o contacta con soporte.
        </p>

        <p>
            <strong>Error:</strong> ${exception}
        </p>

        <p>
            <strong>URL:</strong> ${url}
        </p>

    </div>

</div>

<%@ include file="common/footer.jspf"%>