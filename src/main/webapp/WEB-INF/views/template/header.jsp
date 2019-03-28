<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fardad
  Date: 3/20/2019
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="fardad yadegari">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Login Page</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-reboot.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-grid.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.css"/>" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">


    <!-- Bootstrap core CSS -->

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/dashboard.css"/>" rel="stylesheet">

    <script>
        var totalFileLength, totalUploaded, fileCount, filesUploaded;

        //To log everything on console
        function debug(s) {
            var debug = document.getElementById('debug');
            if (debug) {
                debug.innerHTML = debug.innerHTML + '<br/>' + s;
            }
        }

        //Will be called when upload is completed
        function onUploadComplete(e) {
            totalUploaded += document.getElementById('files').files[filesUploaded].size;
            filesUploaded++;
            debug('complete ' + filesUploaded + " of " + fileCount);
            debug('totalUploaded: ' + totalUploaded);
            if (filesUploaded < fileCount) {
                uploadNext();
            } else {
                var bar = document.getElementById('bar');
                bar.style.width = '100%';
                bar.innerHTML = '100% complete';
                alert('Finished uploading file(s)');
            }
        }

        //Will be called when user select the files in file control
        function onFileSelect(e) {
            var files = e.target.files; // FileList object
            var output = [];
            fileCount = files.length;
            totalFileLength = 0;
            for (var i = 0; i < fileCount; i++) {
                var file = files[i];
                output.push(file.name, ' (', file.size, ' bytes, ', file.lastModifiedDate.toLocaleDateString(), ')');
                output.push('<br/>');
                debug('add ' + file.size);
                totalFileLength += file.size;
            }
            document.getElementById('selectedFiles').innerHTML = output.join('');
            debug('totalFileLength:' + totalFileLength);
        }

        //This will continueously update the progress bar
        function onUploadProgress(e) {
            if (e.lengthComputable) {
                var percentComplete = parseInt((e.loaded + totalUploaded) * 100 / totalFileLength);
                var bar = document.getElementById('bar');
                bar.style.width = percentComplete + '%';
                bar.innerHTML = percentComplete + ' % complete';
            } else {
                debug('unable to compute');
            }
        }

        //the Ouchhh !! moments will be captured here
        function onUploadFailed(e) {
            alert("Error uploading file");
        }

        //Pick the next file in queue and upload it to remote server
        function uploadNext() {
            var xhr = new XMLHttpRequest();
            var fd = new FormData();
            var file = document.getElementById('files').files[filesUploaded];
            fd.append("multipartFile", file);
            xhr.upload.addEventListener("progress", onUploadProgress, false);
            xhr.addEventListener("load", onUploadComplete, false);
            xhr.addEventListener("error", onUploadFailed, false);
            xhr.open("POST", "save-product");
            debug('uploading ' + file.name);
            xhr.send(fd);
        }

        //Let's begin the upload process
        function startUpload() {
            totalUploaded = filesUploaded = 0;
            uploadNext();
        }

        // //Event listeners for button clicks
        // window.onload = function () {
        //     document.getElementById('files').addEventListener('change', onFileSelect, false);
        //     document.getElementById('uploadButton').addEventListener('click', startUpload, false);
        // }
    </script>
</head>
</html>