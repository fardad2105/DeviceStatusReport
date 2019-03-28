<%--
  Created by IntelliJ IDEA.
  User: SOBHAN
  Date: 3/26/2019
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">welcome : ${pageContext.request.userPrincipal.name}</a>
    </c:if>
    <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span><i class="fa fa-home"></i></span>
                            Home <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="upload.html">
                            <span><i class="fa fa-upload"></i></span>
                            uploadExcel
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span><i class="fa fa-download"></i></span>
                            Download
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span><i class="fa fa-calculator"></i></span>
                            Calculate
                        </a>
                    </li>

                    <c:if test="${pageContext.request.userPrincipal.name =='admin'}">

                        <li class="nav-item">
                            <a class="nav-link" href="/admin">
                                <span><i class="fa fa-user-circle"></i></span>
                                Add User
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="/admin/listOfUsers">
                                <span><i class="fa fa-users"></i></span>
                                List Of Users
                            </a>
                        </li>

                    </c:if>

                </ul>

            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h4">Home Page</h1>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <div class="btn-group mr-2">
                        <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                    </div>
                    <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                        <span data-feather="calendar"></span>
                        This week
                    </button>
                </div>
            </div>

            <div class="my-4 w-100" id="myChart" width="900px" height="380px">


            </div>


        </main>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>