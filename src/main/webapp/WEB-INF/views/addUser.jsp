<%--
  Created by IntelliJ IDEA.
  User: SOBHAN
  Date: 3/20/2019
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<form class="form-signin">

    <div class="input-group input-group-lg margin-bottom">
        <div class="input-group-append">
            <span class="input-group-text"><i class="fa fa-user-secret"></i></span>
        </div>
        <input type="text" class="form-control" aria-label="Small" placeholder="username" aria-describedby="inputGroup-sizing-lg">
    </div>

    <div class="input-group input-group-lg margin-bottom">
        <div class="input-group-append">
            <span class="input-group-text"><i class="fa fa-key"></i></span>
        </div>
        <input type="password" class="form-control" aria-label="Small" placeholder="password" aria-describedby="inputGroup-sizing-lg">
    </div>

    <div class="input-group input-group-lg margin-bottom">
        <div class="input-group-append">
            <span class="input-group-text"><i class="fa fa-user"></i></span>
        </div>
        <input type="text" class="form-control" aria-label="Small" placeholder="firstname" aria-describedby="inputGroup-sizing-lg">
    </div>

    <div class="form-check margin-bottom">
        <input class="form-check-input position-static" type="radio" name="blankRadio" id="blankRadio1" value="option1" aria-label="...">
        <label class="form-check-label">
            Enabled
        </label>
    </div>

    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
        <label class="form-check-label" for="inlineCheckbox1">Company Admin</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
        <label class="form-check-label" for="inlineCheckbox2">System Admin</label>
    </div>


    <button class="btn btn-lg btn-primary btn-block margin-top" type="submit">ثبت کاربر</button>
</form>
