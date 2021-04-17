<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DDshka
  Date: 06.02.2018
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <title>Realtime communication with WebRTC</title>

    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</head>

<body>

<h1>Realtime communication with WebRTC</h1>

<form:form id="formCreate" action="/create" method="post" class="form-inline">
    <label for="formCreateText">Enter room id</label>
    <input type="text" name="roomId" id="formCreateText" class="form-control">

    <button type="submit" class="btn btn-primary">Create</button>
</form:form>

<%--<video id="localVideo" autoplay></video>--%>
<%--<video id="remoteVideo" autoplay></video>--%>

<%--<div>--%>
    <%--<button id="startButton" onclick="start()">Start</button>--%>
    <%--<button id="callButton" onclick="call()">Call</button>--%>
    <%--<button id="hangupButton">Hang Up</button>--%>
<%--</div>--%>


</body>

</html>
