'use strict';

var stompClient;

var localVideo;
var remoteVideo;

var localStream;

var peerConnection;
var messageChannel;
var dataChannel;

var tempLD;
var userId;

var fileInput;
var receiveBuffer = [];
var receivedSize = 0;
var totalSize = 0;
var filename = "";

var pc_config = {"iceServers":[{
    "urls":[
        "turn:74.125.140.127:19305?transport=udp",
        "turn:[2a00:1450:4013:c03::7f]:19305?transport=udp",
        "turn:74.125.140.127:443?transport=tcp",
        "turn:[2a00:1450:4013:c03::7f]:443?transport=tcp"
    ],
    "username":"CK6shtQFEgZTsEhyJPgYzc/s6OMTIICjBQ",
    "credential":"cKBPxgp5AcjaJrIdbJ5vnspUp84="}, {
        "urls":["stun:stun.l.google.com:19302"]
    }
]};

var pc_constraints = {"optional": [{"DtlsSrtpKeyAgreement": true}]};

var offerOptions = {
    'mandatory': {
        'OfferToReceiveAudio': true,
        'OfferToReceiveVideo': true
    }
};

function openSocket() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/ws/answer/' + roomId, function (data) {
            var msg = JSON.parse(data.body);
            console.log("ANSWER RECIEVED");
            if (peerConnection.remoteDescription.sdp == "") {
                if (peerConnection.localDescription.sdp == "") {
                    peerConnection.setLocalDescription(tempLD);
                }
                peerConnection.setRemoteDescription(new RTCSessionDescription(msg));
                console.log("REMOTE DESCRIPTION IS SET");
            }
        });
        stompClient.subscribe("/ws/" + roomId + "/" + userId, function (data) {
            var msg = JSON.parse(data.body);
            peerConnection.addIceCandidate(new RTCIceCandidate(msg));
        });
    });
}

function sooqaBLIATZAENBALO(event){
    //Prevent default submission of form
    event.preventDefault();
    var file = document.getElementById("file");
    var formData = new FormData();
    formData.append("file", file.files[0]);
    $.ajax({
        type: 'POST',
        url : '/uploadFile',
        data : formData,
        processData: false,
        cache: false,
        contentType : false
    });
}
//
// $("#sendFileButton").click(function(e) {
//
// });

$(function() {
    fileInput = document.querySelector('input#fileInput');
    fileInput.addEventListener('change', handleFileInputChange, false);
    $('#messageInput').keydown(function(event) {
        if (event.which == 13 && !event.shiftKey) {
            sendMessage(event);
            return false;
        }
    });

    openSocket();

    localVideo = document.getElementById("localVideo");
    remoteVideo = document.getElementById("remoteVideo");

    // get user`s video and audio
    navigator.mediaDevices.getUserMedia({
        audio: false,
        video: true
    })
    .then(gotStream);

});

function gotStream(stream) {
    // Setting up source for local video
    localVideo.srcObject = stream;
    localStream = stream;

    $('#localVideo').addClass('not-connected-local');

    peerConnection = new RTCPeerConnection(pc_config, pc_constraints);
    peerConnection.onicecandidate = function(e) {
        onIceCandidate(e);
    };
    peerConnection.oniceconnectionstatechange = function(e) {
        onIceStateChange(peerConnection, e);
    };

    localStream.getTracks().forEach(
        function(track) {
            peerConnection.addTrack(
                track,
                localStream
            );
        }
    );

    peerConnection.ontrack = gotRemoteStream;
    peerConnection.ondatachannel = receiveChannelCallback;

    if (isEmpty(offer)) {
        messageChannel = peerConnection.createDataChannel('messageChannel', null);
        messageChannel.onmessage = messageReceived;

        dataChannel = peerConnection.createDataChannel('dataChannel', null);
        dataChannel.onmessage = dataReceived;

        peerConnection.createOffer(
            offerOptions
        ).then(
            onCreateOfferSuccess,
            error
        );
    }
    else {
        peerConnection.setRemoteDescription(offer);
        peerConnection.createAnswer().then(
            onCreateAnswerSuccess,
            error
        );

    }

}

function gotRemoteStream(e) {
    if (remoteVideo.srcObject !== e.streams[0]) {
    remoteVideo.srcObject = e.streams[0];
    }

    $('#localVideo')
        .removeClass('not-connected-local')
        .addClass('connected-local');
    $('#remoteVideo').addClass('connected-remote');
}

function onCreateOfferSuccess(desc) {
    console.log("OFFER CREATED ", desc);
    tempLD = desc;
    //peerConnection.setLocalDescription(desc);

    sendAjax("/sendOffer/" + roomId, desc);

    console.log("OFFER HAS BEEN SENT");
}

function receiveChannelCallback(event) {
    console.log('Receive Channel Callback');
    if (event.channel.label === 'messageChannel') {
        messageChannel = event.channel;
        messageChannel.onmessage = messageReceived;
    }
    else if (event.channel.label === 'dataChannel') {
        dataChannel = event.channel;
        dataChannel.onmessage = dataReceived;
    }
}

function onCreateAnswerSuccess(desc) {
    console.log("ANSWER CREATED ", desc);
    tempLD = desc;
    peerConnection.setLocalDescription(desc);

    sendAjax("/sendAnswer/" + roomId, desc);
    console.log("ANSWER HAS BEEN SENT");
}

function onIceCandidate(event) {
    if (!event.candidate) return;
    sendAjax("/ice/" + roomId + "/" + userId, event.candidate);
}

function onIceStateChange(pc, event) {
    if (pc) {
        console.log('ICE state change event: ', event);
    }
}

// ----------------------- ADDITIONAL FUNCTIONS ----------------------

function sendAjax(destination, msg, callback) {
    var _data = JSON.stringify(msg);
    $.ajax({
        url: destination + '?' + crsf,
        contentType: "application/json; charset=utf-8",
        traditional: true,
        type: 'post',
        data: _data,
        success: function (data) {
            if (callback) {
                callback(data);
            }
        },
        error: function (error) {
            console.log(error);
        }
    });
}

function isEmpty(variable) {
    var i = 0;
    for ( var prop in variable ) {
        i++;
    }
    return i == 0;
}

function error(error) {
    console.log(error.name + ': ' + error.message);
}

// ----------------------- THE GREAT CODE ----------------------------

function sendMessage(event) {
    var messageInput = $('#messageInput');
    var messageText = messageInput.val().trim();
    if(messageText && stompClient){
        var messageObj = {
            roomName: roomId,
            userName: userId,
            message: messageText
        };
        appendMessage(messageObj);
        messageChannel.send(JSON.stringify(messageObj));
        //stompClient.send("/app/chat/sendMessage",{},JSON.stringify(mess));
    }
    messageInput.val('');
}

function dataReceived(event) {
    if (!isNaN(event.data)) {
        console.log("RECEIVED TOTAL SIZE " + totalSize);
        totalSize = JSON.parse(event.data);
    }
    else if (typeof event.data === 'string') {
        console.log("RECEIVED FILENAME ", filename)
        filename = event.data;
    }
    else {
        console.log("RECEIVED FILE PART");
        receiveBuffer.push(event.data);
        receivedSize += event.data.byteLength;
    }

    if (receivedSize === totalSize) {
        var received = new window.Blob(receiveBuffer);
        var url = URL.createObjectURL(received);

        var list = document.querySelector('ul#messageList');
        var newlink = document.createElement('a');
        newlink.download = filename;
        newlink.innerHTML = filename;
        newlink.setAttribute('href', url);

        var newli = document.createElement('li');
        newli.appendChild(newlink)
        list.appendChild(newli);

        //appendMessage(aObject);
    }
}

function messageReceived(msg) {
    var messageObj = JSON.parse(msg.data);
    appendMessage(messageObj);
}

function appendMessage(messageObj) {
    var li = $('<li></li>').text(messageObj.userName + ": " + messageObj.message);
    $('#messageList').append(li);
}

// -------------------- FILE TRANSFER -----------------------------

function handleFileInputChange() {
    var file = fileInput.files[0];
    if (!file) {
        alert("No file has been chosen");
    } else {
        fileInput.disabled = true;
        if (file.size === 0) {
            alert('FILE IS EMPTY!')
            return;
        }

        dataChannel.send(file.size);
        dataChannel.send(file.name);

        var chunkSize = 16384;
        var sliceFile = function(offset) {
            var reader = new window.FileReader();
            reader.onload = (function() {
                return function(e) {
                    dataChannel.send(e.target.result);
                    console.log("SEND SOMETHING");
                    if (file.size > offset + e.target.result.byteLength) {
                        window.setTimeout(sliceFile, 0, offset + chunkSize);
                    }
                };
            })(file);
            var slice = file.slice(offset, offset + chunkSize);
            reader.readAsArrayBuffer(slice);
        };
        sliceFile(0);
    }
}