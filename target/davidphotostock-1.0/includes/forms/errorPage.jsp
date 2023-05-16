<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body onload="openError()">
    <c:if test="${not empty errorMessage}">
        <c:if test="${sessionScope.errorActive}">
            <div id="s-error" class="s-error">
                <div class="image-form">
                    <span onclick="closeError()" class="close-x">&times;</span>
                </div>
                <div class="c-error ani-form">${errorMessage}</div>
            </div>
            <c:remove var="errorActive" scope="session" />
        </c:if>
    </c:if>
    <script>
        function openError() {
            document.getElementById('s-error').style.display = 'block';
        }

        function closeError() {
            document.getElementById('s-error').style.display = 'none';
            window.location.href = 'index.jsp';
        }

        var error = document.getElementById('s-error');

        window.onclick = function(event) {
            if (event.target == error) {
                error.style.display = 'none';
                window.location.href = 'index.jsp';
            }
        }
    </script>
</body>
</html>