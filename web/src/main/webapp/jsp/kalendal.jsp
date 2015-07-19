<html lang="ru-RU">
<head>
  <meta charset="UTF-8">
  <title></title>

  <script src="./lib/js/jquery-1.11.1.min.js"></script>
  <script src="./calendar/build/kalendae.standalone.js" type="text/javascript" charset="utf-8"></script>
  <script src="./lib/js/bootstrap.min.js"></script>
  <%--<link href="./lib/css/bootstrap.css" rel="stylesheet"/>--%>
  <link href="./calendar/build/kalendae.css" rel="stylesheet"/>
  <%--<link rel="stylesheet" href="./calendar/build/kalendae.css">--%>
  <!-- <script src="src/moment.js" type="text/javascript" charset="utf-8"></script>
      <script src="build/kalendae.js" type="text/javascript" charset="utf-8"></script> -->

  <style type="text/css" media="screen">
    .kalendae .k-days span.closed {
      background:red;
    }
  </style>
</head>
<body>
<h1>Kalendae</h1>
<p>Single Select</p>
<%--<script type="text/javascript" charset="utf-8">--%>
  <%--new Kalendae(document.body, {--%>
    <%--months:1,--%>
    <%--mode:'single',--%>
    <%--selected:Kalendae.moment().subtract({M:1})--%>
  <%--});--%>

  <%--new Kalendae({--%>
    <%--attachTo:document.body,--%>
    <%--months:2,--%>
    <%--mode:'single',--%>
    <%--selected:Kalendae.moment().subtract({M:1})--%>
  <%--});--%>

  <%--new Kalendae({--%>
    <%--attachTo:document.body,--%>
    <%--months:3,--%>
    <%--mode:'single',--%>
    <%--selected:Kalendae.moment().subtract({M:1})--%>
  <%--});--%>
<%--</script>--%>

<p>Range Select</p>
<%--<script type="text/javascript" charset="utf-8">--%>
  <%--new Kalendae(document.body, {--%>
    <%--months:1,--%>
    <%--mode:'range',--%>
    <%--selected:[Kalendae.moment().subtract({M:1}), Kalendae.moment().add({M:1})]--%>
  <%--});--%>

  <%--new Kalendae({--%>
    <%--attachTo:document.body,--%>
    <%--months:2,--%>
    <%--mode:'range',--%>
    <%--selected:[Kalendae.moment().subtract({M:1}), Kalendae.moment().add({M:1})]--%>
  <%--});--%>

  <%--new Kalendae({--%>
    <%--attachTo:document.body,--%>
    <%--months:3,--%>
    <%--mode:'range',--%>
    <%--selected:[Kalendae.moment().subtract({M:1}), Kalendae.moment().add({M:1})]--%>
  <%--});--%>
<%--</script>--%>

<p>Multi-Select</p>
<script type="text/javascript" charset="utf-8">
  new Kalendae(document.body, {
    months:1,
    mode:'multiple',
    selected:[Kalendae.moment().subtract({M:1}), Kalendae.moment().add({M:1})]
  });

//  new Kalendae({
//    attachTo:document.body,
//    months:2,
//    mode:'multiple',
//    selected:[Kalendae.moment().subtract({M:1}), Kalendae.moment().add({M:1})]
//  });
//
//  new Kalendae({
//    attachTo:document.body,
//    months:3,
//    mode:'multiple',
//    selected:[Kalendae.moment().subtract({M:1}), Kalendae.moment().add({M:1})]
//  });


</script>

<p>Week Select</p>
<%--<script type="text/javascript" charset="utf-8">--%>
  <%--new Kalendae(document.body, {--%>
    <%--months:1,--%>
    <%--mode:'week',--%>
    <%--selected:Kalendae.moment().subtract({M:1})--%>
  <%--});--%>

  <%--new Kalendae({--%>
    <%--attachTo:document.body,--%>
    <%--months:2,--%>
    <%--mode:'week',--%>
    <%--selected:Kalendae.moment().subtract({M:1})--%>
  <%--});--%>

  <%--new Kalendae({--%>
    <%--attachTo:document.body,--%>
    <%--months:3,--%>
    <%--mode:'week',--%>
    <%--selected:Kalendae.moment().subtract({M:1})--%>
  <%--});--%>

<%--</script>--%>

<hr>
<p>Blackout and Direction Tests</p>

<%--<script type="text/javascript" charset="utf-8">--%>
  <%--//direction--%>
  <%--new Kalendae(document.body, {--%>
    <%--months:3,--%>
    <%--direction:'future'--%>
  <%--});--%>

  <%--//direction--%>
  <%--new Kalendae(document.body, {--%>
    <%--months:3,--%>
    <%--direction:'past'--%>
  <%--});--%>

  <%--//blackout--%>
  <%--new Kalendae(document.body, {--%>
    <%--blackout: function (date) {--%>
      <%--return Kalendae.moment(date).date() % 2; //blackout every other day--%>
    <%--}--%>
  <%--});--%>

  <%--//blackout AND direction--%>
  <%--new Kalendae(document.body, {--%>
    <%--direction:'future',--%>
    <%--blackout: function (date) {--%>
      <%--return [1,0,0,0,0,0,1][Kalendae.moment(date).day()]; //blackout weekends--%>
    <%--}--%>
  <%--});--%>

<%--</script>--%>



<hr>
<p>Class Map Test</p>

<%--<script type="text/javascript" charset="utf-8">--%>
  <%--//direction--%>
  <%--var classMap = [];--%>
  <%--classMap[ Kalendae.moment().add({d:5}).format('YYYY-MM-DD') ] = 'closed';--%>

  <%--new Kalendae(document.body, {--%>
    <%--dateClassMap: classMap--%>
  <%--});--%>
<%--</script>--%>
<%--<hr>--%>

<%--Click this input element: <input type="text" value="2/16/2012" id="input1">--%>
<%--<script type="text/javascript" charset="utf-8">--%>
  <%--var k4 = new Kalendae.Input('input1', {--%>
    <%--months:2--%>
  <%--});--%>
<%--</script>--%>

<%--<hr>--%>
<%--This calendar is auto-created.--%>
<%--<div class="auto-kal"></div>--%>

<%--<hr>--%>
<%--So is the one on this input.--%>
<%--<input type="text" class="auto-kal">--%>

<%--<hr>--%>
<%--<div style="width: 300px;height: 300px;overflow:scroll;border:1px solid black;">--%>
  <%--Scroll down and left to find an input.--%>
  <%--<div style="height:300px;"></div>--%>
  <%--<div style="text-align: right;width: 600px;">--%>
    <%--<input type="text" class="auto-kal">--%>
  <%--</div>--%>
<%--</div>--%>

<%--<hr>--%>
<%--This calendar is auto-created with months: 3 and direction: 'future'.--%>
<%--<div class="auto-kal" data-kal="months: 3, direction: 'future'"></div>--%>

<%--<hr>--%>
<%--This calander on this input is auto-created with direction: 'future'.--%>
<%--<input type="text" class="auto-kal" data-kal="direction: 'future'">--%>

<%--<hr>--%>
<%--This calendar allows clicks outside of the focused month (dayOutOfMonthClickable: true):--%>
<%--<div class="auto-kal" data-kal="months: 1, dayOutOfMonthClickable: true"></div>--%>

<%--<hr>--%>
<%--This calendar has no year navigation (useYearNav: false).--%>
<%--<div class="auto-kal" data-kal="useYearNav: false"></div>--%>


</body>
</html>
