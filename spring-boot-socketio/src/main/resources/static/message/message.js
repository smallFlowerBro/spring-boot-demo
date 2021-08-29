function output(message) {
    let currentTime = "<span class='time'></span>";
    let element = $("<div>" + currentTime + " " + message + "</div>");
    $('#console').prepend(element);
}