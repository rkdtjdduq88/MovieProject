<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
</head>
<body>
	<script language="JavaScript">
		expireDate=new Date
		expireDate.setMonth(expireDate.getMonth()+3)
		
		hitCt=eval(cookieVal("pageHit"))
		hitCt++
		document.cookie="pageHit="+hitCt+";expires="+expireDate.toGMTString()
		funtion cookieVal(cook ieName) {
			thisCookie = document.cookie.split("; ")
			for (i=0; i<thisCookie.length; i++){
				if (cookieName == thisCookie[i].split("=")[0]){
					return thisCookie[i].split("=")[1\
				}
			}
			return 0
		}
	</script>
</body>
</html>
