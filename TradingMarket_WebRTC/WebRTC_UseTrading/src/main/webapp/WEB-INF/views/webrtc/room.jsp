<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DDshka
  Date: 08.02.2018
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room</title>
    <link rel="stylesheet" href="/css/room.css">
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css">
    <script type="text/javascript" src="/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/webjars/stomp-websocket/2.3.3-1/stomp.min.js"></script>
    <script type="text/javascript" src="/webjars/sockjs-client/1.1.1/sockjs.min.js"></script>
    <script type="text/javascript" src="/js/main.js"></script>

</head>
<script type="text/javascript">
    var crsf = "${_csrf.parameterName}=${_csrf.token}";
    var userId = ${userId};
    var offer = ${offer};
    var answer = ${answer};
    var roomId = ${roomId};
</script>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-10 video-col">
                <video id="localVideo" autoplay></video>
                <video id="remoteVideo" autoplay></video>
            </div>
            <div class="col-lg-2 chat-col">
                <div class="message-container">
                    <ul id="messageList" class="list-unstyled">

                    </ul>
                </div>
                <div class="input-container">
                    <div>
                        <textarea id="messageInput" placeholder="Type something here..."></textarea>
                    </div>
                    <div class="input-button-wrapper">
                        <button id="messageButton" onclick="sendMessage(event)" class="btn btn-primary">Send</button>
                    </div>
                    <div>
                        <form id="fileInfo">
                            <input type="file" id="fileInput" name="files">
                        </form>

                        <form id="uploadFile">
                            <input type="file" name="file" id="file">
                            <button onclick="sooqaBLIATZAENBALO(event)" type="button">Send</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
