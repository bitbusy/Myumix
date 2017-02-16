<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Audio Recorder</title>
	<% String name =(String) session.getAttribute("name");
		String tuneid =(String) session.getAttribute("id");
		out.println(name);
	%>
	 <script src="AudioRecorder/audiodisplay.js"></script> 
	<script src="AudioRecorder/recorder.js"></script>
	<script src="AudioRecorder/main.js"></script>
	<style>
	html { overflow: hidden; }
	body { 
		font: 14pt Arial, sans-serif; 
		background: lightgrey;
		display: flex;
		flex-direction: column;
		height: 100vh;
		width: 100%;
		margin: 0 0;
	}
	canvas { 
		display: inline-block; 
		background: #202020; 
		width: 95%;
		height: 10%;
		box-shadow: 0px 0px 10px blue;
	}
	#controls {
		display: flex;
		flex-direction: row;
		align-items: right;
		justify-content: space-around;
		height: 20%;
		width: 20%;
	}
	#record { height: 15vh; }
	#record.recording { 
		background: red;
		background: -webkit-radial-gradient(center, ellipse cover, #ff0000 0%,lightgrey 75%,lightgrey 100%,#7db9e8 100%); 
		background: -moz-radial-gradient(center, ellipse cover, #ff0000 0%,lightgrey 75%,lightgrey 100%,#7db9e8 100%); 
		background: radial-gradient(center, ellipse cover, #ff0000 0%,lightgrey 75%,lightgrey 100%,#7db9e8 100%); 
	}
	#save, #save img { height: 10vh; }
	#save { opacity: 0.25;}
	#save[download] { opacity: 1;}
	#viz {
		height: 80%;
		width: 100%;
		display: flex;
		flex-direction: column;
		justify-content: space-around;
		align-items: center;
	}
	@media (orientation: landscape) {
		body { flex-direction: row;}
		#controls { flex-direction: column; height: 100%; width: 10%;}
		#viz { height: 100%; width: 90%;}
	}

	</style>
</head>
<body>
	<div id="viz">
		<!--  <canvas id="analyser" width="1024" height="500"></canvas> -->
		 <canvas id="wavedisplay" width="1024" height="100"></canvas>
	</div>
	<div id="controls">
		<img id="record" src="images/mic128.png" onclick="toggleRecording(this);">
		<a id="save" href="#"><img src="images/save.svg"></a>
	</div>
	<audio controls>
  <source src="horse.ogg" type="audio/ogg">
  <source src="music/<%=name %>" type="audio/mpeg">.
  
</audio>
<form action="MergeController"
  
  
  method="post" enctype="multipart/form-data">
  Select that file: 
  <input type="file" name="first" />
  <input type="hidden" value = <%=tuneid %> name="tune">
  <br/>
  <input type="submit" name="button" value="Merge" />
</form>
</body>
</html>