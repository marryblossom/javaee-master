var XMLHttp=null;
if (window.XMLHttpRequest)
{
  XMLHttp=new XMLHttpRequest()
}else if (window.ActiveXObject)
{
  XMLHttp=new ActiveXObject("Microsoft.XMLHTTP");
}

function callServer() {
  var city = document.getElementById("city").value;
  var state = document.getElementById("state").value;
  var url = "/web/xmlTest/xml?city=" + city + "&state=" + state;
  XMLHttp.open("POST", url, true);
  XMLHttp.onreadystatechange = updatePage;
  XMLHttp.send(null);
}
function updatePage() {
  if (XMLHttp.readyState == 4) {
    var response = XMLHttp.responseText;
    document.getElementById("zipCode").value = response;
  }
}