<%@include file="/WEB-INF/views/template/header.jsp" %>


<c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
</c:if>

<form class="form-signin" name="loginForm" action="<c:url value="/j_spring_security_check"/>" method="post">
    <div class="text-center mb-4">

        <h1 class="h3 mb-3 font-weight-normal">Login Page</h1>
        <p>please enter your username and password</p>
    </div>

    <c:if test="${not empty error}">
        <div class="error" style="color:red;">${error}</div>
    </c:if>

    <div class="form-label-group">
        <input type="text" id="username" class="form-control" name="username" placeholder="UserName" required autofocus>
        <label for="username">username</label>
    </div>

    <div class="form-label-group">
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
        <label for="inputPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>





