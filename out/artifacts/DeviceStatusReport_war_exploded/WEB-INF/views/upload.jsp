<%--<h1>Spring MVC file upload example</h1>--%>

<%--<form method="POST" action="${pageContext.request.contextPath}/upload"--%>
<%--enctype="multipart/form-data">--%>
<%--<input type="file" name="file" /> <input type="submit" value="Submit" />--%>
<%--</form>--%>

<%--<h1>Upload Status</h1>--%>

<%--<h2>Message : ${message}</h2>--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>


<div class="container">
    <div class="upload">
        <div class="upload-files">
            <form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
                <header>
                    <p>
                        <i class="fa fa-cloud-upload" aria-hidden="true"></i>
                        <span class="up">up</span>
                        <span class="load">load</span>
                    </p>
                </header>
                <div class="body" id="drop">
                    <i class="fa fa-file-text-o pointer-none" aria-hidden="true"></i>
                    <p class="pointer-none"><b>Drag and drop</b> files here <br/> or <a href=""
                                                                                        id="triggerFile">browse</a> to
                        begin the upload</p>
                    <input type="file" name="file"/> <input type="submit" value="Submit"/>

                </div>
                <footer>
                    <div class="divider">
                        <span><AR>FILES</AR></span>
                    </div>
                    <div class="list-files">
                        <!--   template   -->
                    </div>
                    <button class="importar" type="submit">Save File</button>
                </footer>
            </form>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp" %>