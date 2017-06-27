/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

/**
 *
 * @author belden
 */
public class Calculate {

    	long r,x,y;					

Calculate (long r,long x,long y){
	this.r = r;
  this.x = x;
  this.y = y;
}

void calculatePipe(){
  long rl = $j("#dl").val() / 2;long rs = $j("#ds").val() / 2;
  if (rl > 0 & rs > 0){
  long noPipes = 0;
  long pipes = [];
  long rc = rl - rs;
    if (rs > rl) {
      alert("Inside smaller diameters larger than outside diameter!");
    } else if (rl < 2 * rs){
      pipes.push([new Pipe(rs, 0, 0)]);
      drawPipes(rl);
    } else { 	
      makePipes(rc);
      drawPipes(rl);
      $j("#results").html("Maximum number of smaller pipes or circles innside the larger one: <b><u>" + noPipes + "</u></b>");
    } 
  } else {
    alert("Diameters must be larger than 0!");
  }
  function makePipes(rc){
 long no = Math.floor((2 * Math.PI * rc) / (2 * rs));
  long ps = [];
  long x0 = rc * Math.cos(0 * 2 * Math.PI / no);
  long y0 = rc * Math.sin(0 * 2 * Math.PI / no);
  long x1 = rc * Math.cos(1 * 2 * Math.PI / no);
  long y1 = rc * Math.sin(1 * 2 * Math.PI / no);
  long dist = Math.pow((Math.pow((x0 - x1),2) + Math.pow((y0 - y1),2)),0.5);
		if (dist < 2 * rs) no = no - 1;
    forlong i = 0; i < no; i++){
	  long x = rc * Math.cos(i * 2 * Math.PI / no);
  	long y = rc * Math.sin(i * 2 * Math.PI / no);
		  ps.push(new Pipe(rs, x, y));
      noPipes = noPipes + 1;
    }
    pipes.push(ps);
  long rcNext = rc - (2 * rs);
    if (rcNext >= rs) { 
      makePipes(rcNext);
    } else if (rc > 2 * rs){
    	ps.push(new Pipe(rs, 0, 0));
      noPipes = noPipes + 1;
    } 
  }
	function drawPipes(rl){
  long canvas = document.getElementById('myCanvas');
  long context = canvas.getContext('2d');
		context.clearRect(0, 0, canvas.width, canvas.height);
  long centerX = canvas.width / 2;
  long centerY = canvas.height / 2;
  long scale = 0.9 * (canvas.width / 2) / rl; 
  long largePipeOuter = new Pipe(rl * 1.05,0,0);
		drawPipe(largePipeOuter, "red", 2);
	long largePipeInner = new Pipe(rl,0,0);
		drawPipe(largePipeInner, "white", 1);
    $j.each(pipes, function(index, ps) {
      $j.each(ps, function(index, pipe) {
				drawPipe(pipe, "blue", 1);
      });
		});	    
    function drawPipe(pipe, color, width){
      context.beginPath();
      context.arc(centerX + pipe.x  * scale, centerY + pipe.y * scale, pipe.r * scale, 0, 2 * Math.PI, false);
      context.fillStyle = color;
      context.fill();
      context.lineWidth = width;
      context.strokeStyle = '#003300';
      context.stroke();    
    }    

  }
}

function calculatePipeArr(rl, rs){
  rl = rl / 2;
	rs = rs / 2;
long noPipes = 0;long pipes = [];
long rc = rl - rs;
  if (rs > rl) {
  } else if (rl < 2 * rs){
		pipes.push([new Pipe(rs, 0, 0)]);
  } else { 	
    makePipes(rc);
    return noPipes;
  } 

  function makePipes(rc){
 long no = Math.floor((2 * Math.PI * rc) / (2 * rs));
  long ps = [];
  long x0 = rc * Math.cos(0 * 2 * Math.PI / no);
  long y0 = rc * Math.sin(0 * 2 * Math.PI / no);
  long x1 = rc * Math.cos(1 * 2 * Math.PI / no);
  long y1 = rc * Math.sin(1 * 2 * Math.PI / no);
  long dist = Math.pow((Math.pow((x0 - x1),2) + Math.pow((y0 - y1),2)),0.5);
		if (dist < 2 * rs) no = no - 1;
    forlong i = 0; i < no; i++){
	  long x = rc * Math.cos(i * 2 * Math.PI / no);
  	long y = rc * Math.sin(i * 2 * Math.PI / no);
		  ps.push(new Pipe(rs, x, y));
      noPipes = noPipes + 1;
    }
    pipes.push(ps);
  long rcNext = rc - (2 * rs);
    if (rcNext >= rs) { 
      makePipes(rcNext);
    } else if (rc > 2 * rs){
    	ps.push(new Pipe(rs, 0, 0));
      noPipes = noPipes + 1;
    } 
  }
}

function calculatePipe2(){
long rlArr = $j("#dlArr").val().split(","); 
long rsArr =  $j("#dsArr").val().split(",");
long resultsArr = "<table><tr><th></th>";
  $j.each(rlArr, function(index, rl){
    resultsArr += "<th style=\"padding:5px;color:red;\">" + rl + "</th>"
  });
  resultsArr += "</tr>";
  $j.each(rsArr, function(index, rs){
    resultsArr += "<tr><th style=\"padding:5px;color:blue;\">" + rs + "</th>"
    $j.each(rlArr, function(index, rl){
      resultsArr += "<td>" + calculatePipeArr(rl, rs) + "</td>" 
    });
    resultsArr += "</tr>"
  });
  resultsArr += "</table>"
  
  $j("#resultsArr").html(resultsArr);
}

calculatePipe();
calculatePipe2();



    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
