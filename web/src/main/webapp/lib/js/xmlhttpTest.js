/* Create a new XMLHttpRequest object to talk to the Web server */
var xmlHttp = false;
try {
  xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
  try {
    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  } catch (e2) {
    xmlHttp = false;
  }
}
/*@cc_on @*/
/*@if (@_jscript_version >= 5)

 @end @*/
//if (!xmlHttp &amp;& typeof XMLHttpRequest != 'undefined') {
//  xmlHttp = new XMLHttpRequest();
//}
function callServer() {
  // Get the city and state from the web form
  var city = document.getElementById("city").value;
  var state = document.getElementById("state").value;
  // Only go on if there are values for both fields
  if ((city == null) || (city == "")) return;
  if ((state == null) || (state == "")) return;

  // Build the URL to connect to
  var url = "/scripts/getZipCode.php?city=" + escape(city) + "&state=" + escape(state);

  // Open a connection to the server
  xmlHttp.open("GET", url, true);

  // Setup a function for the server to run when it's done
  xmlHttp.onreadystatechange = updatePage;

  // Send the request
  xmlHttp.send(null);
}
function updatePage() {
  if (xmlHttp.readyState == 4) {
    var response = xmlHttp.responseText;
    document.getElementById("zipCode").value = response;
  }
}